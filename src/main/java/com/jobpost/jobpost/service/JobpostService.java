package com.jobpost.jobpost.service;

import com.jobpost.jobpost.model.Jobpost;
import org.springframework.stereotype.Service;

import java.util.List;

public interface JobpostService {

    List<Jobpost> findAllJobPost();
    List<Jobpost> findByPostProfile(String profile);
    Jobpost upadteJobPost(Jobpost jobpost);
    String deleteJobPost(int jobId);
    Jobpost findByJobId(int jobId);
}
