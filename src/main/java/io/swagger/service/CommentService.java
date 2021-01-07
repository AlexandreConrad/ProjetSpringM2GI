package io.swagger.service;

import io.swagger.api.CommentsApiController;
import io.swagger.model.Comment;
import io.swagger.util.HibernateUtil;
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
public class CommentService {

    private static final Logger log = LoggerFactory.getLogger(CommentsApiController.class);

    /**
     * Fonction qui ajoute un commentaire à un sondage
     *
     * @param surveyID
     * @param message
     * @return
     */
    public static Comment addComments(Long surveyID, String message, String auteur) {
        //Création du commentaire avec les informations
        Comment comment = new Comment();
        comment.setComment(message);
        comment.setIdSurvey(surveyID);
        comment.setAuthor(auteur);

        //Persistance dans la base de données
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
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
    public static List<Comment> getComments(Long surveyID) {
        Session session = HibernateUtil.getSession();//Ouverture d'une session
        Transaction transaction = session.beginTransaction();//Ouverture d'une transaction en cas de problème
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
