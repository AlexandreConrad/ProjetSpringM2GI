package io.swagger.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;


/**  Survey */

/** Lombok */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")
@FieldDefaults(level= AccessLevel.PRIVATE)
@RequiredArgsConstructor // Constructeur par défaut impossible
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of= {"id","name","description","isAvailable","endDate"})
@ToString(of= {"id","name","description","isAvailable","endDate"})

/** Hibernate*/
@Entity
public class Survey implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id_survey")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id_survey;

  @JsonProperty("name")
  @NonNull
  String name;

  @JsonProperty("description")
  @NonNull
  String description;

  @JsonProperty("isAvailable")
  @NonNull
  Boolean isAvailable;

  @JsonProperty("endDate")
  @NonNull
  Date endDate;
}