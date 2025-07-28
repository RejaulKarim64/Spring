package me.iamcrk.CRUD.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    @GetMapping("/empform")
    public String empForm() {
        return "empForm";
    }

    public String empAdd() {
        return "empAdd";
    }

    public String empEdit() {
        return "empEdit";
    }

    public String empDelete() {
        return "empDelete";
    }

    public String getAllEmployees(Model model) {
        return "empList";
    }
}
