package com.dailycodebuffer.employee.repository;

import com.dailycodebuffer.employee.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity,Long> {
}
