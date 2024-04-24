package com.demo.employeeDatabase.dal;


import com.commons.BaseModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity
@Table(name = "employee")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class EmployeeDAO extends BaseModel {

    @Id
    private String id;

    private String name;

    private String position;

    private String email;

    private Double salary;
}