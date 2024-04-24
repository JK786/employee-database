package com.demo.employeeDatabase.controllers;

import com.demo.employeeDatabase.request.AddEmployeeRequestDTO;
import com.demo.employeeDatabase.request.EmployeeDetailsInputDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsResponseDTO;
import com.demo.employeeDatabase.services.EmployeeCreationService;
import com.demo.employeeDatabase.services.EmployeeSearchService;
import com.demo.employeeDatabase.services.EmployeeUpdationService;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class EmployeeManagementController {

       private final EmployeeCreationService employeeCreationService;
       private final EmployeeUpdationService employeeUpdationService;
       private final EmployeeSearchService employeeSearchService;


        @PostMapping("/employee")
        public void createEmployee(@RequestBody final AddEmployeeRequestDTO addEmployeeRequestDTO) {

            if(addEmployeeRequestDTO != null) {
                this.employeeCreationService.createEmployee(addEmployeeRequestDTO.getEmployeeDetailsInputDTO(),addEmployeeRequestDTO.getRequestGenerationTime(), addEmployeeRequestDTO.getSourceTimezone());
            }

        }

    /**
     * NOTE: Ideally employee id should not be passed in the URL, it should be passed in the request body.
     * or decoded from the JWT token fo security purposes. But for the sake of simplicity, I am passing it in the URL.
     * @param id
     * @param employeeDetailsDTO
     */
    @PutMapping("/employee/{id}")
        public void updateEmployee(@PathVariable("id") final String id,final EmployeeDetailsInputDTO employeeDetailsDTO) {
            this.employeeUpdationService.updateEmployee(id, employeeDetailsDTO);
        }

    /**
     * NOTE: Ideally employee id should not be passed in the URL, it should be passed in the request body.
     * or decoded from the JWT token fo security purposes. But for the sake of simplicity, I am passing it in the URL.
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
        public EmployeeDetailsDTO getEmployee(@PathParam("id") final String id, @PathVariable("sourceTimezone") final String sourceTimezone) {
            return this.employeeSearchService.getEmployee(id,sourceTimezone);
        }

        @GetMapping("/employees")
        public EmployeeDetailsResponseDTO getAllEmployees(@PathVariable("sourceTimezone") final String sourceTimezon) {
           return this.employeeSearchService.getEmployees(sourceTimezon);
        }


}
