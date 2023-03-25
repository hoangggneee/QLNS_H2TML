package h2tml.qlns.service;


import h2tml.qlns.model.Employee;


public interface EmployeeService {

    Iterable<Employee> getAllStaffs();

    void save(Employee employee);

    Employee getById(Long id);

    void deleteById(Long id);





}
