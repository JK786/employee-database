package com.demo.employeeDatabase.request;

import com.demo.employeeDatabase.response.EmployeeDetailsDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class AddEmployeeRequestDTO {

    private String sourceTimezone;

    //This will be considered as creation time of the employee
    private String requestGenerationTime;

    private  EmployeeDetailsInputDTO employeeDetails;
}
