package io.swagger.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static SessionFactory sessionJavaConfigFactory;

    // Retourne une session à la base de données
    public static SessionFactory getSessionFactory() {
        if ( sessionFactory == null) {
            try {
                //Création de la "SessionFactory" à partir de hibernate.cfg.xml
                Configuration configuration = new Configuration();
                configuration.configure("hibernate.cfg.xml");
                System.out.println("Configuration d'annotation Hibernate chargée");
                SessionFactory sessionFactory = configuration.buildSessionFactory();
                return sessionFactory;
            }
            catch (Throwable ex) {
                System.err.println("La création de SessionFactory a échoué." + ex);
                throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }

}