package com.vicuto.restdemo.rest;

import com.vicuto.restdemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    private void loadData() {
        students = new ArrayList<>();
        students.add(new Student("Viki", "Stratiev"));
        students.add(new Student("Deni", "Meni"));
        students.add(new Student("Raq", "Zaq"));
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        return students;
    }

    @GetMapping("/students/{studentIndex}")
    public Student getStudent(@PathVariable int studentIndex) {
        if (studentIndex < 0 || studentIndex >= students.size()) {
            throw new StudentNotFoundException("Student with this index doesn't exist!");
        }

        return students.get(studentIndex);
    }

}
