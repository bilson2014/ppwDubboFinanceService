package com.paipianwang.pat.facade.finance.service.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.finance.entity.PmsDealLog;
import com.paipianwang.pat.facade.finance.service.dao.PmsFinanceDao;


@Service
@Transactional
public class PmsFinanceBiz {

	@Autowired
	private PmsFinanceDao pmsFinanceDao;

	public DataGrid<PmsDealLog> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsFinanceDao.listWithPagination(pageParam, paramMap);
	}

	public long save(final PmsDealLog dealLog) {
		return pmsFinanceDao.save(dealLog);
	}

	public long update(final PmsDealLog dealLog) {
		return pmsFinanceDao.update(dealLog);
	}

	@Transactional
	public long deleteByArray(final long[] ids) {
		if(ValidateUtil.isValid(ids)){
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("array", ids);
			final long ret = pmsFinanceDao.deleteByArray(paramMap);
			return ret;
		}
		return 0l;
	}

	@Transactional
	public List<PmsDealLog> listBy(String projectId) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("projectId", projectId);
		return pmsFinanceDao.listBy(paramMap);
	}
	
}
