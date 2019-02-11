package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.autocar.base.database.ConnectionProvider;
import edu.autocar.base.util.Input;

public class JDBCExample6 {

	public static void main(String[] args) {

		List<GoodsInfo> list = selectList();
		print(list);
		System.out.println();

		System.out.println("------------------------------------");
		String code = Input.getString("상품 코드 : ");
		System.out.println("수정할 정보를 입력하시오.");
		GoodsInfo g = selectOne(code);
		g = getGoodInfo(g);

		int result = update(g);
		if (result == -1) {
			System.err.println("업데이트에 실패했습니다.");
		} else {
			System.out.println();
		}
		list = selectList();
		print(list);
		System.out.println();

		System.out.println("삭제할 코드를 입력하시오.");
		code = Input.getString("상품 코드 : ");
		result = delete(code);
		if (result == -1) {
			System.err.println("삭제를 실패했습니다.");
		} else {
			System.out.println();
		}
		list = selectList();
		print(list);

		ConnectionProvider.close();
	}

	public static GoodsInfo map(ResultSet rs) throws SQLException {
		String code = rs.getString("code");
		String name = rs.getString("name");
		int price = rs.getInt("price");
		String maker = rs.getString("maker");

		return new GoodsInfo(code, name, price, maker);
	}

	// 상품 목록얻기
	public static List<GoodsInfo> selectList() {
		Connection conn = ConnectionProvider.getConnection();
		String sql = "select * from goodsinfo order by price";
		List<GoodsInfo> list = new ArrayList<>();
		try (Statement stmt = (Statement) conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
			while (rs.next()) {
				list.add(map(rs));
			}
			return list;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return null;
	}

	// 지정한 상품 코드로 GoodsInfo 얻기
	public static GoodsInfo selectOne(String code) {
		Connection conn = ConnectionProvider.getConnection();
		String sql = "select * from goodsinfo where code = '" + code + "'";
		try (Statement stmt = (Statement) conn.createStatement(); ResultSet rs = stmt.executeQuery(sql);) {
			if (rs.next()) {
				return map(rs);
			}
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return null;
	}

	// 사용자로부터 입력받은 정보로
	// 수정데이터를 가진 GoodsInfo 리턴
	public static GoodsInfo getGoodInfo(GoodsInfo g) {
		String msg;
		String code = g.getCode();

		msg = String.format("상품명(%s) : ", g.getName());
		String name = Input.getString(msg);
		if (name.equals(""))
			name = g.getName();

		msg = String.format("가격(%d) : ", g.getPrice());
		int price;
		String priceStr = Input.getString(msg);
		if (priceStr.equals("")) {
			price = g.getPrice();
		} else {
			price = Integer.parseInt(priceStr);
		}

		msg = String.format("제조사(%s) : ", g.getMaker());
		String maker = Input.getString(msg);
		if (maker.equals(""))
			maker = g.getMaker();

		return new GoodsInfo(code, name, price, maker);
	}

	// 전달한 GoodsInfo의 내용으로 업데이트하기
	public static int update(GoodsInfo g) {
		Connection conn = ConnectionProvider.getConnection();
		String sql = "update goodsinfo set name = ?, price = ?, maker = ? where code = ?";
		try (PreparedStatement pstmt = conn.prepareStatement(sql);) {
			pstmt.setString(1, g.getName());
			pstmt.setInt(2, g.getPrice());
			pstmt.setString(3, g.getMaker());
			pstmt.setString(4, g.getCode());
			int result = pstmt.executeUpdate();
			conn.commit();
			return result;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return -1;
	}

	public static void print(List<GoodsInfo> list) {
		System.out.println("상품코드 상품명\t가격\t\t제조사");
		System.out.println("--------------------------------------------");
		for (GoodsInfo gi : list) {
			System.out.printf("%s %-10s %-12d %-5s\n", gi.getCode(), gi.getName(), gi.getPrice(), gi.getMaker());
		}
	}

	public static int delete(String code) {
		Connection conn = ConnectionProvider.getConnection();
		String sql = "delete from goodsinfo where code = '" + code + "'";
		try (Statement stmt = conn.createStatement();) {
			int result = stmt.executeUpdate(sql);
			conn.commit();
			return result;
		} catch (SQLException se) {
			System.out.println(se.getMessage());
		}
		return -1;
	}
}
