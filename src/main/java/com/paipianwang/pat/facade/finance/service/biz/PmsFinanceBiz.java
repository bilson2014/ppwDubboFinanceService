package com.paipianwang.pat.facade.finance.service.biz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.common.constant.PmsConstant;
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

	@SuppressWarnings("unchecked")
	@Transactional
	public Map<String, List<Map<String, Object>>> listByMap(List<String> metaData, String projectId) {
		Map<String, Map<String, Object>> param = new HashMap<String, Map<String, Object>>();
		Map<String, Object> metaMap = new HashMap<String, Object>();
		Map<String, Object> condition = new HashMap<String, Object>();
		for (final String column : metaData) {
			if (StringUtils.isNotBlank(column))
				metaMap.put(column, null);
		}

		condition.put("dl_project_id", projectId);
		param.put(PmsConstant.SQL_METADATA, metaMap);
		param.put(PmsConstant.SQL_CONDITION, condition);
		List<Object> list = pmsFinanceDao.listByMap(param);
		if(list != null && !list.isEmpty()) {
			Map<String, List<Map<String, Object>>> result = new HashMap<String, List<Map<String, Object>>>();
			for(int i = 0;i < list.size(); i ++) {
				HashMap<String, Object> map = (HashMap<String, Object>) list.get(i);
				if(map != null && !map.isEmpty()) {
					String userType = (String) map.get("dl_user_typr");
					if(PmsConstant.ROLE_CUSTOMER.equals(userType)) {
						List<Map<String, Object>> customer = result.get(PmsConstant.ROLE_CUSTOMER);
						if(customer != null && !customer.isEmpty()) {
							customer.add(map);
						} else {
							customer = new ArrayList<Map<String, Object>>();
							customer.add(map);
							result.put(PmsConstant.ROLE_CUSTOMER, customer);
						}
					} else if(PmsConstant.ROLE_PROVIDER.equals(userType)) {
						List<Map<String, Object>> provider = result.get(PmsConstant.ROLE_PROVIDER);
						if(provider != null && !provider.isEmpty()) {
							provider.add(map);
						} else {
							provider = new ArrayList<Map<String, Object>>();
							provider.add(map);
							result.put(PmsConstant.ROLE_PROVIDER, provider);
						}
					}
				}
			}
			return result;
		}
		return null;
	}
	
	
}
