package edu.autocar.dbtest;

import java.sql.Connection;
import java.sql.PreparedStatement;

import edu.autocar.base.database.ConnectionProvider;

public class JDBCExample2 {

	public static void main(String[] args) {
		if (args.length != 4) {
			System.out.println("Usage : java JDBCExample2 상품코드 상품명 가격 제조사");
			return;
		}
		String sql = "insert into goodsinfo (code, name, price, maker) values(?,?,?,?) ";
		Connection conn = ConnectionProvider.getConnection();
		try (
//				Statement stmt = (Statement)conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(sql);) {
//			int rowNum = stmt.executeUpdate(sql);
			pstmt.setString(1, args[0]);
			pstmt.setString(2, args[1]);
			pstmt.setInt(3, Integer.parseInt(args[2]));
			pstmt.setString(4, args[3]);
			int rowNum = pstmt.executeUpdate();
			System.out.println(rowNum + "행이 추가되었습니다.");
			conn.commit();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		ConnectionProvider.close();
	}

}
