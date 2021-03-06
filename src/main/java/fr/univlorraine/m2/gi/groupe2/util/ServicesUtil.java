package fr.univlorraine.m2.gi.groupe2.util;

import fr.univlorraine.m2.gi.groupe2.exceptions.DatabaseException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public final class ServicesUtil {

    private ServicesUtil(){}

    /**
     * Ouverture d'une session
     * @return
     * @throws DatabaseException
     */
    public static Session createSession() throws DatabaseException {
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        if(session == null)
            throw new DatabaseException("Connexion à la BDD impossible");
        return session;
    }

    /**
     * Ouverture d'une transaction
     * @param session
     * @return
     * @throws DatabaseException
     */
    public static Transaction createTransaction(Session session) throws DatabaseException {
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
        if(transaction == null)
            throw new DatabaseException("Impossible de créer une transaction");
        return transaction;
    }
}
