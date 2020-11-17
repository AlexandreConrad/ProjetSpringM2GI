package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;
import org.threeten.bp.OffsetDateTime;

import javax.validation.Valid;
import java.util.Objects;

/**
 * Choice
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")


public class Choice {
    @JsonProperty("id")
    private Long id = null;

    @JsonProperty("option")
    private OffsetDateTime option = null;

    @JsonProperty("answers")
    private ChoicessurveyIDAnswers answers = null;

    public Choice id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Choice option(OffsetDateTime option) {
        this.option = option;
        return this;
    }

    /**
     * Get option
     *
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

    public Choice answers(ChoicessurveyIDAnswers answers) {
        this.answers = answers;
        return this;
    }

    /**
     * Get answers
     *
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
        Choice choice = (Choice) o;
        return Objects.equals(this.id, choice.id) &&
                Objects.equals(this.option, choice.option) &&
                Objects.equals(this.answers, choice.answers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, option, answers);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Choice {\n");

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

