package com.paipianwang.pat.facade.finance.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.facade.finance.entity.PmsUserInvoice;
import com.paipianwang.pat.facade.finance.service.PmsUserInvoiceFacade;
import com.paipianwang.pat.facade.finance.service.biz.PmsUserInvoiceBiz;

/**
 * 用户发票接口实现
 */
@Service("pmsUserInvoiceFacade")
public class PmsUserInvoiceServiceImpl implements PmsUserInvoiceFacade {

	@Autowired
	private PmsUserInvoiceBiz pmsUserInvoiceBiz;

	@Override
	public DataGrid<PmsUserInvoice> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsUserInvoiceBiz.listWithPagination(pageParam, paramMap);
	}

	@Override
	public long update(final PmsUserInvoice invoice) {
		return pmsUserInvoiceBiz.update(invoice);
	}

	@Override
	public long save(final PmsUserInvoice invoice) {
		return pmsUserInvoiceBiz.save(invoice);
	}

	@Override
	public long deleteByIds(final long[] ids) {
		return pmsUserInvoiceBiz.deleteByIds(ids);
	}

	@Override
	public long auditing(final PmsUserInvoice invoice) {
		return pmsUserInvoiceBiz.auditing(invoice);
	}

}
