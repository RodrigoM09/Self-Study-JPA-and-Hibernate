package com.in28minutes.springboot.learnjpaandhibernate.course.jdbc;

import com.in28minutes.springboot.learnjpaandhibernate.course.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.conversion.DbAction;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJdbcRepository {

    @Autowired
    private JdbcTemplate springJdbcTemplate;

    private static String INSERT_QUERY =
            """
                    insert Longo course(id, name, author)
                    values(?, ?, ?);
         
            """;

    private static String DELETE_QUERY =
            """
                delete FROM course
                where id = ?
            """;
    private static String SELECT_QUERY =
            """
                select * FROM course
                where id = ?
            """;

    public void insert(Course course){
        springJdbcTemplate.update(INSERT_QUERY,
                course.getId(), course.getName(), course.getAuthor());
    }
    public void deleteById(Long id){
        springJdbcTemplate.update(DELETE_QUERY, id);
    }
    public Course selectById(Long id){
        //ResultSet -> Bean -> Row Mapper ->
       return springJdbcTemplate.queryForObject(SELECT_QUERY,
               new BeanPropertyRowMapper<>(Course.class), id);
    }
}
