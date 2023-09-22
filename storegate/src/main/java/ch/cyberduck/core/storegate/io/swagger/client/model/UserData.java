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
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class UserData {
  @JsonProperty("requireOrganizationNumber")
  private Boolean requireOrganizationNumber = null;

  @JsonProperty("requirePersonalIdentityNumber")
  private Boolean requirePersonalIdentityNumber = null;

  @JsonProperty("showAgreement")
  private Boolean showAgreement = null;

  @JsonProperty("showUserInfo")
  private Boolean showUserInfo = null;

  @JsonProperty("company")
  private String company = null;

  @JsonProperty("organizationNumber")
  private String organizationNumber = null;

  @JsonProperty("personalIdentityNumber")
  private String personalIdentityNumber = null;

  @JsonProperty("countryCode")
  private String countryCode = null;

  @JsonProperty("vatNumber")
  private String vatNumber = null;

  @JsonProperty("newsletter")
  private Boolean newsletter = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  @JsonProperty("forceTwoFactor")
  private Boolean forceTwoFactor = null;

  public UserData requireOrganizationNumber(Boolean requireOrganizationNumber) {
    this.requireOrganizationNumber = requireOrganizationNumber;
    return this;
  }

   /**
   * Is organization number required
   * @return requireOrganizationNumber
  **/
  @ApiModelProperty(value = "Is organization number required")
  public Boolean isRequireOrganizationNumber() {
    return requireOrganizationNumber;
  }

  public void setRequireOrganizationNumber(Boolean requireOrganizationNumber) {
    this.requireOrganizationNumber = requireOrganizationNumber;
  }

  public UserData requirePersonalIdentityNumber(Boolean requirePersonalIdentityNumber) {
    this.requirePersonalIdentityNumber = requirePersonalIdentityNumber;
    return this;
  }

   /**
   * Is social security number required
   * @return requirePersonalIdentityNumber
  **/
  @ApiModelProperty(value = "Is social security number required")
  public Boolean isRequirePersonalIdentityNumber() {
    return requirePersonalIdentityNumber;
  }

  public void setRequirePersonalIdentityNumber(Boolean requirePersonalIdentityNumber) {
    this.requirePersonalIdentityNumber = requirePersonalIdentityNumber;
  }

  public UserData showAgreement(Boolean showAgreement) {
    this.showAgreement = showAgreement;
    return this;
  }

   /**
   * Show the registration agreement
   * @return showAgreement
  **/
  @ApiModelProperty(value = "Show the registration agreement")
  public Boolean isShowAgreement() {
    return showAgreement;
  }

  public void setShowAgreement(Boolean showAgreement) {
    this.showAgreement = showAgreement;
  }

  public UserData showUserInfo(Boolean showUserInfo) {
    this.showUserInfo = showUserInfo;
    return this;
  }

   /**
   * Show the registration user info
   * @return showUserInfo
  **/
  @ApiModelProperty(value = "Show the registration user info")
  public Boolean isShowUserInfo() {
    return showUserInfo;
  }

  public void setShowUserInfo(Boolean showUserInfo) {
    this.showUserInfo = showUserInfo;
  }

  public UserData company(String company) {
    this.company = company;
    return this;
  }

   /**
   * Company name
   * @return company
  **/
  @ApiModelProperty(value = "Company name")
  public String getCompany() {
    return company;
  }

  public void setCompany(String company) {
    this.company = company;
  }

  public UserData organizationNumber(String organizationNumber) {
    this.organizationNumber = organizationNumber;
    return this;
  }

   /**
   * Organization number
   * @return organizationNumber
  **/
  @ApiModelProperty(value = "Organization number")
  public String getOrganizationNumber() {
    return organizationNumber;
  }

  public void setOrganizationNumber(String organizationNumber) {
    this.organizationNumber = organizationNumber;
  }

  public UserData personalIdentityNumber(String personalIdentityNumber) {
    this.personalIdentityNumber = personalIdentityNumber;
    return this;
  }

   /**
   * Social security number
   * @return personalIdentityNumber
  **/
  @ApiModelProperty(value = "Social security number")
  public String getPersonalIdentityNumber() {
    return personalIdentityNumber;
  }

  public void setPersonalIdentityNumber(String personalIdentityNumber) {
    this.personalIdentityNumber = personalIdentityNumber;
  }

  public UserData countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

   /**
   * Country code (ISO 3166-1 alpha-2)
   * @return countryCode
  **/
  @ApiModelProperty(value = "Country code (ISO 3166-1 alpha-2)")
  public String getCountryCode() {
    return countryCode;
  }

  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }

  public UserData vatNumber(String vatNumber) {
    this.vatNumber = vatNumber;
    return this;
  }

   /**
   * VAT number
   * @return vatNumber
  **/
  @ApiModelProperty(value = "VAT number")
  public String getVatNumber() {
    return vatNumber;
  }

  public void setVatNumber(String vatNumber) {
    this.vatNumber = vatNumber;
  }

  public UserData newsletter(Boolean newsletter) {
    this.newsletter = newsletter;
    return this;
  }

   /**
   * Subscribe to newsletter
   * @return newsletter
  **/
  @ApiModelProperty(value = "Subscribe to newsletter")
  public Boolean isNewsletter() {
    return newsletter;
  }

  public void setNewsletter(Boolean newsletter) {
    this.newsletter = newsletter;
  }

  public UserData phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * Phone number
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "Phone number")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public UserData forceTwoFactor(Boolean forceTwoFactor) {
    this.forceTwoFactor = forceTwoFactor;
    return this;
  }

   /**
   * Force Two Factor
   * @return forceTwoFactor
  **/
  @ApiModelProperty(value = "Force Two Factor")
  public Boolean isForceTwoFactor() {
    return forceTwoFactor;
  }

  public void setForceTwoFactor(Boolean forceTwoFactor) {
    this.forceTwoFactor = forceTwoFactor;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserData userData = (UserData) o;
    return Objects.equals(this.requireOrganizationNumber, userData.requireOrganizationNumber) &&
        Objects.equals(this.requirePersonalIdentityNumber, userData.requirePersonalIdentityNumber) &&
        Objects.equals(this.showAgreement, userData.showAgreement) &&
        Objects.equals(this.showUserInfo, userData.showUserInfo) &&
        Objects.equals(this.company, userData.company) &&
        Objects.equals(this.organizationNumber, userData.organizationNumber) &&
        Objects.equals(this.personalIdentityNumber, userData.personalIdentityNumber) &&
        Objects.equals(this.countryCode, userData.countryCode) &&
        Objects.equals(this.vatNumber, userData.vatNumber) &&
        Objects.equals(this.newsletter, userData.newsletter) &&
        Objects.equals(this.phoneNumber, userData.phoneNumber) &&
        Objects.equals(this.forceTwoFactor, userData.forceTwoFactor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(requireOrganizationNumber, requirePersonalIdentityNumber, showAgreement, showUserInfo, company, organizationNumber, personalIdentityNumber, countryCode, vatNumber, newsletter, phoneNumber, forceTwoFactor);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserData {\n");
    
    sb.append("    requireOrganizationNumber: ").append(toIndentedString(requireOrganizationNumber)).append("\n");
    sb.append("    requirePersonalIdentityNumber: ").append(toIndentedString(requirePersonalIdentityNumber)).append("\n");
    sb.append("    showAgreement: ").append(toIndentedString(showAgreement)).append("\n");
    sb.append("    showUserInfo: ").append(toIndentedString(showUserInfo)).append("\n");
    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    organizationNumber: ").append(toIndentedString(organizationNumber)).append("\n");
    sb.append("    personalIdentityNumber: ").append(toIndentedString(personalIdentityNumber)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    vatNumber: ").append(toIndentedString(vatNumber)).append("\n");
    sb.append("    newsletter: ").append(toIndentedString(newsletter)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
    sb.append("    forceTwoFactor: ").append(toIndentedString(forceTwoFactor)).append("\n");
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

