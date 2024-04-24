package com.demo.employeeDatabase.dal;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeDAO, String> {

    Optional<EmployeeDAO> findByEmail(String email);

}
