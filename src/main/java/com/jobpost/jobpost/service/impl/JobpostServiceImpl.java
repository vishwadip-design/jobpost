package com.jobpost.jobpost.service.impl;

import com.jobpost.jobpost.model.Jobpost;
import com.jobpost.jobpost.repository.JobpostRepository;
import com.jobpost.jobpost.service.JobpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobpostServiceImpl implements JobpostService {

    @Autowired
    JobpostRepository jobpostRepository;

    @Override
    public List<Jobpost> findAllJobPost() {
        return jobpostRepository.findAll();
    }

    @Override
    public List<Jobpost> findByPostProfile(String profile) {
        return jobpostRepository.findByPostProfileContaining(profile);
    }

    @Override
    public Jobpost upadteJobPost(Jobpost jobpost) {
        return jobpostRepository.save(jobpost);
    }

    @Override
    public String deleteJobPost(int jobId) {
        jobpostRepository.deleteById(jobId);
        return "record is deleted";
    }

    @Override
    public Jobpost findByJobId(int jobId) {
        return jobpostRepository.findById(jobId).get();
    }
}
