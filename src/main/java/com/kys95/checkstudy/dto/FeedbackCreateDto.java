package com.kys95.checkstudy.dto;

import lombok.Builder;
import lombok.Setter;

@Setter
public class FeedbackCreateDto {
    private long userId;
    private long taskId;
    private String content;

    @Builder
    FeedbackCreateDto(long userId, long taskId, String content){
        this.userId = userId;
        this.taskId = taskId;
        this.content = content;
    }
}
