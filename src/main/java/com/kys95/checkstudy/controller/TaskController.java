package com.kys95.checkstudy.controller;

import com.kys95.checkstudy.model.Task;
import com.kys95.checkstudy.service.TaskService;
import lombok.RequiredArgsConstructor;
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

    @GetMapping("/taskView")
    public String taskView(Model model){
        List<Task> tasks = taskService.findList();
        model.addAttribute("tasks",tasks);
        return "task/taskView";
    }
}
