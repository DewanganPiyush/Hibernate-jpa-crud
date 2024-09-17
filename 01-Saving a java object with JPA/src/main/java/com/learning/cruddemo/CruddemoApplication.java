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
            createMultipleStudent(studentDao);
        };
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
