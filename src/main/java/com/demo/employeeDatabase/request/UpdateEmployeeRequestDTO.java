package com.demo.employeeDatabase.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class UpdateEmployeeRequestDTO {

    private String sourceTimezone;

    //This will be considered as creation time of the employee
    private String requestGenerationTime;

    private  EmployeeDetailsInputDTO employeeDetails;
}
