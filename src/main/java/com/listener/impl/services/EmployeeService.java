package com.listener.impl.services;

import com.listener.impl.mappers.EmployeeMapper;
import com.listener.impl.models.dtos.EmployeeDTO;
import com.listener.impl.models.dtos.ProductDTO;
import com.listener.impl.models.entities.Employee;
import com.listener.impl.models.entities.Product;
import com.listener.impl.models.repositories.EmployeeRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository repository;
    private final EmployeeMapper mapper;

    public List<EmployeeDTO> findAll(){
        return findAll();
    }

    @Transactional
    public EmployeeDTO save(EmployeeDTO employeeDTO){
        employeeDTO.setId(null);
        Employee employee = mapper.toEntity(employeeDTO);
        repository.save(employee);
        return mapper.toDto(employee);
    }

    @Transactional
    public EmployeeDTO update(UUID id, EmployeeDTO employeeDTO){
        Employee employee = repository.findById(employeeDTO.getId()).orElseThrow(() -> new RuntimeException("Funcionário(a) não encontrado"));
        Employee entity = mapper.toEntity(employeeDTO);
        entity.setId(employee.getId());
        repository.save(entity);
        return mapper.toDto(entity);
    }

    @Transactional
    public void delete(UUID id){
        repository.findById(id).orElseThrow(() -> new RuntimeException("Funcionário(a) não encontrado"));
        repository.deleteById(id);
    }
}
