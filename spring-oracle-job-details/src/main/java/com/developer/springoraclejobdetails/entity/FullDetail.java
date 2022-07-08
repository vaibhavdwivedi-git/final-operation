package com.developer.springoraclejobdetails.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FullDetail {

    @Id
    private String JOBID;

    @Column
    private String JOBNAME;


    public FullDetail(){}


    public FullDetail(String jOBID, String jOBNAME, String bUSINESSDATE, String jOBSTATUSCODE, String jONSTEPSTATUS,
            String jOBSTEPNAME, String mFDTRNNO, String fILENAME, String jOBDATARECORDTEXT, String cUSTREFNO,
            String iNDIVTXNID) {
        JOBID = jOBID;
        JOBNAME = jOBNAME;
        BUSINESSDATE = bUSINESSDATE;
        JOBSTATUSCODE = jOBSTATUSCODE;
        JONSTEPSTATUS = jONSTEPSTATUS;
        JOBSTEPNAME = jOBSTEPNAME;
        MFDTRNNO = mFDTRNNO;
        FILENAME = fILENAME;
        JOBDATARECORDTEXT = jOBDATARECORDTEXT;
        CUSTREFNO = cUSTREFNO;
        INDIVTXNID = iNDIVTXNID;
    }

    @Column
    private String BUSINESSDATE;

    @Column
    private String JOBSTATUSCODE;

    public String getJOBID() {
        return JOBID;
    }

    public void setJOBID(String jOBID) {
        JOBID = jOBID;
    }

    public String getJOBNAME() {
        return JOBNAME;
    }

    public void setJOBNAME(String jOBNAME) {
        JOBNAME = jOBNAME;
    }

    public String getBUSINESSDATE() {
        return BUSINESSDATE;
    }

    public void setBUSINESSDATE(String bUSINESSDATE) {
        BUSINESSDATE = bUSINESSDATE;
    }

    public String getJOBSTATUSCODE() {
        return JOBSTATUSCODE;
    }

    public void setJOBSTATUSCODE(String jOBSTATUSCODE) {
        JOBSTATUSCODE = jOBSTATUSCODE;
    }

    public String getJONSTEPSTATUS() {
        return JONSTEPSTATUS;
    }

    public void setJONSTEPSTATUS(String jONSTEPSTATUS) {
        JONSTEPSTATUS = jONSTEPSTATUS;
    }

    public String getJOBSTEPNAME() {
        return JOBSTEPNAME;
    }

    public void setJOBSTEPNAME(String jOBSTEPNAME) {
        JOBSTEPNAME = jOBSTEPNAME;
    }

    public String getMFDTRNNO() {
        return MFDTRNNO;
    }

    public void setMFDTRNNO(String mFDTRNNO) {
        MFDTRNNO = mFDTRNNO;
    }

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String fILENAME) {
        FILENAME = fILENAME;
    }

    public String getJOBDATARECORDTEXT() {
        return JOBDATARECORDTEXT;
    }

    public void setJOBDATARECORDTEXT(String jOBDATARECORDTEXT) {
        JOBDATARECORDTEXT = jOBDATARECORDTEXT;
    }

    public String getCUSTREFNO() {
        return CUSTREFNO;
    }

    public void setCUSTREFNO(String cUSTREFNO) {
        CUSTREFNO = cUSTREFNO;
    }

    public String getINDIVTXNID() {
        return INDIVTXNID;
    }

    public void setINDIVTXNID(String iNDIVTXNID) {
        INDIVTXNID = iNDIVTXNID;
    }

    @Column
    private String JONSTEPSTATUS;
    
    @Column
    private String JOBSTEPNAME;

    @Column
    private String MFDTRNNO;

    @Column
    private String FILENAME;

    @Column
    private String JOBDATARECORDTEXT;

    @Column
    private String CUSTREFNO;

    @Column
    private String INDIVTXNID;


    

    
}
