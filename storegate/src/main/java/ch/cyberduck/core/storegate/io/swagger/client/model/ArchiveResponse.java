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
 * Archive
 */
@ApiModel(description = "Archive")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaClientCodegen", date = "2023-08-24T11:36:23.792+02:00")
public class ArchiveResponse {
  @JsonProperty("id")
  private String id = null;

  @JsonProperty("filename")
  private String filename = null;

  @JsonProperty("size")
  private Long size = null;

  @JsonProperty("downloadUrl")
  private String downloadUrl = null;

  public ArchiveResponse id(String id) {
    this.id = id;
    return this;
  }

   /**
   * Ideentifier
   * @return id
  **/
  @ApiModelProperty(value = "Ideentifier")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public ArchiveResponse filename(String filename) {
    this.filename = filename;
    return this;
  }

   /**
   * Archive filename
   * @return filename
  **/
  @ApiModelProperty(value = "Archive filename")
  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public ArchiveResponse size(Long size) {
    this.size = size;
    return this;
  }

   /**
   * Archive size
   * @return size
  **/
  @ApiModelProperty(value = "Archive size")
  public Long getSize() {
    return size;
  }

  public void setSize(Long size) {
    this.size = size;
  }

  public ArchiveResponse downloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
    return this;
  }

   /**
   * Download uri for this archive.
   * @return downloadUrl
  **/
  @ApiModelProperty(value = "Download uri for this archive.")
  public String getDownloadUrl() {
    return downloadUrl;
  }

  public void setDownloadUrl(String downloadUrl) {
    this.downloadUrl = downloadUrl;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ArchiveResponse archiveResponse = (ArchiveResponse) o;
    return Objects.equals(this.id, archiveResponse.id) &&
        Objects.equals(this.filename, archiveResponse.filename) &&
        Objects.equals(this.size, archiveResponse.size) &&
        Objects.equals(this.downloadUrl, archiveResponse.downloadUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, filename, size, downloadUrl);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ArchiveResponse {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
    sb.append("    size: ").append(toIndentedString(size)).append("\n");
    sb.append("    downloadUrl: ").append(toIndentedString(downloadUrl)).append("\n");
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

