package com.demo.employeeDatabase.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDetailsResponseDTO {

    private List<EmployeeDetailsDTO> employeeDetails;
}
