package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Comment
 */

/**
 * Lombok
 */
@Validated
//@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-10-31T12:55:18.203Z")
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor // Constructeur par défaut impossible
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"idComment", "comment", "author", "idSurvey"})
@ToString(of = {"idComment", "comment", "author", "idSurvey"})

/** Hibernate*/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Comment implements Serializable {

    @JsonProperty("idComment")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMMENT")
    Integer idComment;

    @JsonProperty("comment")
    @NonNull
    @Column(name = "COMMENT")
    String comment;

    @JsonProperty("author")
    @NonNull
    @Column(name = "AUTHOR")
    String author;

    @JsonProperty("idSurvey")
    @NonNull
    @Column(name = "ID_SURVEY")
    Long idSurvey;

}

