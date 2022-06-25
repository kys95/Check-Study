package com.kys95.checkstudy.service;

import com.kys95.checkstudy.dto.FeedbackCreateDto;
import com.kys95.checkstudy.repository.FeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class FeedbackService {
    private final FeedbackRepository feedbackRepository;

    public void createFeedback(FeedbackCreateDto feedbackCreateDto) {
        feedbackRepository.createReply(feedbackCreateDto.getUserId(), feedbackCreateDto.getTaskId(), feedbackCreateDto.getContent());
    }

    public void deleteFeedback(long id) {
        feedbackRepository.deleteById(id);
    }
}
