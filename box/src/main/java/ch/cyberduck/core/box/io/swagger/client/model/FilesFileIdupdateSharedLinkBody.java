/*
 * Box Platform API
 * [Box Platform](https://box.dev) provides functionality to provide access to content stored within [Box](https://box.com). It provides endpoints for basic manipulation of files and folders, management of users within an enterprise, as well as more complex topics such as legal holds and retention policies.
 *
 * OpenAPI spec version: 2.0.0
 * Contact: devrel@box.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */

package ch.cyberduck.core.box.io.swagger.client.model;

import java.util.Objects;
import java.util.Arrays;
import ch.cyberduck.core.box.io.swagger.client.model.FilesfileIdupdateSharedLinkSharedLink;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.v3.oas.annotations.media.Schema;
/**
 * FilesFileIdupdateSharedLinkBody
 */


public class FilesFileIdupdateSharedLinkBody {
  @JsonProperty("shared_link")
  private FilesfileIdupdateSharedLinkSharedLink sharedLink = null;

  public FilesFileIdupdateSharedLinkBody sharedLink(FilesfileIdupdateSharedLinkSharedLink sharedLink) {
    this.sharedLink = sharedLink;
    return this;
  }

   /**
   * Get sharedLink
   * @return sharedLink
  **/
  @Schema(description = "")
  public FilesfileIdupdateSharedLinkSharedLink getSharedLink() {
    return sharedLink;
  }

  public void setSharedLink(FilesfileIdupdateSharedLinkSharedLink sharedLink) {
    this.sharedLink = sharedLink;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FilesFileIdupdateSharedLinkBody filesFileIdupdateSharedLinkBody = (FilesFileIdupdateSharedLinkBody) o;
    return Objects.equals(this.sharedLink, filesFileIdupdateSharedLinkBody.sharedLink);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sharedLink);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FilesFileIdupdateSharedLinkBody {\n");
    
    sb.append("    sharedLink: ").append(toIndentedString(sharedLink)).append("\n");
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
