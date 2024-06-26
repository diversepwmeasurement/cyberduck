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
 * A resource recipient.
 */
@ApiModel(description = "A resource recipient.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class Recipient {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("personalIdentifier")
  private String personalIdentifier = null;

  @JsonProperty("phoneNumber")
  private String phoneNumber = null;

  public Recipient id(String id) {
    this.id = id;
    return this;
  }

   /**
   * The recipient id.
   * @return id
  **/
  @ApiModelProperty(value = "The recipient id.")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public Recipient firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

   /**
   * The recipient firstname.
   * @return firstName
  **/
  @ApiModelProperty(value = "The recipient firstname.")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Recipient lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

   /**
   * The recipient last name.
   * @return lastName
  **/
  @ApiModelProperty(value = "The recipient last name.")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Recipient email(String email) {
    this.email = email;
    return this;
  }

   /**
   * The recipient email.
   * @return email
  **/
  @ApiModelProperty(value = "The recipient email.")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Recipient personalIdentifier(String personalIdentifier) {
    this.personalIdentifier = personalIdentifier;
    return this;
  }

   /**
   * The recipient personal identifier.
   * @return personalIdentifier
  **/
  @ApiModelProperty(value = "The recipient personal identifier.")
  public String getPersonalIdentifier() {
    return personalIdentifier;
  }

  public void setPersonalIdentifier(String personalIdentifier) {
    this.personalIdentifier = personalIdentifier;
  }

  public Recipient phoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
    return this;
  }

   /**
   * The recipient phone number.
   * @return phoneNumber
  **/
  @ApiModelProperty(value = "The recipient phone number.")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recipient recipient = (Recipient) o;
    return Objects.equals(this.id, recipient.id) &&
        Objects.equals(this.firstName, recipient.firstName) &&
        Objects.equals(this.lastName, recipient.lastName) &&
        Objects.equals(this.email, recipient.email) &&
        Objects.equals(this.personalIdentifier, recipient.personalIdentifier) &&
        Objects.equals(this.phoneNumber, recipient.phoneNumber);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName, email, personalIdentifier, phoneNumber);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recipient {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    personalIdentifier: ").append(toIndentedString(personalIdentifier)).append("\n");
    sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
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

