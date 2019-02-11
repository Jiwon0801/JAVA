package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.database.ConnectionProvider;
import edu.autocar.base.util.Input;

public class JDBCExample4 {

	public static void main(String[] args) {
		String name = Input.getString("찾을 상품명 : ");
		String sql = "select code, name, price, maker from goodsinfo " + "where name like '%" + name + "%' "
				+ "order by price";

		Connection conn = ConnectionProvider.getConnection();

		try (Statement stmt = (Statement) conn.createStatement(); 
				ResultSet rs = stmt.executeQuery(sql);) {
			List<GoodsInfo> list = new ArrayList<>();
			while (rs.next()) {
				list.add(map(rs));
			}
			print(list);
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}

		ConnectionProvider.close();
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
