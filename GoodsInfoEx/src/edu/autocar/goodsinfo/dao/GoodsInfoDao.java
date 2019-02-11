package edu.autocar.goodsinfo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.database.ConnectionProvider;
import edu.autocar.base.database.CrudDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class GoodsInfoDao implements CrudDao<GoodsInfo, String> {

	private static GoodsInfoDao instance = new GoodsInfoDao();
	private GoodsInfoDao() {}
	public static GoodsInfoDao getInstance() {
		return instance;
	}
	
	private Connection conn = ConnectionProvider.getConnection();

	private GoodsInfo map(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		String maker = rs.getString("maker");

		return new GoodsInfo(code, name, price, maker);
	}

	@Override
	public List<GoodsInfo> selectList() throws Exception {
		String sql = "select * from goodsinfo order by price";
		
		try (Statement stmt = (Statement) conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql);) {
			List<GoodsInfo> list = new ArrayList<>();
			while (rs.next()) {
				list.add(map(rs));
			}
			return list;
		}
	}

	@Override
	public GoodsInfo selectOne(String k) throws Exception {
		String sql = "select * from goodsinfo where code = '" + k + "'";
		try (Statement stmt = (Statement) conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				return map(rs);
			}
		}
		return null;
	}

	@Override
	public int insert(GoodsInfo t) throws Exception {
		String sql = "insert into goodsinfo (code, name, price, maker) values(?,?,?,?)";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, t.getCode());
			pstmt.setString(2, t.getName());
			pstmt.setInt(3, t.getPrice());
			pstmt.setString(4, t.getMaker());	
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
		}
	}

	@Override
	public int update(GoodsInfo t) throws Exception {
		String sql = "update goodsinfo set name = ?, price = ?, maker = ? where code = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, t.getName());
			pstmt.setInt(2, t.getPrice());
			pstmt.setString(3, t.getMaker());
			pstmt.setString(4, t.getCode());
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
		}
	}

	@Override
	public int delete(String k) throws Exception {
		String sql = "delete from goodsinfo where code = '" + k + "'";
		try (Statement stmt = conn.createStatement();) {
			int result = stmt.executeUpdate(sql);
			conn.commit();
			return result;
		}
	}

}
