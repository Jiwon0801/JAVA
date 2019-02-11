package edu.autocar.mybatisex.dao;

import edu.autocar.base.database.CrudDao;
import edu.autocar.base.database.PaginationDao;
import edu.autocar.mybatisex.domain.GoodsInfo;

public interface GoodsInfoDao extends CrudDao<GoodsInfo, String>, PaginationDao<GoodsInfo>{

}
