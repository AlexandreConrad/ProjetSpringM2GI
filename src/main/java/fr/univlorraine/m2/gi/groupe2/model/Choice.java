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
import java.sql.Timestamp;
import java.util.List;

/**
 * Choice
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
public class Choice implements Serializable {

    @JsonProperty("idChoice")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_CHOICE")
    Long idChoice;

    @JsonProperty("date")
    @NonNull
    @Column(name = "DATE")
    Timestamp date;

    @JsonProperty("idSurvey")
    @NonNull
    @Column(name = "ID_SURVEY")
    Long idSurvey;

    @OneToMany(targetEntity = Vote.class, mappedBy = "idChoice", fetch = FetchType.LAZY)
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    List<Vote> votes;
}

