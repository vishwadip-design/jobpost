package com.jobpost.jobpost.repository;

import com.jobpost.jobpost.model.Jobpost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobpostRepository extends JpaRepository<Jobpost,Integer> {

    public List<Jobpost>findByPostProfileContaining(String id);
}
