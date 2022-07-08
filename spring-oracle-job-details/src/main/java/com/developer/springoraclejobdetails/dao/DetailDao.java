package com.developer.springoraclejobdetails.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.developer.springoraclejobdetails.entity.Detail;
import com.developer.springoraclejobdetails.entity.FullDetail;

public class DetailDao {

	public List<Detail> findDetails(DataSource ds,String start,String end) {
		JdbcTemplate jdbcTemp = new JdbcTemplate(ds);
		String statusArray[] = {"Success","Failure","Not Started","In Progress"};
		Random rand = new Random();
		String variableQuery = "Select id, job_NM, job_START_TS, job_END_TS,(job_END_TS-job_START_TS) AS duration FROM employee_records where (job_START_TS BETWEEN '"+start+"' AND '"+end+"' )" ;
		String stableQuery = "Select id, job_NM, job_START_TS, job_END_TS,(job_END_TS-job_START_TS) AS duration FROM employee_records";
		String query = (start.equals(""))?(stableQuery):(variableQuery);
		List<Detail> list = jdbcTemp.query(
			    
				query,
				new RowMapper<Detail>() {
					@Override
					public Detail mapRow(ResultSet rs, int rowNum) throws SQLException {
						Detail det = new Detail();
						 
					
						det.setId(rs.getString("id"));
						det.setJOB_NM(rs.getString("job_NM"));
						det.setJOB_START_TS(rs.getString("job_START_TS"));
						det.setJOB_END_TS(rs.getString("job_END_TS"));
						det.setDURATION(rs.getString("duration"));
                        det.setSTATUS(statusArray[rand.nextInt(4)]);
						return det;
					}

				});

		return list;
	}

	public List<FullDetail> findFullDetails(DataSource ds,String id) {
		JdbcTemplate jdbcTemp = new JdbcTemplate(ds);
		String query = "SELECT tmsjrl.JOB_NM AS jobName, tmsjrl.JOB_ID AS jobId,tmsjrl.BUS_DT AS businessDate,tmsjrl.JOB_STAT_CD AS JobStatusCode,tmsjpdd.STAT_CD AS jonStepStatus, tmsjpdd.STEP_NM AS jobStepName, tmsjpdd.MFD_TRN_NO AS mfdTrnNo,tmsjpdd.FILE_NM AS fileName,tmsjpdd.DATA_RCRD_TXT AS jobDataRecordText, tmsjpdd.CUSTOMER_REF_NO AS custRefNo,tmsjpdd.INDIVIDUAL_TXN_IDENTIFIER AS indivTxnID FROM T_MFD_SCHD_JOB_RUN_LOG tmsjrl INNER JOIN T_MFD_SCHD_JOB_PROC_DATA_DTL tmsjpdd ON INSTR(tmsjpdd.JOB_ID,tmsjrl.JOB_ID) > 0 WHERE tmsjrl.JOB_ID="+id;
		List<FullDetail> list = jdbcTemp.query(
			    
				query,
				new RowMapper<FullDetail>() {
					@Override
					public FullDetail mapRow(ResultSet rs, int rowNum) throws SQLException {
						FullDetail det = new FullDetail();
						 
					
						det.setJOBID(rs.getString("jobId"));
						det.setJOBNAME(rs.getString("jobName"));
						det.setBUSINESSDATE(rs.getString("businessDate"));
						det.setJOBSTATUSCODE(rs.getString("JobStatusCode"));
						det.setJONSTEPSTATUS(rs.getString("jonStepStatus"));
                        det.setJOBSTEPNAME(rs.getString("jobStepName"));
						det.setMFDTRNNO(rs.getString("mfdTrnNo"));
						det.setFILENAME(rs.getString("fileName"));
						det.setJOBDATARECORDTEXT(rs.getString("jobDataRecordText"));
						det.setCUSTREFNO(rs.getString("custRefNo"));
						det.setINDIVTXNID(rs.getString("indivTxnID"));
						return det;
					}

				});

		return list;
	}

}

/* 
CREATE TABLE T_MFD_SCHD_JOB_RUN_LOG (
    JOB_NM varchar(255),
    JOB_ID varchar(255),
    BUS_DT varchar(255),
	JOB_STAT_CD varchar(255)
	);

CREATE TABLE T_MFD_SCHD_JOB_PROC_DATA_DTL (
	JOB_ID varchar(255),
	STAT_CD varchar(255),
	STEP_NM varchar(255),
	MFD_TRN_NO varchar(255),
	FILE_NM varchar(255),
	DATA_RCRD_TXT varchar(255),
	CUSTOMER_REF_NO varchar(255),
	INDIVIDUAL_TXN_IDENTIFIER varchar(255)
);


INSERT INTO T_MFD_SCHD_JOB_RUN_LOG
VALUES ("JOB_CM","5","25/02/2022","Complete");

INSERT INTO T_MFD_SCHD_JOB_PROC_DATA_DTL
VALUES ("5","BACKEND_COMPLETE","Wire.1","MFD25022022","CDFILENM","HJKSLJD","CUSTI45897","ID45HJL");
	*/