package h2tml.qlns.controller;

import h2tml.qlns.model.Project;
import h2tml.qlns.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {
    @Autowired
    private ProjectService projectService;

    private String add_edit_template = "/admin/project/add-edit-project";
    private String list_template="/admin/project/list-project";
    private String list_redirect="redirect:/project/list";

    @GetMapping("/list")
    public String listProject(Model model){
        model.addAttribute("listProject", projectService.getAllProject());
        return list_template;
    }
    @GetMapping("/add")
    public String addProject( Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return add_edit_template;
    }
    @PostMapping("/save")
    public String saveProject(@Valid @ModelAttribute("project") Project project){
        projectService.save(project);
        return list_redirect;

    }
    @GetMapping("edit/{id}")
    public String editProject(@PathVariable(value = "id")long id, Model model){
        Project project = projectService.getById(id);
        model.addAttribute("project",project);
        return add_edit_template;
    }
    @GetMapping("/delete/{id}")
    public String deleteProject(@PathVariable(value = "id") long id, Model model) {
        projectService.deleteById(id);

        return list_redirect+"?deleted";
    }

}
