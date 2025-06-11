package yaa.imgofday.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yaa.imgofday.model.Feedback;
import yaa.imgofday.repository.IFeedbackRepository;
import java.time.LocalDate;
import java.util.List;

@Service
public class FeedbackService implements IFeedbackService {

    @Autowired
    private IFeedbackRepository feedbackRepository;

    @Override
    public void save(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getTodaysFeedback() {
        return feedbackRepository.findAllByDate(LocalDate.now());
    }

    @Override
    public void like(Long id) {
        Feedback feedback = feedbackRepository.findById(id);
        if (feedback != null) {
            feedback.setLikes(feedback.getLikes() + 1);
            feedbackRepository.save(feedback);
        }
    }
}
