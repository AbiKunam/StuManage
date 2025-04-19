package com.learn.ybserver.student;

import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> hello(){
        return studentService.getStudents();
    }

    @PostMapping
    public String registerNewStudent(@RequestBody Student student){
        studentService.addNewStudents(student);
        return "Data added Successfully!";
    }

    @DeleteMapping("{studentId}")
    public String deleteStudent(@PathVariable Long studentId){
        studentService.deleteStudent(studentId);
        return "Student Id" +studentId+ "data is deleted ";
    }

    @PutMapping("{studentId}")
    public void updateStudent (@PathVariable Long studentId , @RequestParam(required = false)String name, @RequestParam(required = false)String email){
        studentService.updateStudent(studentId,name,email);
    }

}
