package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.ChoicessurveyIDAnswers;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse200
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")




public class InlineResponse200   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("option")
  private OffsetDateTime option = null;

  @JsonProperty("answers")
  private ChoicessurveyIDAnswers answers = null;

  public InlineResponse200 id(Long id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  **/
  @ApiModelProperty(value = "")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public InlineResponse200 option(OffsetDateTime option) {
    this.option = option;
    return this;
  }

  /**
   * Get option
   * @return option
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getOption() {
    return option;
  }

  public void setOption(OffsetDateTime option) {
    this.option = option;
  }

  public InlineResponse200 answers(ChoicessurveyIDAnswers answers) {
    this.answers = answers;
    return this;
  }

  /**
   * Get answers
   * @return answers
  **/
  @ApiModelProperty(value = "")

  @Valid

  public ChoicessurveyIDAnswers getAnswers() {
    return answers;
  }

  public void setAnswers(ChoicessurveyIDAnswers answers) {
    this.answers = answers;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse200 inlineResponse200 = (InlineResponse200) o;
    return Objects.equals(this.id, inlineResponse200.id) &&
        Objects.equals(this.option, inlineResponse200.option) &&
        Objects.equals(this.answers, inlineResponse200.answers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, option, answers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse200 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    option: ").append(toIndentedString(option)).append("\n");
    sb.append("    answers: ").append(toIndentedString(answers)).append("\n");
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

