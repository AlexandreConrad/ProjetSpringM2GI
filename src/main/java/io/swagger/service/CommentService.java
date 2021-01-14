package io.swagger.service;

import io.swagger.exceptions.BadRequestException;
import io.swagger.exceptions.DatabaseException;
import io.swagger.exceptions.NotFoundException;
import io.swagger.model.Comment;
import io.swagger.util.ServicesUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Service pour toutes les requêtes BDD en liaison "Comments"
 */
public final class CommentService {

    private static final Logger log = LoggerFactory.getLogger(CommentService.class);
    private CommentService(){}
    /**
     * Fonction qui ajoute un commentaire à un sondage
     *
     * @param surveyID
     * @param message
     * @return
     */
    public static Comment addComments(Long surveyID, String message, String auteur) throws DatabaseException, NotFoundException, BadRequestException {

        // Exception => 409
        if(surveyID == null || message.isEmpty() || auteur.isEmpty() || message == null || auteur == null)
            throw new BadRequestException("Fonction addComments => informations non valide !");

        //Exception NotFound => 404
        SurveyService.getSurveyByID(surveyID);

        //Création du commentaire avec les informations
        Comment comment = new Comment();
        comment.setComment(message);
        comment.setIdSurvey(surveyID);
        comment.setAuthor(auteur);

        //Persistance dans la base de données
        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);
        session.persist(comment);
        transaction.commit();
        log.info("Fonction createComment => OK");
        return comment;
    }

    /**
     * Fonction qui retourne tous les commentaires d'un sondage
     *
     * @param surveyID
     * @return comments
     */
    public static List<Comment> getComments(Long surveyID) throws DatabaseException, NotFoundException {

        //Exception NotFound => 404
        SurveyService.getSurveyByID(surveyID);

        Session session = ServicesUtil.createSession();
        Transaction transaction = ServicesUtil.createTransaction(session);

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Comment> cq = builder.createQuery(Comment.class);
        Root<Comment> stud = cq.from(Comment.class);
        cq.select(stud).where(builder.equal(stud.get("idSurvey"), surveyID));
        Query<Comment> query = session.createQuery(cq);
        List<Comment> comments = query.getResultList();
        transaction.commit();//Annule les changements en cas de problème
        log.info("Fonction getComments => OK");
        return comments;
    }

}
