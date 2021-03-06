package com.kys95.checkstudy.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskUpdateDto {
    private String title;
    private String content;
    private LocalDateTime deadline;
    private String stringDeadline;

    @Builder
    public TaskUpdateDto(String title, String content, LocalDateTime deadline){
        this.title = title;
        this.content = content;
        this.deadline = deadline;
    }
}
