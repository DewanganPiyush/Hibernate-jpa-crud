package com.learning.cruddemo.Entity.dao;

import com.learning.cruddemo.Entity.Student;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(Integer id);

}
