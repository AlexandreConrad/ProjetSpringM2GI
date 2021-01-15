package fr.univlorraine.m2.gi.groupe2.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Vote
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
@Data // annotation is the combination of @ToString, @EqualsAndHashCode, @Getter and @Setter.

/** Hibernate*/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Vote implements Serializable {

    @JsonProperty("idVote")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_VOTE")
    Long idVote;

    @JsonProperty("author")
    @NonNull
    @Column(name = "AUTHOR")
    String author;

    @JsonProperty("idChoice")
    @NonNull
    @Column(name = "ID_CHOICE")
    Long idChoice;

    @JsonProperty("idOption")
    @NonNull
    @Column(name = "ID_OPTION")
    Long idOption;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    @ApiModelProperty(hidden = true)
    @JoinColumn(name = "ID_OPTION", referencedColumnName = "ID_OPTION", insertable = false, updatable = false)
    Option option ;
}
