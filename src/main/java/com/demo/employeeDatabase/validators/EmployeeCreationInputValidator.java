package com.demo.employeeDatabase.validators;

import com.demo.commons.EmailUtility;
import com.demo.employeeDatabase.dal.EmployeeRepository;
import com.demo.employeeDatabase.exceptions.EmailFormatException;
import com.demo.employeeDatabase.request.AddEmployeeRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EmployeeCreationInputValidator {

    private final EmployeeRepository employeeRepository;

    public  void validate(final AddEmployeeRequestDTO addEmployeeRequestDTO)
    {
        if(addEmployeeRequestDTO == null || addEmployeeRequestDTO.getEmployeeDetails() == null) {
            throw new IllegalArgumentException("Employee details must be provided for creation");
        }

        if(addEmployeeRequestDTO.getSourceTimezone() == null || addEmployeeRequestDTO.getRequestGenerationTime() == null)
        {
            throw new IllegalArgumentException("Timezone and request generation time must be provided");
        }

        if(addEmployeeRequestDTO.getEmployeeDetails().getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        } else {
            if(!EmailUtility.isValidEmail(addEmployeeRequestDTO.getEmployeeDetails().getEmail())) {
                throw new EmailFormatException("Email is not valid");
            }
        }

        this.employeeRepository.findByEmail(addEmployeeRequestDTO.getEmployeeDetails().getEmail()).ifPresent(employeeDAO -> {
            throw new IllegalArgumentException("Employee with email already exists");
        });


    }
}
