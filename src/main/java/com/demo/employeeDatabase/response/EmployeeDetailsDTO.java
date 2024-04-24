package com.demo.employeeDatabase.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsDTO {

    private String id;

    private String name;

    private String position;

    private String email;

    private Double salary;

    private String createdOn;

    private String updatedOn;

}
