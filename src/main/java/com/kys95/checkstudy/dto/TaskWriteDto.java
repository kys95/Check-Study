package com.kys95.checkstudy.dto;

import com.kys95.checkstudy.model.Task;
import com.kys95.checkstudy.model.User;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class TaskWriteDto {

    private String title;
    private String content;
    private LocalDateTime deadline;
    private User user;
    private int isSuccess;
    private String stringDeadline;


    @Builder
    public TaskWriteDto(String title, String content, LocalDateTime deadline, User user, int isSuccess){
        this.title = title;
        this.content = content;
        this.deadline = deadline;
        this.user = user;
        this.isSuccess = isSuccess;
    }

    public Task toEntity(){
        return Task.builder()
                .title(title)
                .content(content)
                .deadline(deadline)
                .user(user)
                .isSuccess(isSuccess)
                .stringDeadline(stringDeadline)
                .build();
    }
}
