package com.paipianwang.pat.facade.finance.service.biz;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.paipianwang.pat.common.constant.PmsConstant;
import com.paipianwang.pat.common.entity.DataGrid;
import com.paipianwang.pat.common.entity.PageParam;
import com.paipianwang.pat.common.util.ValidateUtil;
import com.paipianwang.pat.facade.finance.entity.PmsTeamInvoice;
import com.paipianwang.pat.facade.finance.entity.PmsUserInvoice;
import com.paipianwang.pat.facade.finance.service.dao.PmsUserInvoiceDao;

@Service
@Transactional
public class PmsUserInvoiceBiz {

	@Autowired
	private PmsUserInvoiceDao pmsUserInvoiceDao;

	public DataGrid<PmsUserInvoice> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsUserInvoiceDao.listWithPagination(pageParam, paramMap);
	}

	public long update(final PmsUserInvoice invoice) {

		final long ret = pmsUserInvoiceDao.update(invoice);
		return ret;
	}

	public long save(final PmsUserInvoice invoice) {
		final long ret = pmsUserInvoiceDao.save(invoice);
		return ret;
	}

	public long deleteByIds(final long[] ids) {
		if (ValidateUtil.isValid(ids)) {
			final long ret = pmsUserInvoiceDao.deleteByIds(ids);
			return ret;
		}
		return 0;
	}

	public long auditing(final PmsUserInvoice invoice) {
		int status = invoice.getInvoiceStatus();// 发票状态
		if (status == PmsConstant.INVOICE_STATUS_OK) {// 通过审核
			if (ValidateUtil.isValid(invoice.getIds())) {
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("array", invoice.getIds());
				return pmsUserInvoiceDao.agreeInvoiceByIds(paramMap);
			}
		} else if (status == PmsConstant.INVOICE_STATUS_NO) {// 未通过
			if (invoice.getInvoiceId() != 0) {
				return pmsUserInvoiceDao.disagreeInvoice(invoice);
			}
		}
		return 0;
	}

	public List<PmsUserInvoice> findUserInvoiceWithCondition(Map<String, Object> paramMap) {
		return pmsUserInvoiceDao.listBy(paramMap);
	}

}
