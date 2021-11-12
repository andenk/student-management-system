package se.iths.service;


import se.iths.entity.Student;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.core.Response;
import java.util.*;

@Transactional
public class StudentService {

    @PersistenceContext
    EntityManager entityManager;
    public Student createItem(Student student) {

        entityManager.persist(student);
        return student;
    }

    public List<Student> getAllStudents() {

        return entityManager.createQuery("SELECT s from Student s", Student.class).getResultList();
    }

    public void deleteStudent(Long id) {
        Student foundStudent = entityManager.find(Student.class, id);
        entityManager.remove(foundStudent);
    }

    public Student updateStudent(Student student) {
        entityManager.merge(student);
        return student;
    }
}
