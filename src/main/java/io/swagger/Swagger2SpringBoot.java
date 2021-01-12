package io.swagger;

import io.swagger.api.SurveysApi;
import io.swagger.api.SurveysApiController;
import io.swagger.model.Sondage;
import io.swagger.model.Survey;
import io.swagger.service.SurveyService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.threeten.bp.OffsetDateTime;
import org.threeten.bp.ZoneOffset;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"io.swagger", "io.swagger.api", "io.swagger.configuration"})
public class Swagger2SpringBoot implements CommandLineRunner {

    public static void main(String[] args) {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }


    @Override
    public void run(String... arg0) {

       /* if (OffsetDateTime.of(2020,10,15,15,15,10,100, ZoneOffset.UTC).isBefore(OffsetDateTime.now()))
            System.out.print("CA MARCHE");
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }*/
        //Variables
        String name = "Test du sondage";
        String description = "Test description";
        OffsetDateTime dateTime = OffsetDateTime.of(2020,10,15,15,15,10,100, ZoneOffset.UTC);
        //Timestamp date = Timestamp.valueOf(dateTime.toString());

        //Création d'un sondage
        Sondage survey = new Sondage();
        survey.setEndDate(dateTime);
        survey.setName(name);
        survey.setDescription(description);

        //Fonction createSurvey
        System.out.print("\n" + SurveyService.createSurvey(survey).getEndDate() +"\n");


    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
