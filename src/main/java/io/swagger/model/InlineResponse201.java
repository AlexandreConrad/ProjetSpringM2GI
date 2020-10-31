package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * InlineResponse201
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")




public class InlineResponse201   {
  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("isAvailable")
  private Boolean isAvailable = null;

  @JsonProperty("endDate")
  private OffsetDateTime endDate = null;

  @JsonProperty("comments")
  @Valid
  private List<Object> comments = null;

  @JsonProperty("votes")
  @Valid
  private List<Object> votes = null;

  public InlineResponse201 id(Long id) {
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

  public InlineResponse201 name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public InlineResponse201 description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
  **/
  @ApiModelProperty(value = "")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public InlineResponse201 isAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
    return this;
  }

  /**
   * Get isAvailable
   * @return isAvailable
  **/
  @ApiModelProperty(value = "")


  public Boolean isIsAvailable() {
    return isAvailable;
  }

  public void setIsAvailable(Boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  public InlineResponse201 endDate(OffsetDateTime endDate) {
    this.endDate = endDate;
    return this;
  }

  /**
   * Get endDate
   * @return endDate
  **/
  @ApiModelProperty(value = "")

  @Valid

  public OffsetDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(OffsetDateTime endDate) {
    this.endDate = endDate;
  }

  public InlineResponse201 comments(List<Object> comments) {
    this.comments = comments;
    return this;
  }

  public InlineResponse201 addCommentsItem(Object commentsItem) {
    if (this.comments == null) {
      this.comments = new ArrayList<Object>();
    }
    this.comments.add(commentsItem);
    return this;
  }

  /**
   * Get comments
   * @return comments
  **/
  @ApiModelProperty(value = "")


  public List<Object> getComments() {
    return comments;
  }

  public void setComments(List<Object> comments) {
    this.comments = comments;
  }

  public InlineResponse201 votes(List<Object> votes) {
    this.votes = votes;
    return this;
  }

  public InlineResponse201 addVotesItem(Object votesItem) {
    if (this.votes == null) {
      this.votes = new ArrayList<Object>();
    }
    this.votes.add(votesItem);
    return this;
  }

  /**
   * Get votes
   * @return votes
  **/
  @ApiModelProperty(value = "")


  public List<Object> getVotes() {
    return votes;
  }

  public void setVotes(List<Object> votes) {
    this.votes = votes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    InlineResponse201 inlineResponse201 = (InlineResponse201) o;
    return Objects.equals(this.id, inlineResponse201.id) &&
        Objects.equals(this.name, inlineResponse201.name) &&
        Objects.equals(this.description, inlineResponse201.description) &&
        Objects.equals(this.isAvailable, inlineResponse201.isAvailable) &&
        Objects.equals(this.endDate, inlineResponse201.endDate) &&
        Objects.equals(this.comments, inlineResponse201.comments) &&
        Objects.equals(this.votes, inlineResponse201.votes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description, isAvailable, endDate, comments, votes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class InlineResponse201 {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    isAvailable: ").append(toIndentedString(isAvailable)).append("\n");
    sb.append("    endDate: ").append(toIndentedString(endDate)).append("\n");
    sb.append("    comments: ").append(toIndentedString(comments)).append("\n");
    sb.append("    votes: ").append(toIndentedString(votes)).append("\n");
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

