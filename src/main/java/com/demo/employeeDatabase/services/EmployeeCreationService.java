package com.demo.employeeDatabase.services;

import com.commons.DatetimeUtility;
import com.commons.EmailUtility;
import com.demo.employeeDatabase.dal.EmployeeDAO;
import com.demo.employeeDatabase.dal.EmployeeRepository;
import com.demo.employeeDatabase.exceptions.EmailFormatException;
import com.demo.employeeDatabase.request.EmployeeDetailsInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class EmployeeCreationService {

    private final EmployeeRepository employeeRepository;


    public void createEmployee(final EmployeeDetailsInputDTO employeeDetailsDTO,final String requestGenerationTime, final String sourceTimezone) {

        if(employeeDetailsDTO.getEmail() == null) {
            throw new IllegalArgumentException("Email cannot be empty");
        }

        if(EmailUtility.isValidEmail(employeeDetailsDTO.getEmail())) {
            throw new EmailFormatException("Email is not valid");
        }

        this.employeeRepository.findByEmail(employeeDetailsDTO.getEmail()).ifPresent(employeeDAO -> {
            throw new IllegalArgumentException("Employee with email already exists");
        });


        this.employeeRepository.save(
                EmployeeDAO.builder()
                        .id(UUID.randomUUID().toString())
                        .name(employeeDetailsDTO.getName())
                        .email(employeeDetailsDTO.getEmail())
                        .position(employeeDetailsDTO.getPosition())
                        .salary(employeeDetailsDTO.getSalary())
                        .createdOn(DatetimeUtility.convertToUTC(requestGenerationTime,sourceTimezone))
                        .build()
        );
    }



}
