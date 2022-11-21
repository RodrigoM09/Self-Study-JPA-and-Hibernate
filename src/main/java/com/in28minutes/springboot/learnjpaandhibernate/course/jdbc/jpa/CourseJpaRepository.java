package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc.jpa;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJpaRepository {

    @PersistenceContext
   private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }
}
