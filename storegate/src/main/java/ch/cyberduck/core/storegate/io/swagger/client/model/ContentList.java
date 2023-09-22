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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 */
@ApiModel(description = "")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class ContentList {
  @JsonProperty("locale")
  private String locale = null;

  @JsonProperty("contents")
  private Map<String, String> contents = null;

  public ContentList locale(String locale) {
    this.locale = locale;
    return this;
  }

   /**
   * 
   * @return locale
  **/
  @ApiModelProperty(value = "")
  public String getLocale() {
    return locale;
  }

  public void setLocale(String locale) {
    this.locale = locale;
  }

  public ContentList contents(Map<String, String> contents) {
    this.contents = contents;
    return this;
  }

  public ContentList putContentsItem(String key, String contentsItem) {
    if (this.contents == null) {
      this.contents = new HashMap<>();
    }
    this.contents.put(key, contentsItem);
    return this;
  }

   /**
   * 
   * @return contents
  **/
  @ApiModelProperty(value = "")
  public Map<String, String> getContents() {
    return contents;
  }

  public void setContents(Map<String, String> contents) {
    this.contents = contents;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ContentList contentList = (ContentList) o;
    return Objects.equals(this.locale, contentList.locale) &&
        Objects.equals(this.contents, contentList.contents);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locale, contents);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ContentList {\n");
    
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    contents: ").append(toIndentedString(contents)).append("\n");
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

