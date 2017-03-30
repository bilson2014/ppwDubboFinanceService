package com.paipianwang.pat.facade.finance.service.dao;

import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.finance.entity.PmsUserInvoice;

/**
 * 用户发票管理数据访问接口
 */
public interface PmsUserInvoiceDao  extends BaseDao<PmsUserInvoice>{

	public long save(final PmsUserInvoice invoice);

	public long agreeInvoiceByIds(final Map<String, Object> paramMap);

	public long disagreeInvoice(final PmsUserInvoice invoice);

}
