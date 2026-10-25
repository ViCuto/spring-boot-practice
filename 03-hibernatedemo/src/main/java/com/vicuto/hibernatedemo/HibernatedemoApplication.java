package com.vicuto.hibernatedemo;

import com.vicuto.hibernatedemo.dao.StudentDAO;
import com.vicuto.hibernatedemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatedemoApplication.class, args);
	}

    // For CLI application
    // Executed after all beans are loaded
    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return _ ->
            createStudent(studentDAO);
            //createMultipleStudents(studentDAO);
            //readStudent(studentDAO);
            //queryForStudents(studentDAO);
            //queryForStudentsByLastName(studentDAO);
            //updateStudent(studentDAO);
            //deleteStudent(studentDAO);
            //deleteAllStudents(studentDAO);
    }

    private void createStudent(StudentDAO studentDAO) {
        IO.println("Creating a new student object...");
        Student student = new Student("Denitsa", "Petrova", "denitsa31@gmail.com");

        IO.println("Saving the student..");
        studentDAO.save(student);

        IO.println(String.format("Saved student. Generated id: %d", student.getId()));
    }

    private void createMultipleStudents(StudentDAO studentDAO) {
        IO.println("Creating 3 student object...");
        Student student1 = new Student("Viki", "Str", "vik@gmail.com");
        Student student2 = new Student("Raq", "Zaq", "raqthedog@gmail.com");
        Student student3 = new Student("Pirkko", "Petrov", "domatenceto@gmail.com");

        IO.println("Saving the students...");
        studentDAO.save(student1);
        studentDAO.save(student2);
        studentDAO.save(student3);
    }

    private void readStudent(StudentDAO studentDAO) {
        IO.println("Creating a new student object...");
        Student student = new Student("Lionel", "Messi", "thegoat@gmail.com");

        IO.println("Saving the student..");
        studentDAO.save(student);

        int id = student.getId();
        IO.println(String.format("Saved student. Generated id: %d", id));

        IO.println(String.format("Retrieving student with id: %d", id));
        Student myStudent = studentDAO.findById(id);
        IO.println("Found the student: " + myStudent);
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAll();

        students.forEach(IO::println);
    }

    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> students = studentDAO.findAllByLastName("Messi");

        students.forEach(IO::println);
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(2);

        IO.println("Updating student...");
        student.setFirstName("Viktor");

        studentDAO.update(student);
        IO.println(String.format("Updated student: %s", student));
    }

    private void deleteStudent(StudentDAO studentDAO) {
        int studentId = 4;
        IO.println(String.format("Deleting student with id: %d", studentId));

        studentDAO.delete(studentId);
    }

    private void deleteAllStudents(StudentDAO studentDAO) {
        IO.println("Deleting all students...");
        int numRowsDeleted = studentDAO.deleteAll();
        IO.println(String.format("Deleted row count: %d", numRowsDeleted));
    }

}
