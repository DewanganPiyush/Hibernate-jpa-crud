package com.learning.cruddemo;

import com.learning.cruddemo.Entity.Student;
import com.learning.cruddemo.Entity.dao.StudentDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDao studentDao) {
        return runner -> {
            //createMultipleStudent(studentDao);

            readStudent(studentDao);
        };
    }

    private void readStudent(StudentDao studentDao) {

        //create student object
        System.out.println("creating new student object");
        Student tempStudent = new Student("donald","duck","duckdonald@gmail.com");


        //save the object
        System.out.println("saving the student...");
        studentDao.save(tempStudent);

        //display id of the saved student
        int theId = tempStudent.getId();
        System.out.println("saved student generated id: " + theId);

        //retrive based on the student id: primary key
        System.out.println("retrieving student with id: " + theId);
        Student myStudent = studentDao.findById(theId);


        //display student
        System.out.println("Found the student: " + myStudent);
    }

    public void createMultipleStudent(StudentDao studentDao) {
        //create the multiple students
        System.out.println("creating multiple student object");
        Student tempStudent1 = new Student("loki","feruksen","loki333@gmail.com");
        Student tempStudent2 = new Student("ben","stokes","ben67@gmail.com");
        Student tempStudent3 = new Student("lasi","linga","linga@gmail.com");

        //save the students objects
        System.out.println("saving the student...");
        studentDao.save(tempStudent1);
        studentDao.save(tempStudent2);
        studentDao.save(tempStudent3);

        //display id of the saved student
        System.out.println("saved student generated id: " + tempStudent1.getId());
        System.out.println("saved student generated id: " + tempStudent2.getId());
        System.out.println("saved student generated id: " + tempStudent3.getId());
    }



    public void createStudent(StudentDao studentDao) {

        //create the student object
        System.out.println("creating new student object");
        Student tempStudent = new Student("paul","walker","paul123@gmail.com");

        //save the students objects
        System.out.println("saving the student...");
        studentDao.save(tempStudent);

        //display id of the saved student
        System.out.println("saved student generated id: " + tempStudent.getId());




    }

}
