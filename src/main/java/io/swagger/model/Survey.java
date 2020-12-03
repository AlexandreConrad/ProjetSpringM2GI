package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.sql.Timestamp;


/**
 * Survey
 */

/** Lombok */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor // Constructeur par défaut impossible
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id_survey", "name", "description", "isAvailable", "endDate"})
@ToString(of = {"id_survey", "name", "description", "isAvailable", "endDate"})

/** Hibernate*/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Survey implements Serializable {

    @JsonProperty("id_survey")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_survey;

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
    Timestamp endDate;

}