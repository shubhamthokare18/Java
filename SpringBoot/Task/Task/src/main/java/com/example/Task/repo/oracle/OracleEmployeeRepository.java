package com.example.Task.repo.oracle;

import com.example.Task.entity.oracle.OracleEmployee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OracleEmployeeRepository extends JpaRepository<OracleEmployee, Long> {
}
