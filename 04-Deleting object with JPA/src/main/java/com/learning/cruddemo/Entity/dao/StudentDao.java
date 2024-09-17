package com.learning.cruddemo.Entity.dao;

import com.learning.cruddemo.Entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(Integer id);

    //defining method for querying
    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();

}
