package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ChoicessurveyIDAnswers
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")




public class ChoicessurveyIDAnswers   {
  @JsonProperty("available")
  @Valid
  private List<String> available = null;

  @JsonProperty("unavailable")
  @Valid
  private List<String> unavailable = null;

  @JsonProperty("unknown")
  @Valid
  private List<String> unknown = null;

  public ChoicessurveyIDAnswers available(List<String> available) {
    this.available = available;
    return this;
  }

  public ChoicessurveyIDAnswers addAvailableItem(String availableItem) {
    if (this.available == null) {
      this.available = new ArrayList<String>();
    }
    this.available.add(availableItem);
    return this;
  }

  /**
   * Get available
   * @return available
  **/
  @ApiModelProperty(value = "")


  public List<String> getAvailable() {
    return available;
  }

  public void setAvailable(List<String> available) {
    this.available = available;
  }

  public ChoicessurveyIDAnswers unavailable(List<String> unavailable) {
    this.unavailable = unavailable;
    return this;
  }

  public ChoicessurveyIDAnswers addUnavailableItem(String unavailableItem) {
    if (this.unavailable == null) {
      this.unavailable = new ArrayList<String>();
    }
    this.unavailable.add(unavailableItem);
    return this;
  }

  /**
   * Get unavailable
   * @return unavailable
  **/
  @ApiModelProperty(value = "")


  public List<String> getUnavailable() {
    return unavailable;
  }

  public void setUnavailable(List<String> unavailable) {
    this.unavailable = unavailable;
  }

  public ChoicessurveyIDAnswers unknown(List<String> unknown) {
    this.unknown = unknown;
    return this;
  }

  public ChoicessurveyIDAnswers addUnknownItem(String unknownItem) {
    if (this.unknown == null) {
      this.unknown = new ArrayList<String>();
    }
    this.unknown.add(unknownItem);
    return this;
  }

  /**
   * Get unknown
   * @return unknown
  **/
  @ApiModelProperty(value = "")


  public List<String> getUnknown() {
    return unknown;
  }

  public void setUnknown(List<String> unknown) {
    this.unknown = unknown;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ChoicessurveyIDAnswers choicessurveyIDAnswers = (ChoicessurveyIDAnswers) o;
    return Objects.equals(this.available, choicessurveyIDAnswers.available) &&
        Objects.equals(this.unavailable, choicessurveyIDAnswers.unavailable) &&
        Objects.equals(this.unknown, choicessurveyIDAnswers.unknown);
  }

  @Override
  public int hashCode() {
    return Objects.hash(available, unavailable, unknown);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ChoicessurveyIDAnswers {\n");
    
    sb.append("    available: ").append(toIndentedString(available)).append("\n");
    sb.append("    unavailable: ").append(toIndentedString(unavailable)).append("\n");
    sb.append("    unknown: ").append(toIndentedString(unknown)).append("\n");
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

