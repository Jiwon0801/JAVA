package edu.autocar.goodsinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.database.ConnectionProvider;
import edu.autocar.base.database.CrudDao;
import edu.autocar.goodsinfo.domain.Member;

public class MemberDao implements CrudDao<Member, String> {
	private static MemberDao dao = new MemberDao();
	private MemberDao() {}
	public static MemberDao getInstance() {
		return dao;
	}
	
	private Connection conn = ConnectionProvider.getConnection();
	
	private Member map(ResultSet rs) throws Exception {
		
		return Member.builder()
				.userId(rs.getString("user_id"))
				.password(rs.getString("password"))
				.name(rs.getString("name"))
				.email(rs.getString("email"))
				.phone(rs.getString("phone"))
				.address(rs.getString("address"))
				.regDate(rs.getDate("reg_date"))
				.updateDate(rs.getDate("update_date"))
				.build();
	}
	
	@Override
	public List<Member> selectList() throws Exception {
		String sql = "select * from Member order by user_id";
		
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);)
		{
			List<Member> list = new ArrayList<>();
			while(rs.next()) {
				list.add(map(rs));
			}
			return list;
		}
	}

	@Override
	public Member selectOne(String k) throws Exception {
		String sql = "select * from Member where user_id = '" + k + "'";
		try(Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);)
			{
				if(rs.next()) {
					return map(rs);
				}
			}
		return null;
	}

	@Override
	public int insert(Member t) throws Exception {
		String sql = "insert into Member "
				+ "(user_id, password, name, email, phone, address) "
				+ "values(?,?,?,?,?,?,?,?)";
		
		try(PreparedStatement pstmt = conn.prepareStatement(sql);)
		{
			pstmt.setString(1, t.getUserId());
			pstmt.setString(2, t.getPassword());
			pstmt.setString(3, t.getName());
			pstmt.setString(4, t.getEmail());
			pstmt.setString(5, t.getPhone());
			pstmt.setString(6, t.getAddress());
			
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
		}
	}

	@Override
	public int update(Member t) throws Exception {
		String sql = "update Member set "
				+ "name = ?, email = ?, phone = ?, address = ?, update_date = sysdate "
				+ "where user_id = ? and password = ?";
				
		try(PreparedStatement pstmt = conn.prepareStatement(sql);)
		{						
			pstmt.setString(1, t.getName());
			pstmt.setString(2, t.getEmail());
			pstmt.setString(3, t.getPhone());
			pstmt.setString(4, t.getAddress());
			pstmt.setString(5, t.getUserId());
			pstmt.setString(6, t.getPassword());
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
		}
	}

	@Override
	public int delete(String k) throws Exception {
		String sql = "delete from Member where user_id = '" + k + "'";		
		try(Statement stmt = conn.createStatement();)
			{
				int result = stmt.executeUpdate(sql);
				conn.commit();
				return result;
			}
	}

}
