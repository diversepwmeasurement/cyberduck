/*
 * Files.com API
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: 0.0.1
 * Contact: support@files.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.brick.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
import org.joda.time.DateTime;
/**
 * ActionNotificationExportsBody
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaClientCodegen", date = "2021-07-25T22:25:43.390877+02:00[Europe/Paris]")
public class ActionNotificationExportsBody {
  @JsonProperty("user_id")
  private Integer userId = null;

  @JsonProperty("start_at")
  private DateTime startAt = null;

  @JsonProperty("end_at")
  private DateTime endAt = null;

  @JsonProperty("query_message")
  private String queryMessage = null;

  @JsonProperty("query_request_method")
  private String queryRequestMethod = null;

  @JsonProperty("query_request_url")
  private String queryRequestUrl = null;

  @JsonProperty("query_status")
  private String queryStatus = null;

  @JsonProperty("query_success")
  private Boolean querySuccess = null;

  @JsonProperty("query_path")
  private String queryPath = null;

  @JsonProperty("query_folder")
  private String queryFolder = null;

  public ActionNotificationExportsBody userId(Integer userId) {
    this.userId = userId;
    return this;
  }

   /**
   * User ID.  Provide a value of &#x60;0&#x60; to operate the current session&#x27;s user.
   * @return userId
  **/
  @Schema(description = "User ID.  Provide a value of `0` to operate the current session's user.")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public ActionNotificationExportsBody startAt(DateTime startAt) {
    this.startAt = startAt;
    return this;
  }

   /**
   * Start date/time of export range.
   * @return startAt
  **/
  @Schema(description = "Start date/time of export range.")
  public DateTime getStartAt() {
    return startAt;
  }

  public void setStartAt(DateTime startAt) {
    this.startAt = startAt;
  }

  public ActionNotificationExportsBody endAt(DateTime endAt) {
    this.endAt = endAt;
    return this;
  }

   /**
   * End date/time of export range.
   * @return endAt
  **/
  @Schema(description = "End date/time of export range.")
  public DateTime getEndAt() {
    return endAt;
  }

  public void setEndAt(DateTime endAt) {
    this.endAt = endAt;
  }

  public ActionNotificationExportsBody queryMessage(String queryMessage) {
    this.queryMessage = queryMessage;
    return this;
  }

   /**
   * Error message associated with the request, if any.
   * @return queryMessage
  **/
  @Schema(example = "Connection Refused", description = "Error message associated with the request, if any.")
  public String getQueryMessage() {
    return queryMessage;
  }

  public void setQueryMessage(String queryMessage) {
    this.queryMessage = queryMessage;
  }

  public ActionNotificationExportsBody queryRequestMethod(String queryRequestMethod) {
    this.queryRequestMethod = queryRequestMethod;
    return this;
  }

   /**
   * The HTTP request method used by the webhook.
   * @return queryRequestMethod
  **/
  @Schema(example = "GET", description = "The HTTP request method used by the webhook.")
  public String getQueryRequestMethod() {
    return queryRequestMethod;
  }

  public void setQueryRequestMethod(String queryRequestMethod) {
    this.queryRequestMethod = queryRequestMethod;
  }

  public ActionNotificationExportsBody queryRequestUrl(String queryRequestUrl) {
    this.queryRequestUrl = queryRequestUrl;
    return this;
  }

   /**
   * The target webhook URL.
   * @return queryRequestUrl
  **/
  @Schema(example = "http://example.com/webhook", description = "The target webhook URL.")
  public String getQueryRequestUrl() {
    return queryRequestUrl;
  }

  public void setQueryRequestUrl(String queryRequestUrl) {
    this.queryRequestUrl = queryRequestUrl;
  }

  public ActionNotificationExportsBody queryStatus(String queryStatus) {
    this.queryStatus = queryStatus;
    return this;
  }

   /**
   * The HTTP status returned from the server in response to the webhook request.
   * @return queryStatus
  **/
  @Schema(example = "200", description = "The HTTP status returned from the server in response to the webhook request.")
  public String getQueryStatus() {
    return queryStatus;
  }

  public void setQueryStatus(String queryStatus) {
    this.queryStatus = queryStatus;
  }

  public ActionNotificationExportsBody querySuccess(Boolean querySuccess) {
    this.querySuccess = querySuccess;
    return this;
  }

   /**
   * true if the webhook request succeeded (i.e. returned a 200 or 204 response status). false otherwise.
   * @return querySuccess
  **/
  @Schema(example = "true", description = "true if the webhook request succeeded (i.e. returned a 200 or 204 response status). false otherwise.")
  public Boolean isQuerySuccess() {
    return querySuccess;
  }

  public void setQuerySuccess(Boolean querySuccess) {
    this.querySuccess = querySuccess;
  }

  public ActionNotificationExportsBody queryPath(String queryPath) {
    this.queryPath = queryPath;
    return this;
  }

   /**
   * Return notifications that were triggered by actions on this specific path.
   * @return queryPath
  **/
  @Schema(example = "MyFile.txt", description = "Return notifications that were triggered by actions on this specific path.")
  public String getQueryPath() {
    return queryPath;
  }

  public void setQueryPath(String queryPath) {
    this.queryPath = queryPath;
  }

  public ActionNotificationExportsBody queryFolder(String queryFolder) {
    this.queryFolder = queryFolder;
    return this;
  }

   /**
   * Return notifications that were triggered by actions in this folder.
   * @return queryFolder
  **/
  @Schema(example = "MyFolder", description = "Return notifications that were triggered by actions in this folder.")
  public String getQueryFolder() {
    return queryFolder;
  }

  public void setQueryFolder(String queryFolder) {
    this.queryFolder = queryFolder;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActionNotificationExportsBody actionNotificationExportsBody = (ActionNotificationExportsBody) o;
    return Objects.equals(this.userId, actionNotificationExportsBody.userId) &&
        Objects.equals(this.startAt, actionNotificationExportsBody.startAt) &&
        Objects.equals(this.endAt, actionNotificationExportsBody.endAt) &&
        Objects.equals(this.queryMessage, actionNotificationExportsBody.queryMessage) &&
        Objects.equals(this.queryRequestMethod, actionNotificationExportsBody.queryRequestMethod) &&
        Objects.equals(this.queryRequestUrl, actionNotificationExportsBody.queryRequestUrl) &&
        Objects.equals(this.queryStatus, actionNotificationExportsBody.queryStatus) &&
        Objects.equals(this.querySuccess, actionNotificationExportsBody.querySuccess) &&
        Objects.equals(this.queryPath, actionNotificationExportsBody.queryPath) &&
        Objects.equals(this.queryFolder, actionNotificationExportsBody.queryFolder);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userId, startAt, endAt, queryMessage, queryRequestMethod, queryRequestUrl, queryStatus, querySuccess, queryPath, queryFolder);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActionNotificationExportsBody {\n");
    
    sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
    sb.append("    startAt: ").append(toIndentedString(startAt)).append("\n");
    sb.append("    endAt: ").append(toIndentedString(endAt)).append("\n");
    sb.append("    queryMessage: ").append(toIndentedString(queryMessage)).append("\n");
    sb.append("    queryRequestMethod: ").append(toIndentedString(queryRequestMethod)).append("\n");
    sb.append("    queryRequestUrl: ").append(toIndentedString(queryRequestUrl)).append("\n");
    sb.append("    queryStatus: ").append(toIndentedString(queryStatus)).append("\n");
    sb.append("    querySuccess: ").append(toIndentedString(querySuccess)).append("\n");
    sb.append("    queryPath: ").append(toIndentedString(queryPath)).append("\n");
    sb.append("    queryFolder: ").append(toIndentedString(queryFolder)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
