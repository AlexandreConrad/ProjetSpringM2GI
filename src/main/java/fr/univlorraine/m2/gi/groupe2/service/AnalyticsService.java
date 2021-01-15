package fr.univlorraine.m2.gi.groupe2.service;
import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import fr.univlorraine.m2.gi.groupe2.exceptions.NotFoundException;
import fr.univlorraine.m2.gi.groupe2.model.Choice;
import fr.univlorraine.m2.gi.groupe2.model.Option;
import fr.univlorraine.m2.gi.groupe2.model.Survey;
import fr.univlorraine.m2.gi.groupe2.model.Vote;
import fr.univlorraine.m2.gi.groupe2.resolvers.AvailableIOptionResolver;
import fr.univlorraine.m2.gi.groupe2.resolvers.IOptionResolver;
import fr.univlorraine.m2.gi.groupe2.resolvers.MaybeIOptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Service pour toutes les requêtes BDD en liaison "Analytics"
 */
public final class AnalyticsService {

    private static final Logger log = LoggerFactory.getLogger(AnalyticsService.class);
    private AnalyticsService(){}

    /**
     * Retourne la date qui dispose du plus de "Disponible" et "Peut-être"
     *
     * @return MostMaybe
     */
    public static Choice findDateByMaybeAvailable(Long surveyID) throws NotFoundException, DatabaseException {
        Survey survey = SurveyService.getSurveyByID(surveyID);
        IOptionResolver iOptionResolver = new MaybeIOptionResolver();
        log.info("Fonction findDateByMaybeAvailable => OK");
        return getBestChoice(survey, iOptionResolver);
    }

    /**
     * Retourne la date qui dispose du plus de "Disponible"
     *
     * @param surveyID
     * @return
     */
    public static Choice findDateByAvailable(Long surveyID) throws NotFoundException, DatabaseException {
        Survey survey = SurveyService.getSurveyByID(surveyID);
        IOptionResolver iOptionResolver = new AvailableIOptionResolver();
        log.info("Fonction findDateByAvailable => OK");
        return getBestChoice(survey, iOptionResolver);
    }

    private static Choice getBestChoice(Survey survey, IOptionResolver iOptionResolver) {
        HashMap<Choice, Integer> hashMap = new HashMap<>();
        for (Choice choice : survey.getChoices()) {
            hashMap.put(choice, 0);
            for (Vote vote : choice.getVotes()) {
                Option option = vote.getOption();
                if (iOptionResolver.shouldMatch(option)) {
                    hashMap.put(choice, hashMap.get(choice) + 1);
                }
            }
        }

        Choice bestChoice = null;
        for (Map.Entry<Choice, Integer> entry : hashMap.entrySet()) {
            if (bestChoice == null || entry.getValue() > hashMap.get(bestChoice)) bestChoice = entry.getKey();
        }

        return bestChoice;
    }

}
