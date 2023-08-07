package ch.cyberduck.core.sts;

/*
 * Copyright (c) 2002-2023 iterate GmbH. All rights reserved.
 * https://cyberduck.io/
 *
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 */

import ch.cyberduck.core.LoginCallback;
import ch.cyberduck.core.exception.BackgroundException;
import ch.cyberduck.core.oauth.OAuth2ErrorResponseInterceptor;
import ch.cyberduck.core.oauth.OAuth2RequestInterceptor;
import ch.cyberduck.core.s3.S3Session;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.protocol.HttpContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jets3t.service.security.AWSSessionCredentials;

public class STSAssumeRoleTokenExpiredResponseInterceptor extends OAuth2ErrorResponseInterceptor {
    private static final Logger log = LogManager.getLogger(STSAssumeRoleTokenExpiredResponseInterceptor.class);

    private static final int MAX_RETRIES = 1;

    private final S3Session session;
    private final STSAssumeRoleCredentialsRequestInterceptor service;

    public STSAssumeRoleTokenExpiredResponseInterceptor(final S3Session session,
                                                        final OAuth2RequestInterceptor oauth,
                                                        final STSAssumeRoleCredentialsRequestInterceptor sts,
                                                        final LoginCallback prompt) {
        super(session.getHost(), oauth, prompt);
        this.session = session;
        this.service = sts;
    }

    @Override
    public boolean retryRequest(final HttpResponse response, final int executionCount, final HttpContext context) {
        switch(response.getStatusLine().getStatusCode()) {
            case HttpStatus.SC_UNAUTHORIZED:
                if(!super.retryRequest(response, executionCount, context)) {
                    return false;
                }
        }
        switch(response.getStatusLine().getStatusCode()) {
            case HttpStatus.SC_UNAUTHORIZED:
            case HttpStatus.SC_BAD_REQUEST:
                if(executionCount <= MAX_RETRIES) {
                    try {
                        log.warn(String.format("Attempt to refresh STS token for failure %s", response));
                        final STSTokens tokens = service.refresh();
                        session.getClient().setProviderCredentials(new AWSSessionCredentials(tokens.getAccessKey(),
                                tokens.getSecretAccessKey(), tokens.getSessionToken()));
                        // Try again
                        return true;
                    }
                    catch(BackgroundException e) {
                        log.warn(String.format("Failure %s refreshing STS token", e));
                    }
                }
                else {
                    log.warn(String.format("Skip retry for response %s after %d executions", response, executionCount));
                }
                break;
        }
        return false;
    }
}