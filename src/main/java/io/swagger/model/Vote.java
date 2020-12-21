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

/**
 * Vote
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
@EqualsAndHashCode(of = {"id_vote", "author", "id_choices", "id_option"})
@ToString(of = {"id_vote", "author", "id_choices", "id_option"})

/** Hibernate*/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote implements Serializable {

    @JsonProperty("id_vote")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id_vote;

    @JsonProperty("name")
    @NonNull
    String author;

    @JsonProperty("id_choices")
    @NonNull
    Long id_choices;

    @JsonProperty("id_option")
    @NonNull
    Long id_option;

}
