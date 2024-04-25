package com.demo.employeeDatabase.services;

import com.demo.commons.DatetimeUtility;
import com.demo.employeeDatabase.dal.EmployeeDAO;
import com.demo.employeeDatabase.dal.EmployeeRepository;
import com.demo.employeeDatabase.request.EmployeeDetailsInputDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class EmployeeCreationService {

    private final EmployeeRepository employeeRepository;


    public void createEmployee(final EmployeeDetailsInputDTO employeeDetailsDTO,final String requestGenerationTime, final String sourceTimezone) {

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
