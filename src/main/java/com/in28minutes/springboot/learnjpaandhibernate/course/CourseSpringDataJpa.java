package com.in28minutes.springboot.learnjpaandhibernate.course;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpa extends JpaRepository<Course, Long> {
        List<Course> findByAuthor(String author);
        List<Course> findByName(String name);

}
