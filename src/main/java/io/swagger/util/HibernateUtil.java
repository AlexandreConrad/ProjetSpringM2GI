package io.swagger.util;

import io.swagger.api.SurveysApiController;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HibernateUtil {

    private static final Logger log = LoggerFactory.getLogger(SurveysApiController.class);
    private static Session session;

    /**
     * Ouvre une session de connexion avec la base de données
     */
    private static void openSession() {
        try {
            //Création de la "SessionFactory" à partir de hibernate.cfg.xml
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            log.info("Configuration d'annotation Hibernate chargée");
            SessionFactory sessionFactory = configuration.buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Throwable ex) {
            log.error("La création de SessionFactory a échoué." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retourne une session avec la base de données
     * @return session
     */
    public static Session getSession(){
        if(session == null)
            openSession();
        return session;
    }
}