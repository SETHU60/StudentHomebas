package za.ac.cput.controller;
/*
 * Author : Sabelo Kama (219149364)
 * Date : 24 April 2024
 * */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.StudentApplication;
import za.ac.cput.service.studentApplication.IStudentApplicationService;
import za.ac.cput.service.studentApplication.StudentApplicationService;

import java.util.List;

@RestController
@RequestMapping("/StudentApplication")
public class StudentApplicationController {

    StudentApplicationService service;

    @Autowired
    public StudentApplicationController(StudentApplicationService service){
        this.service = service;
    }

    @PostMapping("/save")
    public StudentApplication save(@RequestBody StudentApplication studentApp) {
        return service.save(studentApp);
    }

    @GetMapping("/read/{appNo}")
    public StudentApplication read(@PathVariable Long appNo) {
        return service.read(appNo);
    }

    @PostMapping("/update")
    public StudentApplication update(@RequestBody StudentApplication studentApp) {
        return service.update(studentApp);
    }

    @DeleteMapping("/delete/{appNo}")
    public boolean deleteById(@PathVariable Long appNo) {
        return service.deleteById(appNo);
    }

    @GetMapping("/getAll")
    public List<StudentApplication> getAll() {
        return service.getAll();
    }
}
