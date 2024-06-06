package com.jobpost.jobpost.controller;

import com.jobpost.jobpost.model.Jobpost;
import com.jobpost.jobpost.service.JobpostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.net.ssl.SSLEngineResult;
import java.util.List;

@RestController
@RequestMapping("/jobpost")
public class JobPostController {
    @Autowired
    JobpostService jobpostService;

    @GetMapping("/all")
    public ResponseEntity<List<Jobpost>>findAllJobPost(){

        return new ResponseEntity(  jobpostService.findAllJobPost(),HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    public String deletePostReecord(@PathVariable int id){
            jobpostService.deleteJobPost(id);
        return "record is deleted";
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jobpost>findByJobId(@PathVariable int id){

    Jobpost jobposts = jobpostService.findByJobId(id);

        return new ResponseEntity<>(jobposts,HttpStatus.ACCEPTED);
    }

    @GetMapping("profile/{profile}")
    public ResponseEntity<List<Jobpost>>findByPostProfile(@PathVariable String profile){

        List<Jobpost> jobposts = jobpostService.findByPostProfile(profile);

        return new ResponseEntity<>(jobposts,HttpStatus.ACCEPTED);
    }

    @PostMapping("/update")
    public ResponseEntity<Jobpost> upadteJobPost(@RequestBody Jobpost jobpost){

        return new ResponseEntity<>(jobpostService.upadteJobPost(jobpost),HttpStatus.CREATED);
    }
}
