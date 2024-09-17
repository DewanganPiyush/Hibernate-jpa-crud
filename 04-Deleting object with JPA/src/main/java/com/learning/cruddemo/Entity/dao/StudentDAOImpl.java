package com.learning.cruddemo.Entity.dao;

import com.learning.cruddemo.Entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDao{

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection

    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {

        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("select s from Student s", Student.class);

        //return query result

        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {

        //create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName= :theData", Student.class);

        //set query parameters
        theQuery.setParameter("theData", theLastName);

        //return query results
        return theQuery.getResultList();


    }

    @Override
    @Transactional //we are updating the database
    public void update(Student theStudent) {
        entityManager.merge(theStudent);



    }

    @Override
    @Transactional
    public void delete(Integer id) {
        //retrive the student
        Student theStudent = entityManager.find(Student.class, id);

        //delete the student
        entityManager.remove(theStudent);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted = entityManager.createQuery("DELETE FROM Student ").executeUpdate();
        return numRowsDeleted;
    }
}
