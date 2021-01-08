package io.swagger.service;

import io.swagger.api.AnalyticsApiController;
import io.swagger.model.Choice;
import io.swagger.model.Option;
import io.swagger.model.Survey;
import io.swagger.model.Vote;
import io.swagger.resolvers.AvailableIOptionResolver;
import io.swagger.resolvers.IOptionResolver;
import io.swagger.resolvers.MaybeIOptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Service pour toutes les requêtes BDD en liaison "Analytics"
 */
public class AnalyticsService {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsApiController.class);

    /**
     * Retourne la date qui dispose du plus de "Disponible" et "Peut-être"
     *
     * @return MostMaybe
     */
    public static Choice findDateByMaybeAvailable(Long surveyID) {
        Survey survey = SurveyService.getSurveyByID(surveyID);
        IOptionResolver IOptionResolver = new MaybeIOptionResolver();
        log.info("Fonction findDateByMaybeAvailable => OK");
        return getBestChoice(survey, IOptionResolver);
    }

    /**
     * Retourne la date qui dispose du plus de "Disponible"
     *
     * @param surveyID
     * @return
     */
    public static Choice findDateByAvailable(Long surveyID) {
        Survey survey = SurveyService.getSurveyByID(surveyID);
        IOptionResolver IOptionResolver = new AvailableIOptionResolver();
        log.info("Fonction findDateByAvailable => OK");
        return getBestChoice(survey, IOptionResolver);
    }

    private static Choice getBestChoice(Survey survey, IOptionResolver IOptionResolver) {
        HashMap<Choice, Integer> hashMap = new HashMap<>();
        for (Choice choice : survey.getChoices()) {
            hashMap.put(choice, 0);
            for (Vote vote : choice.getVotes()) {
                Option option = vote.getOption();
                if (IOptionResolver.shouldMatch(option)) {
                    hashMap.put(choice, hashMap.get(choice) + 1);
                }
            }
        }

        Choice bestChoice = null;
        for (Map.Entry<Choice, Integer> entry : hashMap.entrySet()) {
            if (bestChoice == null) bestChoice = entry.getKey();
            else if (entry.getValue() > hashMap.get(bestChoice)) bestChoice = entry.getKey();
        }

        return bestChoice;
    }

}
