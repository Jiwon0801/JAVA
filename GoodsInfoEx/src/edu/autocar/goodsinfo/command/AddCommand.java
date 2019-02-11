package edu.autocar.goodsinfo.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.database.CrudDao;
import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class AddCommand implements Command {

	@Override
	public void execute() throws Exception {
		CrudDao<GoodsInfo, String> dao = GoodsInfoDao.getInstance();

		System.out.println("추가 상품 정보를 입력하세요.");
		GoodsInfo t = getGoodInfo();
		dao.insert(t);
		
		System.out.println("<추가 완료>\n");
	}

	private static GoodsInfo getGoodInfo() {

		String code = Input.getString("상품코드 : ");
		String name = Input.getString("상품명 : ");
		int price = Input.getInt("상품가격 : ");
		String maker = Input.getString("제조사 : ");
		return new GoodsInfo(code, name, price, maker);
	}
}
