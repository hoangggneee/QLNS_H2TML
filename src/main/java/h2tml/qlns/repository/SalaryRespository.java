package h2tml.qlns.repository;
import h2tml.qlns.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRespository extends JpaRepository<Salary,Long> {

}
