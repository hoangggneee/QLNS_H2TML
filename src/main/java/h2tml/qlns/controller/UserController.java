package h2tml.qlns.controller;

import java.util.List;

import h2tml.qlns.model.Project;
import h2tml.qlns.model.Salary;
import h2tml.qlns.model.User;
import h2tml.qlns.service.IUserService;
import h2tml.qlns.web.dto.UserRegistrationDto;
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
    private String list_template = "/admin/user/list-user";

    @GetMapping("/list")
    public String listUser(Model model) {
        List<User> listUsers = iuserService.findAll();
        model.addAttribute("listUsers", listUsers);

        return list_template;
    }

}