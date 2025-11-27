package com.vdb.controller;

import ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import com.vdb.model.Employee;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

      List<Employee> employeeList= Stream.of(new Employee(1,"vivek","pune",897.90),
              new Employee(2,"sachin","Latur",497.90),
              new Employee(3,"ganesh","Dharashiv",697.90),
              new Employee(4,"ramesh","Wadi",197.90)).toList();


      @GetMapping("/findAll")
      public ResponseEntity<List<Employee>> findAll()
      {
          return ResponseEntity.ok(employeeList);
      }

      // sort by salary

      @GetMapping("/sortbysalary")
      public ResponseEntity<List<Employee>> sortBySalary()
      {
          return ResponseEntity.ok(employeeList.stream().sorted(Comparator.comparing(Employee::getEmpSalary)).toList());
      }
}
