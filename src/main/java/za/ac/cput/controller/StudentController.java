package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.domain.Student;
import za.ac.cput.service.StudentService;

import java.util.List;
//
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/save")
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    @GetMapping("/read/{studentId}")
    public Student read(@PathVariable("studentId") Long studentId) {
        return studentService.read(studentId);
    }

    @PostMapping("/update")
    public Student update(@RequestBody Student student) {
        return studentService.update(student);
    }

    @DeleteMapping("/delete/{studentId}")
    public boolean delete(@PathVariable("studentId") Long studentId) {
        return studentService.deleteById(studentId);
    }

    @GetMapping("/getall")
    public List<Student> getall() {
        return studentService.getall();
    }
}
