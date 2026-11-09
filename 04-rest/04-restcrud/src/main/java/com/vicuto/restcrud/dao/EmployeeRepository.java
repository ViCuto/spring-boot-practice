package com.vicuto.restcrud.dao;

import com.vicuto.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.rest.core.annotation.RepositoryRestResource;

// @RepositoryRestResource(path = "members")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
