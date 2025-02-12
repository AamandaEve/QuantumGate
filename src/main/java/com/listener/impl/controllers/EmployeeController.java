package com.listener.impl.controllers;

import com.listener.impl.models.dtos.EmployeeDTO;
import com.listener.impl.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;

    @PostMapping
    public ResponseEntity<EmployeeDTO> save(EmployeeDTO employeeDTO){
        return ResponseEntity.ok(service.save(employeeDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> update(@PathVariable("id") UUID id, EmployeeDTO employeeDTO){
        return ResponseEntity.ok(service.update(id, employeeDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") UUID id){
        service.delete(id);
    }
}
