package com.mysite2.pd.model;

import java.sql.SQLException;

public class PdService {
	private PdDAO pdDao;
	
	public PdService() {
		System.out.println("pdSerivce 생성자 호출");
	}

	public void setPdDao(PdDAO pdDao) {
		this.pdDao=pdDao;
		System.out.println("setter 호출 : PdSerivce-setPdDAO()");
	}
	
	public int insertPd(PdDTO dto) throws SQLException {
		return pdDao.insertPd(dto);
	}
	
}
