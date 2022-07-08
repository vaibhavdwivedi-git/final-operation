package com.developer.springoraclejobdetails.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Service;

import com.developer.springoraclejobdetails.dao.DetailDao;
import com.developer.springoraclejobdetails.entity.Detail;
import com.developer.springoraclejobdetails.entity.FullDetail;

@Service
public class DetailService {

    @Bean
    public DriverManagerDataSource getDataSource() {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/employee");
        ds.setUsername("root");
        ds.setPassword("21102002");

        return ds;
    }

    public List<Detail> getDetails(String id) throws ParseException {
        DetailDao dao = new DetailDao();
        if (id.equals("all")) {
            return dao.findDetails(getDataSource(), "", "");
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  hh:mm:ss");
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DATE, -Integer.parseInt(id));
        String start = sdf.format(c.getTime());
        String end = sdf.format(new Date());
        System.out.println(start);
        System.out.println(end);
        return dao.findDetails(getDataSource(), start, end);
    }

    public List<FullDetail> getFullDetails(String id) throws ParseException {
        DetailDao dao = new DetailDao();
        return dao.findFullDetails(getDataSource(),id);
    }

}
