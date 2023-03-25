package h2tml.qlns.service;

import h2tml.qlns.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getAllSalary();

    void save(Salary salary);

    Salary getById(Long id);

    void deleteById(Long id);
}
