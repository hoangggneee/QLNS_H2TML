package h2tml.qlns.controller;

import h2tml.qlns.model.Departs;
import h2tml.qlns.service.DepartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;
@Controller
@RequestMapping("/depart")
public class DepartController {
    @Autowired
    private DepartService departService;

    private String add_edit_template = "/admin/depart/add-edit-depart";
    private String list_template="/admin/depart/list-depart";
    private String list_redirect="redirect:/depart/list";

    @GetMapping("/list")
    public String listDepart(Model model){
        model.addAttribute("listDepart", departService.getAllDeparts());
        return list_template;
    }
    @GetMapping("/add")
    public String addDepart( Model model){
        Departs departs = new Departs();
        model.addAttribute("depart", departs);
        return add_edit_template;
    }
    @PostMapping("/save")
    public String saveDepart(@Valid @ModelAttribute("depart") Departs departs){
        departService.save(departs);
        return list_redirect;

    }
    @GetMapping("edit/{id}")
    public String editDepart(@PathVariable(value = "id")long id, Model model){
        Departs departs = departService.getById(id);
        model.addAttribute("depart",departs);
        return add_edit_template;
    }

    @GetMapping("/delete/{id}")
    public String deleteDepart(@PathVariable(value = "id") long id, Model model) {
        departService.deleteById(id);
        return list_redirect+"?deleted";
    }
}
