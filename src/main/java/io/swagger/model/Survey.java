package io.swagger.model;

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
 * Survey
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
@EqualsAndHashCode(of = {"idSurvey", "name", "description", "isAvailable", "endDate"})
@ToString(of = {"idSurvey", "name", "description", "isAvailable", "endDate"})

/** Hibernate*/
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Survey implements Serializable {

    @JsonProperty("idSurvey")
    @ApiModelProperty(hidden = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_SURVEY")
    Long idSurvey;

    @JsonProperty("name")
    @NonNull
    @Column(name = "NAME")
    String name;

    @JsonProperty("description")
    @NonNull
    @Column(name = "DESCRIPTION")
    String description;

    @JsonProperty("isAvailable")
    @NonNull
    @Column(name = "IS_AVAILABLE")
    Boolean isAvailable;

    @JsonProperty("endDate")
    @NonNull
    @Column(name = "END_DATE")
    Timestamp endDate;

    @OneToMany(targetEntity = Choice.class, fetch = FetchType.LAZY, mappedBy = "idSurvey")
    @ApiModelProperty(hidden = true)
    @JsonIgnore
    List<Choice> choices;

}
