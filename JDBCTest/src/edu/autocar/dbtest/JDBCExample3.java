package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import edu.autocar.base.util.Input;
import edu.autocar.base.util.Resource;

public class JDBCExample3 {

	public static void main(String[] args) {
		String name = Input.getString("찾을 상품명 : ");
		String sql = "select code, name, price, maker from goodsinfo " + "where name like '%" + name + "%' "
				+ "order by price";
		List<GoodsInfo> list = new ArrayList<>();

		Properties props;
		try {
			props = Resource.getProperties("/database.properties");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return;
		} 
		
		String url = props.getProperty("url");
		String username = props.getProperty("username");
		String password = props.getProperty("password");
		
		try (Connection conn = (Connection) DriverManager.getConnection(url, username, password);
				Statement stmt = (Statement) conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				list.add(map(rs));
			}
			print(list);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

	}

	public static GoodsInfo map(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		String maker = rs.getString("maker");

		return new GoodsInfo(code, name, price, maker);
	}

	public static void print(List<GoodsInfo> list) {
		System.out.println("상품코드 상품명\t가격\t\t제조사");
		System.out.println("--------------------------------------------");
		for (GoodsInfo gi : list) {
			System.out.printf("%s %-10s %-12d %-5s\n", gi.getCode(), gi.getName(), gi.getPrice(), gi.getMaker());
		}
	}
}
