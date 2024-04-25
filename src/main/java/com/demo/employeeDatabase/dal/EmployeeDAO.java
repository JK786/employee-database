package com.demo.employeeDatabase.dal;


import com.demo.commons.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "employee")
@SuperBuilder(toBuilder = true)
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
