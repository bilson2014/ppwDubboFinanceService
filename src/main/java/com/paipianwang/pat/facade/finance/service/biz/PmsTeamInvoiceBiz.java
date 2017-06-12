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
import com.paipianwang.pat.facade.finance.service.dao.PmsTeamInvoiceDao;

@Service
@Transactional
public class PmsTeamInvoiceBiz {

	@Autowired
	private PmsTeamInvoiceDao pmsTeamInvoiceDao;
	
	public DataGrid<PmsTeamInvoice> listWithPagination(PageParam pageParam, Map<String, Object> paramMap) {
		return pmsTeamInvoiceDao.listWithPagination(pageParam, paramMap);
	}
	public long update(final PmsTeamInvoice invoice) {
		
		final long ret = pmsTeamInvoiceDao.update(invoice);
		return ret;
	}
	public long save(final PmsTeamInvoice invoice) {
		final long ret = pmsTeamInvoiceDao.save(invoice);
		return ret;
	}
	public long deleteByIds(final long[] ids) {
		if(ValidateUtil.isValid(ids)) {
			final long ret = pmsTeamInvoiceDao.deleteByIds(ids);
			return ret;
		}
		return 0;
	}
	public long auditing(final PmsTeamInvoice invoice) {
		int status = invoice.getInvoiceStatus();//发票状态
		if(status == PmsConstant.INVOICE_STATUS_OK){//通过审核
			if(ValidateUtil.isValid(invoice.getIds())){
				Map<String, Object> paramMap = new HashMap<>();
				paramMap.put("array", invoice.getIds());
				return pmsTeamInvoiceDao.agreeInvoiceByIds(paramMap);
			}
		}else if(status == PmsConstant.INVOICE_STATUS_NO){//未通过
			if(invoice.getInvoiceId()!=0){
				return pmsTeamInvoiceDao.disagreeInvoice(invoice);
			}
		}
		return 0;
	}
	
	public long listPageCount(Map<String, Object> paramMap) {
		return pmsTeamInvoiceDao.listPageCount(paramMap);
	}
	
	public List<PmsTeamInvoice> findTeamInvoiceWithCondition(Map<String, Object> paramMap) {
		return pmsTeamInvoiceDao.listBy(paramMap);
	}

}
