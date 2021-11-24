package se.iths.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotEmpty
    String courseName;


    @ManyToMany(mappedBy = "linkedSubject")
    private List<Student> linkedStudent =  new ArrayList<>();
    @ManyToOne
    private Teacher teacher;




    public Subject(@NotEmpty String courseName) {
        this.courseName = courseName;
    }
    public Subject() {

    }
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher){
    this.teacher = teacher;
}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public List<Student> getLinkedStudent() {
        return linkedStudent;
    }

    public void setLinkedStudent(List<Student> linkedStudent) {
        this.linkedStudent = linkedStudent;
    }


    public void addStudent(Student student) {
        linkedStudent.add(student);
    }
}
