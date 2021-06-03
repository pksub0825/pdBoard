package com.mysite2.pd.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysite2.db.ConnectionPoolMgr2;

public class PdDAO {
	private ConnectionPoolMgr2 pool;
	
	public PdDAO() {
		System.out.println("pddto 생성자 호출");
	}
	
	//DI-setter에 의한 종속객체 주입
	public void setPool(ConnectionPoolMgr2 pool) {
		this.pool=pool;
		System.out.println("setter 호출 : pddao-setPool()");
	}

	//1.입력, 수정시 사용 
	public int insertPd(PdDTO dto) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		
		try {
			con=pool.getConnection();
			
			String sql="insert into pd(no, pdname, price)"+
					" values(pd_seq.nextval,?,?)";
			ps=con.prepareStatement(sql);
			
			ps.setString(1, dto.getPdName());
			ps.setInt(2, dto.getPrice());
			
			int cnt=ps.executeUpdate();
			System.out.println("상품등록결과 cnt="+cnt+", 매개변수 dto="+dto);
			return cnt;
			
		}finally {
			pool.dbClose(ps, con);
		}
		
	}
	
}
