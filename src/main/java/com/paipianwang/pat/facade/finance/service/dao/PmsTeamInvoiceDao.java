package com.paipianwang.pat.facade.finance.service.dao;


import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.finance.entity.PmsTeamInvoice;

/**
 * 用户发票管理数据访问接口
 */
public interface PmsTeamInvoiceDao  extends BaseDao<PmsTeamInvoice>{

	public long save(final PmsTeamInvoice invoice);

	public long agreeInvoiceByIds(final Map<String, Object> paramMap);

	public long disagreeInvoice(final PmsTeamInvoice invoice);

	public long deleteByIds(Map<String, Object> paramMap);
}
