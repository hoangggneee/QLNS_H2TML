package h2tml.qlns.service;
import h2tml.qlns.model.Salary;
import h2tml.qlns.repository.SalaryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service
public class SalaryServiceImpl implements SalaryService {
    @Autowired
    private SalaryRespository salaryRespository;

    @Override
    public List<Salary> getAllSalary() {
        return salaryRespository.findAll();
    }

    @Override
    public void save(Salary salary) {
        if(Objects.nonNull(salary)){
            salaryRespository.save(salary);
        }
    }

    @Override
    public Salary getById(Long id) {
        Salary salary = null ;
        if(Objects.nonNull(id)){
            Optional<Salary> optionalSalary = salaryRespository.findById(id);
            if(optionalSalary.isPresent()){
                salary = optionalSalary.get();
            }else {
                throw new RuntimeException("Lương không tìm thấy id:" + id);
            }

        }
        return salary;
    }

    @Override
    public void deleteById(Long id) {
        if(Objects.nonNull(id)){
            salaryRespository.deleteById(id);
        }

    }
}
