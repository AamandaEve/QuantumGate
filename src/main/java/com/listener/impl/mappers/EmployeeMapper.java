package com.listener.impl.mappers;

import com.listener.impl.models.dtos.EmployeeDTO;
import com.listener.impl.models.entities.Employee;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {
    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee toEntity(EmployeeDTO employeeDTO);

    EmployeeDTO toDto(Employee employee);
}
