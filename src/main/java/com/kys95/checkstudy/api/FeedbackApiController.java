package com.kys95.checkstudy.api;

import com.kys95.checkstudy.dto.FeedbackCreateDto;
import com.kys95.checkstudy.service.FeedbackService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class FeedbackApiController {
    private final FeedbackService feedbackService;

    @DeleteMapping("/api/feedback/delete/{id}")
    public void deleteFeedback(@PathVariable long id){
        System.out.println(id);
        feedbackService.deleteFeedback(id);
    }

    @PostMapping("/api/task/create")
    public int createFeedback(@RequestBody FeedbackCreateDto feedbackCreateDto){
        feedbackService.createFeedback(feedbackCreateDto);
        return HttpStatus.OK.value();
    }
}
