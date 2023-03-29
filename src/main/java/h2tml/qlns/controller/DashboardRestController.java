package h2tml.qlns.controller;

import h2tml.qlns.repository.DepartRepository;
import h2tml.qlns.repository.EmployeeRepository;
import h2tml.qlns.repository.ProjectRepository;
import h2tml.qlns.repository.SalaryRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardRestController {
    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private DepartRepository departRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private SalaryRespository salaryRespository;

    @GetMapping("/statistics")
    public HashMap<String, Object> getDashboardStatistics() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("count_projects", this.projectRepository.count());
        map.put("count_departs", this.departRepository.count());
        map.put("count_employees", this.employeeRepository.count());
        map.put("count_salaries", this.salaryRespository.count());
        return map;
    }
}
