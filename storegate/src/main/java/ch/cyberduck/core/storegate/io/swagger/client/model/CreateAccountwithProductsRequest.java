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
import ch.cyberduck.core.storegate.io.swagger.client.model.CreateAccountSalepackageProducts;
import ch.cyberduck.core.storegate.io.swagger.client.model.UpdatePaymentRequest;
import ch.cyberduck.core.storegate.io.swagger.client.model.UserDataRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * A CreateAccountRequest object
 */
@ApiModel(description = "A CreateAccountRequest object")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class CreateAccountwithProductsRequest {
  @JsonProperty("salepackage")
  private CreateAccountSalepackageProducts salepackage = null;

  @JsonProperty("userData")
  private UserDataRequest userData = null;

  @JsonProperty("paymentData")
  private UpdatePaymentRequest paymentData = null;

  @JsonProperty("saleReference")
  private String saleReference = null;

  @JsonProperty("username")
  private String username = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("eIdSessionId")
  private String eIdSessionId = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  public CreateAccountwithProductsRequest salepackage(CreateAccountSalepackageProducts salepackage) {
    this.salepackage = salepackage;
    return this;
  }

   /**
   * The salepackage
   * @return salepackage
  **/
  @ApiModelProperty(value = "The salepackage")
  public CreateAccountSalepackageProducts getSalepackage() {
    return salepackage;
  }

  public void setSalepackage(CreateAccountSalepackageProducts salepackage) {
    this.salepackage = salepackage;
  }

  public CreateAccountwithProductsRequest userData(UserDataRequest userData) {
    this.userData = userData;
    return this;
  }

   /**
   * User information
   * @return userData
  **/
  @ApiModelProperty(value = "User information")
  public UserDataRequest getUserData() {
    return userData;
  }

  public void setUserData(UserDataRequest userData) {
    this.userData = userData;
  }

  public CreateAccountwithProductsRequest paymentData(UpdatePaymentRequest paymentData) {
    this.paymentData = paymentData;
    return this;
  }

   /**
   * Payment information
   * @return paymentData
  **/
  @ApiModelProperty(value = "Payment information")
  public UpdatePaymentRequest getPaymentData() {
    return paymentData;
  }

  public void setPaymentData(UpdatePaymentRequest paymentData) {
    this.paymentData = paymentData;
  }

  public CreateAccountwithProductsRequest saleReference(String saleReference) {
    this.saleReference = saleReference;
    return this;
  }

   /**
   * Id of the sales person used in direct flow
   * @return saleReference
  **/
  @ApiModelProperty(value = "Id of the sales person used in direct flow")
  public String getSaleReference() {
    return saleReference;
  }

  public void setSaleReference(String saleReference) {
    this.saleReference = saleReference;
  }

  public CreateAccountwithProductsRequest username(String username) {
    this.username = username;
    return this;
  }

   /**
   * The Username
   * @return username
  **/
  @ApiModelProperty(value = "The Username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public CreateAccountwithProductsRequest password(String password) {
    this.password = password;
    return this;
  }

   /**
   * The Password
   * @return password
  **/
  @ApiModelProperty(value = "The Password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public CreateAccountwithProductsRequest eIdSessionId(String eIdSessionId) {
    this.eIdSessionId = eIdSessionId;
    return this;
  }

   /**
   * Used with eID
   * @return eIdSessionId
  **/
  @ApiModelProperty(value = "Used with eID")
  public String getEIdSessionId() {
    return eIdSessionId;
  }

  public void setEIdSessionId(String eIdSessionId) {
    this.eIdSessionId = eIdSessionId;
  }

  public CreateAccountwithProductsRequest email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The Email
   * @return email
  **/
  @ApiModelProperty(value = "The Email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateAccountwithProductsRequest firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * The FirstName
   * @return firstName
  **/
  @ApiModelProperty(value = "The FirstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public CreateAccountwithProductsRequest lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * The LastName
   * @return lastName
  **/
  @ApiModelProperty(value = "The LastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateAccountwithProductsRequest createAccountwithProductsRequest = (CreateAccountwithProductsRequest) o;
    return Objects.equals(this.salepackage, createAccountwithProductsRequest.salepackage) &&
        Objects.equals(this.userData, createAccountwithProductsRequest.userData) &&
        Objects.equals(this.paymentData, createAccountwithProductsRequest.paymentData) &&
        Objects.equals(this.saleReference, createAccountwithProductsRequest.saleReference) &&
        Objects.equals(this.username, createAccountwithProductsRequest.username) &&
        Objects.equals(this.password, createAccountwithProductsRequest.password) &&
        Objects.equals(this.eIdSessionId, createAccountwithProductsRequest.eIdSessionId) &&
        Objects.equals(this.email, createAccountwithProductsRequest.email) &&
        Objects.equals(this.firstName, createAccountwithProductsRequest.firstName) &&
        Objects.equals(this.lastName, createAccountwithProductsRequest.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(salepackage, userData, paymentData, saleReference, username, password, eIdSessionId, email, firstName, lastName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateAccountwithProductsRequest {\n");
    
    sb.append("    salepackage: ").append(toIndentedString(salepackage)).append("\n");
    sb.append("    userData: ").append(toIndentedString(userData)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
    sb.append("    saleReference: ").append(toIndentedString(saleReference)).append("\n");
    sb.append("    username: ").append(toIndentedString(username)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    eIdSessionId: ").append(toIndentedString(eIdSessionId)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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

