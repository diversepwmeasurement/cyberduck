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
import ch.cyberduck.core.storegate.io.swagger.client.model.SalepackageProduct;
import ch.cyberduck.core.storegate.io.swagger.client.model.SalepackageSingleProduct;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class SalepackageProducts {
  @JsonProperty("storage")
  private SalepackageProduct storage = null;

  @JsonProperty("multi")
  private SalepackageProduct multi = null;

  @JsonProperty("backup")
  private SalepackageProduct backup = null;

  @JsonProperty("sync")
  private SalepackageProduct sync = null;

  @JsonProperty("bankID")
  private SalepackageProduct bankID = null;

  @JsonProperty("branding")
  private SalepackageSingleProduct branding = null;

  @JsonProperty("signing")
  private SalepackageProduct signing = null;

  @JsonProperty("access")
  private SalepackageSingleProduct access = null;

  public SalepackageProducts storage(SalepackageProduct storage) {
    this.storage = storage;
    return this;
  }

   /**
   * 
   * @return storage
  **/
  @ApiModelProperty(value = "")
  public SalepackageProduct getStorage() {
    return storage;
  }

  public void setStorage(SalepackageProduct storage) {
    this.storage = storage;
  }

  public SalepackageProducts multi(SalepackageProduct multi) {
    this.multi = multi;
    return this;
  }

   /**
   * 
   * @return multi
  **/
  @ApiModelProperty(value = "")
  public SalepackageProduct getMulti() {
    return multi;
  }

  public void setMulti(SalepackageProduct multi) {
    this.multi = multi;
  }

  public SalepackageProducts backup(SalepackageProduct backup) {
    this.backup = backup;
    return this;
  }

   /**
   * 
   * @return backup
  **/
  @ApiModelProperty(value = "")
  public SalepackageProduct getBackup() {
    return backup;
  }

  public void setBackup(SalepackageProduct backup) {
    this.backup = backup;
  }

  public SalepackageProducts sync(SalepackageProduct sync) {
    this.sync = sync;
    return this;
  }

   /**
   * 
   * @return sync
  **/
  @ApiModelProperty(value = "")
  public SalepackageProduct getSync() {
    return sync;
  }

  public void setSync(SalepackageProduct sync) {
    this.sync = sync;
  }

  public SalepackageProducts bankID(SalepackageProduct bankID) {
    this.bankID = bankID;
    return this;
  }

   /**
   * 
   * @return bankID
  **/
  @ApiModelProperty(value = "")
  public SalepackageProduct getBankID() {
    return bankID;
  }

  public void setBankID(SalepackageProduct bankID) {
    this.bankID = bankID;
  }

  public SalepackageProducts branding(SalepackageSingleProduct branding) {
    this.branding = branding;
    return this;
  }

   /**
   * 
   * @return branding
  **/
  @ApiModelProperty(value = "")
  public SalepackageSingleProduct getBranding() {
    return branding;
  }

  public void setBranding(SalepackageSingleProduct branding) {
    this.branding = branding;
  }

  public SalepackageProducts signing(SalepackageProduct signing) {
    this.signing = signing;
    return this;
  }

   /**
   * 
   * @return signing
  **/
  @ApiModelProperty(value = "")
  public SalepackageProduct getSigning() {
    return signing;
  }

  public void setSigning(SalepackageProduct signing) {
    this.signing = signing;
  }

  public SalepackageProducts access(SalepackageSingleProduct access) {
    this.access = access;
    return this;
  }

   /**
   * 
   * @return access
  **/
  @ApiModelProperty(value = "")
  public SalepackageSingleProduct getAccess() {
    return access;
  }

  public void setAccess(SalepackageSingleProduct access) {
    this.access = access;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SalepackageProducts salepackageProducts = (SalepackageProducts) o;
    return Objects.equals(this.storage, salepackageProducts.storage) &&
        Objects.equals(this.multi, salepackageProducts.multi) &&
        Objects.equals(this.backup, salepackageProducts.backup) &&
        Objects.equals(this.sync, salepackageProducts.sync) &&
        Objects.equals(this.bankID, salepackageProducts.bankID) &&
        Objects.equals(this.branding, salepackageProducts.branding) &&
        Objects.equals(this.signing, salepackageProducts.signing) &&
        Objects.equals(this.access, salepackageProducts.access);
  }

  @Override
  public int hashCode() {
    return Objects.hash(storage, multi, backup, sync, bankID, branding, signing, access);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SalepackageProducts {\n");
    
    sb.append("    storage: ").append(toIndentedString(storage)).append("\n");
    sb.append("    multi: ").append(toIndentedString(multi)).append("\n");
    sb.append("    backup: ").append(toIndentedString(backup)).append("\n");
    sb.append("    sync: ").append(toIndentedString(sync)).append("\n");
    sb.append("    bankID: ").append(toIndentedString(bankID)).append("\n");
    sb.append("    branding: ").append(toIndentedString(branding)).append("\n");
    sb.append("    signing: ").append(toIndentedString(signing)).append("\n");
    sb.append("    access: ").append(toIndentedString(access)).append("\n");
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

