package com.demo.employeeDatabase.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsInputDTO {

    private String name;

    private String position;

    private String email;

    private Double salary;
}
