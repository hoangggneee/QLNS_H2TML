package h2tml.qlns.controller;

import javax.validation.Valid;

import h2tml.qlns.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import h2tml.qlns.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    private String list_template = "/admin/employee/view-employee";
    private String add_edit_template="/admin/employee/addOrEdit";
    private String list_redirect="redirect:/employee/list";

    @GetMapping("/list")
    public String listEmployee(Model model){
        model.addAttribute("listEmployee",employeeService.getAllStaffs());
        return list_template;
    }
    @GetMapping("/add")
    public String addEmployee( Model model){
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return add_edit_template;
    }
    @PostMapping("/save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee){
        employeeService.save(employee);
        return list_redirect;

    }
    @GetMapping("edit/{id}")
    public String editEmployee(@PathVariable(value = "id")long id, Model model){
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee",employee);
        return add_edit_template;
    }
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") long id, Model model) {
        employeeService.deleteById(id);

        return list_redirect+"?deleted";
    }

}
