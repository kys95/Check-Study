package com.kys95.checkstudy.controller;

import com.kys95.checkstudy.config.auth.PrincipalDetails;
import com.kys95.checkstudy.model.Task;
import com.kys95.checkstudy.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/taskForm")
    public String taskForm(){
        return "task/taskForm";
    }

    @GetMapping("/todolist")
    public String taskView(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        List<Task> tasks = taskService.findList(principalDetails);
        model.addAttribute("tasks",tasks);
        return "task/taskView";
    }
}
