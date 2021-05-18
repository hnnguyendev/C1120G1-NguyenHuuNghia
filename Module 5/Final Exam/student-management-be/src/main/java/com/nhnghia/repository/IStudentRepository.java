package com.nhnghia.repository;

import com.nhnghia.entity.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IStudentRepository extends JpaRepository<Student, Long> {

    Page<Student> findAll(Pageable pageable);

    @Query("select s from Student s where concat(s.id,s.name,s.team,s.topic,s.teacher.name,s.email,s.phone) like %?1%")
    List<Student> findByContaining(String txtSearch);

}
