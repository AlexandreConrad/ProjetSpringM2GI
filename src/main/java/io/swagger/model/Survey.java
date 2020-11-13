package io.swagger.model;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.Entity;
import org.threeten.bp.OffsetDateTime;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;


/**  Survey */

/** Lombok */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")
@FieldDefaults(level= AccessLevel.PRIVATE)
@RequiredArgsConstructor // Constructeur par défaut impossible
@Getter
@Setter
@EqualsAndHashCode(of= {"id","name","description","isAvailable","endDate"})
@ToString(of= {"id","name","description","isAvailable","endDate"})

/** Hibernate*/
@Entity
@Table(name="SURVEYS")
public class Survey implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("id_survey")
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="ID_SURVEY")
  int id_survey;

  @JsonProperty("name")
  @NonNull
  @Column(name="NAME")
  String name;

  @JsonProperty("description")
  @NonNull
  @Column(name="DESCRIPTION")
  String description;

  @JsonProperty("isAvailable")
  @NonNull
  @Column(name="ISAVAILABLE")
  Boolean isAvailable = false;

  @JsonProperty("endDate")
  @NonNull
  @Column(name="ENDDATE")
  Date endDate;
}