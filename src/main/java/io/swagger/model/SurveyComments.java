package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import java.util.Objects;

/**
 * SurveyComments
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")


public class SurveyComments {
    @JsonProperty("id")
    private Integer id = null;

    @JsonProperty("comments")
    private String comments = null;

    public SurveyComments id(Integer id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     *
     * @return id
     **/
    @ApiModelProperty(value = "")


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public SurveyComments comments(String comments) {
        this.comments = comments;
        return this;
    }

    /**
     * Get comments
     *
     * @return comments
     **/
    @ApiModelProperty(value = "")


    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SurveyComments surveyComments = (SurveyComments) o;
        return Objects.equals(this.id, surveyComments.id) &&
                Objects.equals(this.comments, surveyComments.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SurveyComments {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
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

