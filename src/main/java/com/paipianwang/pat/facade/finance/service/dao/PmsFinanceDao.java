package com.paipianwang.pat.facade.finance.service.dao;



import java.util.Map;

import com.paipianwang.pat.common.core.dao.BaseDao;
import com.paipianwang.pat.facade.finance.entity.PmsDealLog;

public interface PmsFinanceDao extends BaseDao<PmsDealLog>{

	public long save(final PmsDealLog dealLog);

	public long deleteByArray(final Map<String, Object> paramMap);

}
