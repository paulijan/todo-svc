package com.example.demo.controllers;

import com.example.demo.dtos.UniversityProgress;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DemoController {

    @GetMapping("/getKidsName")
    public String getKidsName() {
        return "John, Sarah, Emily";
    }

    @GetMapping(value = "/getUniProgress", produces = MediaType.APPLICATION_JSON_VALUE)
    public UniversityProgress getUniProgress() {
        // Assuming UniversityProgress is a custom class
        UniversityProgress progress = new UniversityProgress("John", "Computer Science", 3.8);
        return progress;
    }

}
