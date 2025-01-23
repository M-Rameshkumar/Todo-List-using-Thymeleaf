package com.zedvitus.repository;

import com.zedvitus.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Taskrepo extends JpaRepository<Task,Long> {
}
