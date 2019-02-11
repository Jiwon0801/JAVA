package edu.autocar.goodsinfo.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.database.CrudDao;
import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class EditCommand implements Command {

	@Override
	public void execute() throws Exception {
		CrudDao<GoodsInfo, String> dao = GoodsInfoDao.getInstance();
		
		String code = Input.getString("수정할 코드명 : ");
		GoodsInfo t = dao.selectOne(code);
		if(t == null)
		{
			System.out.println(code + " 상품이 존재하지 않습니다.");
			return;
		}
		t = getGoodInfo(t);
		dao.update(t);
		System.out.println("<수정 완료>");
	}

	
	private static GoodsInfo getGoodInfo(GoodsInfo t) {

		String name = Input.getString("상품명 : ", t.getName());
		int price = Input.getInt("상품가격 : ", t.getPrice());
		String maker = Input.getString("제조사 : ", t.getMaker());
		
		return new GoodsInfo(t.getCode(), name, price, maker);
	}
}
