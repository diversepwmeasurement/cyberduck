/*
 * Storegate api v4.2
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v4.2
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package ch.cyberduck.core.storegate.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A Update subscription request object
 */
@ApiModel(description = "A Update subscription request object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class UpdateSubscriptionRequest {
  @JsonProperty("salepackageId")
  private String salepackageId = null;

  @JsonProperty("storageId")
  private String storageId = null;

  @JsonProperty("multiId")
  private String multiId = null;

  @JsonProperty("backupId")
  private String backupId = null;

  @JsonProperty("syncId")
  private String syncId = null;

  @JsonProperty("bankIDId")
  private String bankIDId = null;

  @JsonProperty("brandingId")
  private String brandingId = null;

  @JsonProperty("signingId")
  private String signingId = null;

  @JsonProperty("accessId")
  private String accessId = null;

  @JsonProperty("url")
  private String url = null;

  public UpdateSubscriptionRequest salepackageId(String salepackageId) {
    this.salepackageId = salepackageId;
    return this;
  }

   /**
   * 
   * @return salepackageId
  **/
  @ApiModelProperty(value = "")
  public String getSalepackageId() {
    return salepackageId;
  }

  public void setSalepackageId(String salepackageId) {
    this.salepackageId = salepackageId;
  }

  public UpdateSubscriptionRequest storageId(String storageId) {
    this.storageId = storageId;
    return this;
  }

   /**
   * 
   * @return storageId
  **/
  @ApiModelProperty(value = "")
  public String getStorageId() {
    return storageId;
  }

  public void setStorageId(String storageId) {
    this.storageId = storageId;
  }

  public UpdateSubscriptionRequest multiId(String multiId) {
    this.multiId = multiId;
    return this;
  }

   /**
   * 
   * @return multiId
  **/
  @ApiModelProperty(value = "")
  public String getMultiId() {
    return multiId;
  }

  public void setMultiId(String multiId) {
    this.multiId = multiId;
  }

  public UpdateSubscriptionRequest backupId(String backupId) {
    this.backupId = backupId;
    return this;
  }

   /**
   * 
   * @return backupId
  **/
  @ApiModelProperty(value = "")
  public String getBackupId() {
    return backupId;
  }

  public void setBackupId(String backupId) {
    this.backupId = backupId;
  }

  public UpdateSubscriptionRequest syncId(String syncId) {
    this.syncId = syncId;
    return this;
  }

   /**
   * 
   * @return syncId
  **/
  @ApiModelProperty(value = "")
  public String getSyncId() {
    return syncId;
  }

  public void setSyncId(String syncId) {
    this.syncId = syncId;
  }

  public UpdateSubscriptionRequest bankIDId(String bankIDId) {
    this.bankIDId = bankIDId;
    return this;
  }

   /**
   * 
   * @return bankIDId
  **/
  @ApiModelProperty(value = "")
  public String getBankIDId() {
    return bankIDId;
  }

  public void setBankIDId(String bankIDId) {
    this.bankIDId = bankIDId;
  }

  public UpdateSubscriptionRequest brandingId(String brandingId) {
    this.brandingId = brandingId;
    return this;
  }

   /**
   * 
   * @return brandingId
  **/
  @ApiModelProperty(value = "")
  public String getBrandingId() {
    return brandingId;
  }

  public void setBrandingId(String brandingId) {
    this.brandingId = brandingId;
  }

  public UpdateSubscriptionRequest signingId(String signingId) {
    this.signingId = signingId;
    return this;
  }

   /**
   * 
   * @return signingId
  **/
  @ApiModelProperty(value = "")
  public String getSigningId() {
    return signingId;
  }

  public void setSigningId(String signingId) {
    this.signingId = signingId;
  }

  public UpdateSubscriptionRequest accessId(String accessId) {
    this.accessId = accessId;
    return this;
  }

   /**
   * 
   * @return accessId
  **/
  @ApiModelProperty(value = "")
  public String getAccessId() {
    return accessId;
  }

  public void setAccessId(String accessId) {
    this.accessId = accessId;
  }

  public UpdateSubscriptionRequest url(String url) {
    this.url = url;
    return this;
  }

   /**
   * 
   * @return url
  **/
  @ApiModelProperty(value = "")
  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UpdateSubscriptionRequest updateSubscriptionRequest = (UpdateSubscriptionRequest) o;
    return Objects.equals(this.salepackageId, updateSubscriptionRequest.salepackageId) &&
        Objects.equals(this.storageId, updateSubscriptionRequest.storageId) &&
        Objects.equals(this.multiId, updateSubscriptionRequest.multiId) &&
        Objects.equals(this.backupId, updateSubscriptionRequest.backupId) &&
        Objects.equals(this.syncId, updateSubscriptionRequest.syncId) &&
        Objects.equals(this.bankIDId, updateSubscriptionRequest.bankIDId) &&
        Objects.equals(this.brandingId, updateSubscriptionRequest.brandingId) &&
        Objects.equals(this.signingId, updateSubscriptionRequest.signingId) &&
        Objects.equals(this.accessId, updateSubscriptionRequest.accessId) &&
        Objects.equals(this.url, updateSubscriptionRequest.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salepackageId, storageId, multiId, backupId, syncId, bankIDId, brandingId, signingId, accessId, url);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UpdateSubscriptionRequest {\n");
    
    sb.append("    salepackageId: ").append(toIndentedString(salepackageId)).append("\n");
    sb.append("    storageId: ").append(toIndentedString(storageId)).append("\n");
    sb.append("    multiId: ").append(toIndentedString(multiId)).append("\n");
    sb.append("    backupId: ").append(toIndentedString(backupId)).append("\n");
    sb.append("    syncId: ").append(toIndentedString(syncId)).append("\n");
    sb.append("    bankIDId: ").append(toIndentedString(bankIDId)).append("\n");
    sb.append("    brandingId: ").append(toIndentedString(brandingId)).append("\n");
    sb.append("    signingId: ").append(toIndentedString(signingId)).append("\n");
    sb.append("    accessId: ").append(toIndentedString(accessId)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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

