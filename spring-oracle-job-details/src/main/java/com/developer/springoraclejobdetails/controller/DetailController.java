package com.developer.springoraclejobdetails.controller;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.developer.springoraclejobdetails.entity.Detail;
import com.developer.springoraclejobdetails.entity.FullDetail;
import com.developer.springoraclejobdetails.service.DetailService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("api/")
public class DetailController {
    
    @Autowired
    private DetailService detailService;



    @GetMapping("/{id}")
    @ResponseBody
    public List<Detail> getDetails(@PathVariable String id)throws ParseException{
        return detailService.getDetails(id);
    }
    
    @GetMapping("detail/{id}")
    @ResponseBody
    public List<FullDetail> getFullDetails(@PathVariable String id)throws ParseException{
        return detailService.getFullDetails(id);
    }
    

}
