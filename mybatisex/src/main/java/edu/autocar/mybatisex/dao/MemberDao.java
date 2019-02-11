package edu.autocar.mybatisex.dao;

import edu.autocar.base.database.CrudDao;
import edu.autocar.base.database.PaginationDao;
import edu.autocar.mybatisex.domain.Member;

public interface MemberDao extends CrudDao<Member, String>, PaginationDao<Member>{
	
	int updatePassword(Member m) throws Exception;
}
