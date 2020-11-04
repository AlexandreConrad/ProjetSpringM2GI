package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Choice;
import io.swagger.model.SurveyComments;
import java.util.ArrayList;
import java.util.List;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Survey
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")
@FieldDefaults(level= AccessLevel.PRIVATE)
@RequiredArgsConstructor // Constructeur par défaut impossible
@Getter
@Setter
@EqualsAndHashCode(of= {"id","name","description","isAvailable","endDate","comments","votes"})
@ToString(of= {"id","name","description","isAvailable","endDate","comments","votes"})
public class Survey   {

  @JsonProperty("id")
  Long id = null;

  @JsonProperty("name")
  @NonNull
  String name = null;

  @JsonProperty("description")
  @NonNull
  String description = null;

  @JsonProperty("isAvailable")
  Boolean isAvailable = false;

  @JsonProperty("endDate")
  @NonNull
  OffsetDateTime endDate = null;

  @JsonProperty("comments")
  @Valid
  List<SurveyComments> comments = null;

  @JsonProperty("votes")
  @Valid
  List<Choice> votes = null;
}