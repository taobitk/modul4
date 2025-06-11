package yaa.imgofday.service;

import yaa.imgofday.model.Feedback;
import java.util.List;

public interface IFeedbackService {
    void save(Feedback feedback);
    List<Feedback> getTodaysFeedback();
    void like(Long id);
}
