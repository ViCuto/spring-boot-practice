package com.vicuto.hibernatedemo.dao;

import com.vicuto.hibernatedemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {

    private final EntityManager entityManager;

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query = entityManager
            .createQuery("SELECT s FROM Student s ORDER BY s.firstName", Student.class);

        return query.getResultList();
    }

    @Override
    public List<Student> findAllByLastName(String lastName) {
        TypedQuery<Student> query = entityManager
            .createQuery("SELECT s FROM Student s WHERE s.lastName=:data", Student.class);
        query.setParameter("data", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(int id) {
        Student student = findById(id);

        entityManager.remove(student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        return entityManager
            .createQuery("DELETE FROM Student s").executeUpdate();
    }

}
