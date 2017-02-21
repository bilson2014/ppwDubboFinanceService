package com.paipianwang.pat.facade.finance.service.dao.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.finance.entity.PmsUserInvoice;
import com.paipianwang.pat.facade.finance.service.dao.PmsUserInvoiceDao;
@Repository
public class PmsUserInvoiceDaoImpl extends BaseDaoImpl<PmsUserInvoice> implements PmsUserInvoiceDao {

	public static final String SQL_SAVE= "save";
	public static final String SQL_AGREE_INVOICE_BY_IDS= "agreeInvoiceByIds";
	public static final String SQL_DISAGREE_INVOICE= "disagreeInvoice";
	public static final String SQL_DELETE_BY_IDS= "deleteByIds";
	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	@Override
	public long save(final PmsUserInvoice invoice) {
		return sessionTemplate.insert(getStatement(SQL_SAVE),invoice);
	}

	@Override
	public long agreeInvoiceByIds(final Map<String, Object> paramMap) {
		return sessionTemplate.update(getStatement(SQL_AGREE_INVOICE_BY_IDS),paramMap);
	}

	@Override
	public long disagreeInvoice(final PmsUserInvoice invoice) {
		return sessionTemplate.update(getStatement(SQL_DISAGREE_INVOICE),invoice);
	}

	@Override
	public long deleteByIds(Map<String, Object> paramMap) {
		return sessionTemplate.delete(getStatement(SQL_DELETE_BY_IDS),paramMap);
	}


}
