package com.paipianwang.pat.facade.finance.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.finance.entity.PmsTeamInvoice;
import com.paipianwang.pat.facade.finance.service.PmsTeamInvoiceFacade;
import com.paipianwang.pat.facade.finance.service.biz.PmsTeamInvoiceBiz;

/**
 * 用户发票接口实现
 */
@Service("pmsTeamInvoiceFacade")
public class PmsTeamInvoiceServiceImpl implements PmsTeamInvoiceFacade {

	@Autowired
	private PmsTeamInvoiceBiz pmsTeamInvoiceBiz;

	@Override
	public DataGrid<PmsTeamInvoice> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsTeamInvoiceBiz.listWithPagination(pageParam, paramMap);
	}

	@Override
	public long update(final PmsTeamInvoice invoice) {
		return pmsTeamInvoiceBiz.update(invoice);
	}

	@Override
	public long save(final PmsTeamInvoice invoice) {
		return pmsTeamInvoiceBiz.save(invoice);
	}

	@Override
	public long deleteByIds(final long[] ids) {
		return pmsTeamInvoiceBiz.deleteByIds(ids);
	}

	@Override
	public long auditing(final PmsTeamInvoice invoice) {
		return pmsTeamInvoiceBiz.auditing(invoice);
	}

	@Override
	public long count(Map<String, Object> paramMap) {
		return pmsTeamInvoiceBiz.listPageCount(paramMap);
	}
	
	public List<PmsTeamInvoice> findTeamInvoiceWithCondition(final Map<String, Object> paramMap) {
		return pmsTeamInvoiceBiz.findTeamInvoiceWithCondition(paramMap);
	}

}
