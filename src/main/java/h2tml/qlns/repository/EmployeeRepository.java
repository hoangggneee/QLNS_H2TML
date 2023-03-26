package h2tml.qlns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import h2tml.qlns.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
