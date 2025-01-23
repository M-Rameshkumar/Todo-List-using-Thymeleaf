package com.zedvitus.service;

import com.zedvitus.entity.Task;
import com.zedvitus.repository.Taskrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {


    @Autowired
    private Taskrepo taskrepo;




    public List<Task> getalltask() {
        return taskrepo.findAll();
    }


    public void addtask(String taskname) {
        Task taskadd= new Task();
        taskadd.setTask(taskname);
        taskadd.setCompleted(false);
        taskrepo.save(taskadd);

    }

    public void deletebyid(Long id) {
        taskrepo.deleteById(id);
    }

    public void toggleit(Long id) {
        Optional<Task> data =taskrepo.findById(id);

        if(data.isPresent()){
            Task task=data.get();
            task.setCompleted(!task.isCompleted());
            taskrepo.save(task);
        }
        else{
            throw new RuntimeException("id is not found");
        }
    }
}
