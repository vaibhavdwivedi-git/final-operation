package com.developer.springoraclejobdetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Detail {
    
    @Id
    private String id;

    @Column
    private String JOB_NM;

    @Column
    private String JOB_START_TS;

    @Column
    private String JOB_END_TS;

    @Column
    private String DURATION;
    
    @Column
    private String STATUS;


    public Detail(){}

    public Detail(String id, String jOB_NM, String jOB_START_TS, String jOB_END_TS, String dURATION, String sTATUS) {
        super();
        this.id = id;
        JOB_NM = jOB_NM;
        JOB_START_TS = jOB_START_TS;
        JOB_END_TS = jOB_END_TS;
        DURATION = dURATION;
        STATUS = sTATUS;
    }

   
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJOB_NM() {
        return JOB_NM;
    }

    public void setJOB_NM(String jOB_NM) {
        JOB_NM = jOB_NM;
    }

    public String getJOB_START_TS() {
        return JOB_START_TS;
    }

    public void setJOB_START_TS(String jOB_START_TS) {
        JOB_START_TS = jOB_START_TS;
    }

    public String getJOB_END_TS() {
        return JOB_END_TS;
    }

    public void setJOB_END_TS(String jOB_END_TS) {
        JOB_END_TS = jOB_END_TS;
    }

    public String getDURATION() {
        return DURATION;
    }

    public void setDURATION(String dURATION) {
        DURATION = dURATION;
    }
    
    
    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String sTATUS) {
        STATUS = sTATUS;
    }
    

}
