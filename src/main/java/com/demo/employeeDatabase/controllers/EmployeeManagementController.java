package com.demo.employeeDatabase.controllers;

import com.demo.employeeDatabase.request.EmployeeDetailsInputDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsResponseDTO;
import com.demo.employeeDatabase.services.EmployeeCreationService;
import com.demo.employeeDatabase.services.EmployeeSearchService;
import com.demo.employeeDatabase.services.EmployeeUpdationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
public class EmployeeManagementController {

       private final EmployeeCreationService employeeCreationService;
       private final EmployeeUpdationService employeeUpdationService;
       private final EmployeeSearchService employeeSearchService;


        @PostMapping("/employee")
        public void createEmployee(final EmployeeDetailsInputDTO employeeDetailsDTO) {
            this.employeeCreationService.createEmployee(employeeDetailsDTO);
        }

        @PutMapping("/employee/{id}")
        public void updateEmployee(@PathVariable("id") final String id,final EmployeeDetailsInputDTO employeeDetailsDTO) {
            this.employeeUpdationService.updateEmployee(id, employeeDetailsDTO);
        }

        @GetMapping("/employee/{id}")
        public EmployeeDetailsDTO getEmployee(@PathVariable("id") final String id) {
            return this.employeeSearchService.getEmployee(id);
        }

        @GetMapping("/employees")
        public EmployeeDetailsResponseDTO getAllEmployees() {
           return this.employeeSearchService.getEmployees();
        }


}
