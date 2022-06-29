package com.kys95.checkstudy.api;

import com.kys95.checkstudy.config.auth.PrincipalDetails;
import com.kys95.checkstudy.dto.TaskSuccessDto;
import com.kys95.checkstudy.dto.TaskUpdateDto;
import com.kys95.checkstudy.dto.TaskWriteDto;
import com.kys95.checkstudy.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TaskApiController {

    private final TaskService taskService;

    @PostMapping("api/writeProc")
    public int write(@RequestBody TaskWriteDto taskWriteDto, @AuthenticationPrincipal PrincipalDetails principalDetails){
        taskService.write(taskWriteDto, principalDetails);
        return HttpStatus.OK.value();
    }

    @DeleteMapping("/api/taskDelete/{id}")
    public int delete(@PathVariable long id){
        taskService.delete(id);
        return HttpStatus.OK.value();
    }

    @PutMapping("/api/taskUpdate/{id}")
    public int update(@PathVariable long id, @AuthenticationPrincipal PrincipalDetails principalDetails, @RequestBody TaskUpdateDto taskUpdateDto){
        taskService.update(id, taskUpdateDto);
        return HttpStatus.OK.value();
    }

    @PutMapping("/api/taskSuccess/{id}")
    public int updateSuccess(@RequestBody TaskSuccessDto taskSuccessDto, @PathVariable long id){
        taskService.updateSuccess(id, taskSuccessDto.getIsSuccess());
        return HttpStatus.OK.value();
    }
}
