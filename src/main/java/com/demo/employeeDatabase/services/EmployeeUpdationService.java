package com.demo.employeeDatabase.services;

import com.demo.commons.DatetimeUtility;
import com.demo.commons.EmailUtility;
import com.demo.employeeDatabase.dal.EmployeeDAO;
import com.demo.employeeDatabase.dal.EmployeeRepository;
import com.demo.employeeDatabase.exceptions.EmailFormatException;
import com.demo.employeeDatabase.request.EmployeeDetailsInputDTO;
import com.demo.employeeDatabase.validators.EmployeeUpdationInputValidator;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor
@Component
public class EmployeeUpdationService {

    private final EmployeeRepository employeeRepository;


    public void updateEmployee(final String id,final String requestGenerationDateTime,final String sourceTimezone,final EmployeeDetailsInputDTO employeeDetailsDTO) {


        final EmployeeDAO updatedEmployeeDAO =  this.employeeRepository.findById(id).get()
                .toBuilder()
                .email(employeeDetailsDTO.getEmail())
                .salary(employeeDetailsDTO.getSalary())
                .position(employeeDetailsDTO.getPosition())
                .updatedOn(DatetimeUtility.convertToUTC(requestGenerationDateTime,sourceTimezone))
                .build();

        this.employeeRepository.save(updatedEmployeeDAO);

    }

}
