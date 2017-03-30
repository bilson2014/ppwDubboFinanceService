package com.paipianwang.pat.facade.finance.service.dao.impl;

import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paipianwang.pat.common.core.dao.impl.BaseDaoImpl;
import com.paipianwang.pat.facade.finance.entity.PmsTeamInvoice;
import com.paipianwang.pat.facade.finance.service.dao.PmsTeamInvoiceDao;
@Repository
public class PmsTeamInvoiceDaoImpl extends BaseDaoImpl<PmsTeamInvoice> implements PmsTeamInvoiceDao {

	public static final String SQL_SAVE= "save";
	public static final String SQL_AGREE_INVOICE_BY_IDS= "agreeInvoiceByIds";
	public static final String SQL_DISAGREE_INVOICE= "disagreeInvoice";
	@Autowired
	private SqlSessionTemplate sessionTemplate = null;

	@Override
	public long save(final PmsTeamInvoice invoice) {
		return sessionTemplate.insert(getStatement(SQL_SAVE),invoice);
	}

	@Override
	public long agreeInvoiceByIds(final Map<String, Object> paramMap) {
		return sessionTemplate.update(getStatement(SQL_AGREE_INVOICE_BY_IDS),paramMap);
	}

	@Override
	public long disagreeInvoice(final PmsTeamInvoice invoice) {
		return sessionTemplate.update(getStatement(SQL_DISAGREE_INVOICE),invoice);
	}

}
