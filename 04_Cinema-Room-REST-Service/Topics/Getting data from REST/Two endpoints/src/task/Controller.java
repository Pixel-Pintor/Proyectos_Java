package task;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class Controller {
    Student s1 = new Student(1, "Jim");
    Student s2 = new Student(2, "Mike");
    Student s3 = new Student(3, "Dwight");
    List<Student> studentList = List.of(s1, s2, s3);

    @GetMapping("/students")
    public List<Student> getStudentList() {
        return studentList;
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable int id) {
        return studentList.get(id - 1);
    }
}

class Student {
    int id;
    String name;

    Student (int i, String n) {
        this.id = i;
        this.name = n;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}