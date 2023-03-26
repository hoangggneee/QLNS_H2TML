package h2tml.qlns.controller;

import h2tml.qlns.model.Project;
import h2tml.qlns.model.Salary;
import h2tml.qlns.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@Controller
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    private String add_edit_template = "/admin/salary/add-edit-salary";
    private String list_template="/admin/salary/list-salary";
    private String list_redirect="redirect:/salary/list";

    @GetMapping("/list")
    public String listSalary(Model model){
        model.addAttribute("listSalary", salaryService.getAllSalary());
        return list_template;
    }
    @GetMapping("/add")
    public String addSalary( Model model){
        Salary salary = new Salary();
        model.addAttribute("salary", salary);
        return add_edit_template;
    }
    @PostMapping("/save")
    public String saveSalary(@Valid @ModelAttribute("salary") Salary salary){
        salaryService.save(salary);
        return list_redirect;

    }
}
