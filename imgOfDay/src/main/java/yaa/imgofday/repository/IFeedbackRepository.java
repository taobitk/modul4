package yaa.imgofday.repository;

import yaa.imgofday.model.Feedback;
import java.time.LocalDate;
import java.util.List;

public interface IFeedbackRepository {
    void save(Feedback feedback);
    List<Feedback> findAllByDate(LocalDate date);
    Feedback findById(Long id);
}
