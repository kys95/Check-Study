package com.kys95.checkstudy.controller;

import com.kys95.checkstudy.config.auth.PrincipalDetails;
import com.kys95.checkstudy.model.Task;
import com.kys95.checkstudy.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Controller
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping("/taskForm")
    public String taskForm(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        String username = principalDetails.getUsername();
        model.addAttribute("username",username);
        return "task/taskForm";
    }

    @ResponseBody
    public String taskView(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails,
                               @PageableDefault(size=8, sort = "deadline", direction = Sort.Direction.ASC) Pageable pageable, int page) {
        Page<Task> pagingTasks  = taskService.findList(principalDetails, pageable);
        int nextPage = pagingTasks.getNumber()+1;
        model.addAttribute("username", principalDetails);
        model.addAttribute("nextPage", nextPage);
        model.addAttribute("pagingTasks",pagingTasks);
        model.addAttribute("title","To_Do_List");
        return "task/taskView";
    }

    @GetMapping("/todolist/success")
    public String successTaskView(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails, @PageableDefault(size=8, sort = "deadline", direction = Sort.Direction.ASC) Pageable pageable, int page){
        Page<Task> pagingTasks = taskService.findSuccessList(principalDetails, pageable);
        int nextPage = pagingTasks.getNumber()+1;
        model.addAttribute("username",principalDetails);
        model.addAttribute("nextPage",nextPage);
        model.addAttribute("pagingTasks",pagingTasks);
        model.addAttribute("title","Success List");
        return "task/taskView";
    }

    @GetMapping("/task/detail/{id}")
    public String taskDetail(@PathVariable long id, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Task requestTask = taskService.findTask(id);
        String username = principalDetails.getUsername();
        model.addAttribute("task",requestTask);
        model.addAttribute("username",username);
        boolean isSuccess;
        if(requestTask.getIsSuccess()!=0) isSuccess=true;
        else isSuccess=false;
        model.addAttribute("isSuccess",isSuccess);
        return "task/taskDetail";
    }

    @GetMapping("/task/update/{id}")
    public String updatePage(@PathVariable long id, Model model, @AuthenticationPrincipal PrincipalDetails principalDetails){
        Task requestTask = taskService.findTask(id);
        String username = principalDetails.getUsername();
        model.addAttribute("task",requestTask);
        model.addAttribute("username",username);
        return "task/taskUpdate";
    }
}
