package com.demo.employeeDatabase.validators;

import com.demo.commons.EmailUtility;
import com.demo.employeeDatabase.dal.EmployeeDAO;
import com.demo.employeeDatabase.dal.EmployeeRepository;
import com.demo.employeeDatabase.exceptions.EmailFormatException;
import com.demo.employeeDatabase.request.UpdateEmployeeRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@AllArgsConstructor
@Component
public class EmployeeUpdationInputValidator {

    private final EmployeeRepository employeeRepository;

    public  void validate(final String id,final UpdateEmployeeRequestDTO updateEmployeeRequestDTO)
    {
        if(id == null) {
            throw new IllegalArgumentException("Id must be provided for updation");
        }

        if(updateEmployeeRequestDTO == null || updateEmployeeRequestDTO.getEmployeeDetails() == null) {
            throw new IllegalArgumentException("Employee details must be provided for updation");
        }

        if(updateEmployeeRequestDTO.getSourceTimezone() == null || updateEmployeeRequestDTO.getRequestGenerationTime() == null)
        {
            throw new IllegalArgumentException("Timezone and request generation time must be provided");
        }

        if(updateEmployeeRequestDTO.getEmployeeDetails().getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        } else {

            if(!EmailUtility.isValidEmail(updateEmployeeRequestDTO.getEmployeeDetails().getEmail())) {
                throw new EmailFormatException("Email is not valid");
            }
        }

        final EmployeeDAO employeeFoundById = this.employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee with id not found"));
        final EmployeeDAO employeeFoundWithEmail = this.employeeRepository.findByEmail(updateEmployeeRequestDTO.getEmployeeDetails().getEmail()).orElse(null);

        if(employeeFoundWithEmail != null && !employeeFoundWithEmail.getId().equals(employeeFoundById.getId())) {
            throw new IllegalArgumentException("Employee with email already exists");
        }
    }
}
