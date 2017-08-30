package com.paipianwang.pat.facade.finance.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.finance.entity.PmsDealLog;
import com.paipianwang.pat.facade.finance.service.PmsFinanceFacade;
import com.paipianwang.pat.facade.finance.service.biz.PmsFinanceBiz;

@Service("pmsFinanceFacade")
public class PmsFinanceServiceImpl implements PmsFinanceFacade {

	@Autowired
	private PmsFinanceBiz pmsFinanceBiz;

	@Override
	public DataGrid<PmsDealLog> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsFinanceBiz.listWithPagination(pageParam, paramMap);
	}

	@Override
	public long save(final PmsDealLog dealLog) {
		return pmsFinanceBiz.save(dealLog);
	}

	@Override
	public long update(final PmsDealLog dealLog) {
		return pmsFinanceBiz.update(dealLog);
	}

	@Override
	public long deleteByArray(final long[] ids) {
		return pmsFinanceBiz.deleteByArray(ids);
	}

	@Override
	public boolean isExistByProjectId(final String projectId) {
		if (StringUtils.isNotBlank(projectId)) {
			List<PmsDealLog> list = pmsFinanceBiz.listBy(projectId);
			if (list == null)
				return false;
		}
		return true;
	}

	@Override
	public Map<String, List<Map<String, Object>>> getFinancesByProjectId(List<String> metaData, String projectId) {
		if(metaData != null && !metaData.isEmpty() && StringUtils.isNotEmpty(projectId)) {
			return pmsFinanceBiz.listByMap(metaData, projectId);
		}
		return null;
	}

}
