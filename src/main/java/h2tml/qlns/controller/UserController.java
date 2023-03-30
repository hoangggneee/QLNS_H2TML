package h2tml.qlns.controller;

import java.util.List;

import h2tml.qlns.model.Salary;
import h2tml.qlns.model.User;
import h2tml.qlns.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService iuserService;

    private String add_edit_template = "/admin/user/add-edit-user";
    private String list_template = "/admin/user/list-user";
    private String list_redirect = "redirect:/user/list";

    @GetMapping("/list")
    public String listUser(Model model) {
        List<User> listUsers = iuserService.findAll();
        model.addAttribute("listUsers", listUsers);

        return list_template;
    }
}