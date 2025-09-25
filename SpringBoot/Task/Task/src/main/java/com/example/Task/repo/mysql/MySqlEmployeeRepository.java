package com.example.Task.repo.mysql;

import com.example.Task.entity.mysql.MySqlEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MySqlEmployeeRepository extends JpaRepository<MySqlEmployee, Integer> {
}
