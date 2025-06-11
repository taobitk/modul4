package yaa.imgofday.repository;

import org.springframework.stereotype.Repository;
import yaa.imgofday.model.Feedback;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Repository
@Transactional
public class FeedbackRepository implements IFeedbackRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Feedback feedback) {
        if (feedback.getId() == null) {
            entityManager.persist(feedback);
        } else {
            entityManager.merge(feedback);
        }
    }

    @Override
    public List<Feedback> findAllByDate(LocalDate date) {
        TypedQuery<Feedback> query = entityManager.createQuery(
                "SELECT f FROM Feedback f WHERE f.date = :date ORDER BY f.id DESC", Feedback.class);
        query.setParameter("date", date);
        return query.getResultList();
    }

    @Override
    public Feedback findById(Long id) {
        return entityManager.find(Feedback.class, id);
    }
}
