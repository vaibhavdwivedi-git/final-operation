package com.developer.springoraclejobdetails;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.developer.springoraclejobdetails.controller.DetailController;
import com.developer.springoraclejobdetails.entity.Detail;
import com.developer.springoraclejobdetails.service.DetailService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DetailController.class)
public class DetailControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;
    @MockBean
    DetailService detailService;
    
    
    
    Detail RECORD_1 = new Detail(null, "Rayven Yor", "2022-06-25","2022-06-29","0000:0000","Success");
    
    @Test
    public void getAllRecords_success() throws Exception {
    List<Detail> records = new ArrayList<>(Arrays.asList(RECORD_1));
    
    Mockito.when(detailService.getDetails("all")).thenReturn(records);
    
    mockMvc.perform(MockMvcRequestBuilders
            .get("/api/all")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$").isNotEmpty())
            .andExpect(jsonPath("$[0].job_NM").value("Rayven Yor"));
}
}