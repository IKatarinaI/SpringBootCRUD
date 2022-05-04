package com.example.demo.student;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Operation(summary = "Get all students")
    @GetMapping
    public List<Student> getStudents(){
        return studentService.getStudents();
    }

    @Operation(summary = "Register student")
    @PostMapping
    public void registerStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @Operation(summary = "Delete student")
    @DeleteMapping(path="{studentId}")
    public void deleteStudent(@PathVariable("student") Long studentId){
        studentService.deleteStudent(studentId);
    }

    @Operation(summary = "Update student")
    @PatchMapping(path="{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email
    ){
        studentService.updateStudent(studentId, name, email);
    }
}