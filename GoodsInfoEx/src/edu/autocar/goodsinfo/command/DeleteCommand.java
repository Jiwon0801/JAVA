package edu.autocar.goodsinfo.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.database.CrudDao;
import edu.autocar.base.util.Input;
import edu.autocar.goodsinfo.dao.GoodsInfoDao;
import edu.autocar.goodsinfo.domain.GoodsInfo;

public class DeleteCommand implements Command {

	@Override
	public void execute() throws Exception {
		CrudDao<GoodsInfo, String> dao = GoodsInfoDao.getInstance();

		String code = Input.getString("삭제할 코드명 : ");
		int result = dao.delete(code);
		if (result == 1) {
			System.out.println("<삭제 완료>\n");
		} else {
			System.out.println(code + " 상품이 존재하지 않습니다.");
		}
	}

}
