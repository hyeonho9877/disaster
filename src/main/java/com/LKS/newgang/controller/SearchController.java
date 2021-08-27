package com.LKS.newgang.controller;

import com.LKS.newgang.domain.Lecture;
import com.LKS.newgang.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class SearchController {

    @Autowired
    SearchService searchService;

    @GetMapping("/search")
    public String lectureListbyDept(@RequestParam String department_name, Model model) {
        List<Lecture> lectureList = searchService.findByDepartment(department_name);
        model.addAttribute("lectureList", lectureList);
        return null;
    }
    @GetMapping("/search")
    public String lectureListbyMajor(@RequestParam String major_name, Model model) {
        List<Lecture> lectureList = searchService.findByMajor(major_name);
        model.addAttribute("lectureList", lectureList);
        return null;
    }

    @PostMapping("/getStudentBelonging")
    @ResponseBody
    public ResponseEntity<?> getStdBelong(HttpSession session) {
        Optional<HashMap<String, String>> stdInfo = searchService.stdBelonging(String.valueOf(session.getAttribute("stdID")));

        final ResponseEntity<?>[] result = new ResponseEntity<?>[1];

        stdInfo.ifPresentOrElse(info -> {
            result[0] = ResponseEntity.ok(info);
        }, () -> result[0] = ResponseEntity.badRequest().build());

        return result[0];
    }
}