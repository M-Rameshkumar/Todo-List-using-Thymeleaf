package com.zedvitus.controller;


import com.zedvitus.entity.Task;
import com.zedvitus.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.ui.Model;

@Controller
public class Taskcontroller {



    /*


   1. in this project we dnt use @restcontroller
    why?  //new(rest controller = convert into json)
    so we dnt want to convert into json here
    2.we use only two Mapping bcs html support two mapping only get/post
     */

    @Autowired
    private TaskService taskService;


    @GetMapping("/gettask")
    public String gettask(Model model){

        //'taskfromdb' is getting all the data now we need to pass that into html file  howw?  using thymeleaf

        List<Task> tasklist=taskService.getalltask();

           model.addAttribute("tasks",tasklist);
            return "frontend";
    }



    @PostMapping("/")
    public String addtask(@RequestParam String taskname){

        taskService.addtask(taskname);
        return "redirect:/gettask";
    }

    //--------------------working properly(addtask)-----------------------------------

    @GetMapping("{id}/delete")
    public String deletetask(@PathVariable Long id){
        taskService.deletebyid(id);
        return "redirect:/gettask";
    }
//-----------------------------------------------------------------

    @GetMapping("{id}/toggle")
    public String toggletask(@PathVariable Long id){

     taskService.toggleit(id);

      return "redirect:/gettask";
    }

}
