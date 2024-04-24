package com.demo.employeeDatabase.services;

import com.demo.employeeDatabase.dal.EmployeeDAO;
import com.demo.employeeDatabase.dal.EmployeeRepository;
import com.demo.employeeDatabase.response.EmployeeDetailsDTO;
import com.demo.employeeDatabase.response.EmployeeDetailsResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EmployeeSearchService {

    private final EmployeeRepository employeeRepository;


    public EmployeeDetailsDTO getEmployee(final String id) {

        final EmployeeDAO employeeDAO = this.employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Employee not found"));

        return EmployeeDetailsDTO.builder()
                .id(employeeDAO.getId())
                .name(employeeDAO.getName())
                .email(employeeDAO.getEmail())
                .position(employeeDAO.getPosition())
                .salary(employeeDAO.getSalary())
                .build();

    }


    /**
     * NOTE : Not writing paginated API right now.
     * @return
     */
    public EmployeeDetailsResponseDTO getEmployees() {

        final List<EmployeeDetailsDTO> employeeDetails = this.employeeRepository.findAll()
                .stream()
                .map(employeeDAO -> EmployeeDetailsDTO.builder()
                        .id(employeeDAO.getId())
                        .name(employeeDAO.getName())
                        .email(employeeDAO.getEmail())
                        .position(employeeDAO.getPosition())
                        .salary(employeeDAO.getSalary())
                        .build())
                .collect(Collectors.toList());

        return EmployeeDetailsResponseDTO.builder()
                .employeeDetails(employeeDetails)
                .build();

    }



}