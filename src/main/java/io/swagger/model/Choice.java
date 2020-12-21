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
 * Choice
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
@EqualsAndHashCode(of = {"id_choices", "date", "id_survey"})
@ToString(of = {"id_choices", "date", "id_survey"})

/** Hibernate*/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Choice implements Serializable {

    @JsonProperty("id_choices")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_choices;

    @JsonProperty("date")
    @NonNull
    Timestamp date;

    @JsonProperty("id_survey")
    @NonNull
    Long id_survey;

}

