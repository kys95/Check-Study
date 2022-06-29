package com.kys95.checkstudy.dto;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskSuccessDto {
    private int isSuccess;

    @Builder
    public TaskSuccessDto(int isSuccess){
        this.isSuccess = isSuccess;
    }
}
