package h2tml.qlns.controller;

import h2tml.qlns.model.Position;
import h2tml.qlns.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/position")
public class PositionController {
    @Autowired
    private PositionService positionService;

    private String add_edit_template = "/admin/position/add-edit-position";
    private String list_template="/admin/position/list-position";
    private String list_redirect="redirect:/position/list";

    @GetMapping("/list")
    public String listPosition(Model model){
        model.addAttribute("listPosition", positionService.getAllPosition());
        return list_template;
    }
    @GetMapping("/add")
    public String addPosition( Model model){
        Position position = new Position();
        model.addAttribute("position", position);
        return add_edit_template;
    }
    @PostMapping("/save")
    public String savePosition(@Valid @ModelAttribute("position") Position position){
        positionService.save(position);
        return list_redirect;

    }
    @GetMapping("edit/{id}")
    public String editPosition(@PathVariable(value = "id")long id, Model model){
        Position position = positionService.getById(id);
        model.addAttribute("position",position);
        return add_edit_template;
    }
    @GetMapping("/delete/{id}")
    public String deletePosition(@PathVariable(value = "id") long id, Model model) {
        positionService.deleteById(id);

        return list_redirect+"?deleted";
    }
}
