package com.paipianwang.pat.facade.finance.service.dao.impl;


import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.finance.entity.PmsDealLog;
import com.paipianwang.pat.facade.finance.service.dao.PmsFinanceDao;
@Repository
public class PmsFinanceDaoImpl extends BaseDaoImpl<PmsDealLog> implements PmsFinanceDao {

	public static final String SQL_SAVE= "save";
	public static final String SQL_DELETE_BY_ARRAY= "deleteByArray";
	
	@Autowired
	private SqlSessionTemplate sessionTemplate = null;
	
	@Override
	public long save(PmsDealLog dealLog) {
		return sessionTemplate.insert(getStatement(SQL_SAVE),dealLog);
	}

	@Override
	public long deleteByArray(Map<String, Object> paramMap) {
		return sessionTemplate.delete(getStatement(SQL_DELETE_BY_ARRAY),paramMap);
	}

}
