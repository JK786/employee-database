package com.demo.employeeDatabase.controllers;

import com.demo.employeeDatabase.request.AddEmployeeRequestDTO;
import com.demo.employeeDatabase.request.UpdateEmployeeRequestDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsResponseDTO;
import com.demo.employeeDatabase.services.EmployeeCreationService;
import com.demo.employeeDatabase.services.EmployeeSearchService;
import com.demo.employeeDatabase.services.EmployeeUpdationService;
import com.demo.employeeDatabase.validators.EmployeeCreationInputValidator;
import com.demo.employeeDatabase.validators.EmployeeUpdationInputValidator;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
public class EmployeeManagementController {

       private final EmployeeCreationService employeeCreationService;
       private final EmployeeUpdationService employeeUpdationService;
       private final EmployeeSearchService employeeSearchService;

       private final EmployeeCreationInputValidator creationInputValidator;
       private final EmployeeUpdationInputValidator employeeUpdationInputValidator;

    /**
     * NOTE: Not returning the created employee object , can be done on need basis.
     * @param addEmployeeRequestDTO
     */
    @PostMapping("/employee")
        public void createEmployee(@RequestBody final AddEmployeeRequestDTO addEmployeeRequestDTO) {

            this.creationInputValidator.validate(addEmployeeRequestDTO);

            this.employeeCreationService.createEmployee(addEmployeeRequestDTO.getEmployeeDetailsInputDTO(),addEmployeeRequestDTO.getRequestGenerationTime(), addEmployeeRequestDTO.getSourceTimezone());
        }

    /**
     * NOTE: 1. Ideally employee id should not be passed in the URL, it should be passed in the request body.
     * or decoded from the JWT token fo security purposes. But for the sake of simplicity, I am passing it in the URL.
     *
     * 2. email is mandatory , apart from that any field sent will be set null. All fields are considered nullable for ease.
     * @param id
     * @param updateEmployeeRequestDTO
     */
    @PutMapping("/employee/{id}")
        public void updateEmployee(@PathVariable("id") final String id,final UpdateEmployeeRequestDTO updateEmployeeRequestDTO) {

            this.employeeUpdationInputValidator.validate(id,updateEmployeeRequestDTO);

            this.employeeUpdationService.updateEmployee(id,updateEmployeeRequestDTO.getRequestGenerationTime(),updateEmployeeRequestDTO.getSourceTimezone(), updateEmployeeRequestDTO.getEmployeeDetailsInputDTO());
        }

    /**
     * NOTE: Ideally employee id should not be passed in the URL, it should be passed in the request body.
     * or decoded from the JWT token fo security purposes. But for the sake of simplicity, I am passing it in the URL.
     * @param id
     * @return
     */
    @GetMapping("/employee/{id}")
        public EmployeeDetailsDTO getEmployee(@PathParam("id") final String id, @PathVariable("sourceTimezone") final String sourceTimezone) {

            if(id == null || id.isEmpty())
                throw new IllegalArgumentException("Employee id cannot be null or empty");

            if(sourceTimezone == null || sourceTimezone.isEmpty())
                throw new IllegalArgumentException("Source timezone cannot be null or empty");

            return this.employeeSearchService.getEmployee(id,sourceTimezone);
        }

        @GetMapping("/employees")
        public EmployeeDetailsResponseDTO getAllEmployees(@PathVariable("sourceTimezone") final String sourceTimezone) {

            if(sourceTimezone == null || sourceTimezone.isEmpty())
                throw new IllegalArgumentException("Source timezone cannot be null or empty");

           return this.employeeSearchService.getEmployees(sourceTimezone);
        }
}
