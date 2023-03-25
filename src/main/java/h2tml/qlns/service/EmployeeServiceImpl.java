package h2tml.qlns.service;
import h2tml.qlns.model.Employee;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import h2tml.qlns.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Iterable<Employee> getAllStaffs()
    {
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) {
        if(Objects.nonNull(employee)){
            employeeRepository.save(employee);
        }
    }

    @Override
    public Employee getById(Long id) {
        Employee employee = null ;
        if(Objects.nonNull(id)){
            Optional<Employee> optionalEmployee = employeeRepository.findById(id);
            if(optionalEmployee.isPresent()){
                employee = optionalEmployee.get();
            }else {
                throw new RuntimeException("Nhan Vien không tìm thấy id:" + id);
            }

        }
        return employee;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            employeeRepository.deleteById(id);
        }

    }


}
