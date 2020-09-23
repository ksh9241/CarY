package car.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.domain.CarInfoVO;
import project.persistence.CarDAOMyBatis;

public class SearchAction extends AbstractAction {
	
	CarDAOMyBatis dao=new CarDAOMyBatis();
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session=req.getSession();
		//1. 검색한 값 가져오기
		String search=req.getParameter("search");
		
		if(search==null||search.trim().isEmpty()) {
			search=(String)session.getAttribute("search"); 
		}
		session.setAttribute("search", search);
		
		
		List<Integer> search2=dao.changeCode(search);
		
		
		
		
		
		String cpStr =req.getParameter("cpage");
		if(cpStr==null||cpStr.trim().isEmpty()) {
			cpStr= "1";
		}
		int cpage = Integer.parseInt(cpStr);
		String a = req.getParameter("pageSize2");
		
		if(a==null||a.trim().isEmpty()) {
			a =(String)session.getAttribute("pageSize2");
			if(a == null) {
				a = "15";
			}
		}
		session.setAttribute("pageSize2", a);
		
		//2. 검색한 차량 수 가져오기
		int Count=dao.getSearchCount(search2);
		
		int pageSize2 = Integer.parseInt(a.trim());
		
		int pageCount2 = (Count - 1)/pageSize2 +1;
		if(cpage < 1) {
			cpage=1;
		}
		if(cpage > pageCount2) {
			cpage=pageCount2;
		}
		int end= cpage * pageSize2;
		int start =end - (pageSize2 -1);
		Map<String,Object> se = new HashMap<String, Object>();
		se.put("start", start);
		se.put("end", end);
		se.put("search", search2); 
		
		//3. 검색된 차량 페이징처리에 맞게 가져오기
		List<CarInfoVO> arr=dao.searchCarList(se);
		
				
		int pagingBlock2 =5;
		int prevBlock2 = 0, nextBlock2 =0;
		
		prevBlock2 = (cpage-1)/pagingBlock2*pagingBlock2;
		nextBlock2 = prevBlock2+(pagingBlock2+1);
		
		req.setAttribute("Count", Count);
		req.setAttribute("searchList", arr);
		req.setAttribute("pageCount2", pageCount2);
		req.setAttribute("cpage", cpage);
		req.setAttribute("pagingBlock2", pagingBlock2);
		req.setAttribute("prevBlock2", prevBlock2);
		req.setAttribute("nextBlock2", nextBlock2);
		req.setAttribute("search", search);
		
		
		this.setViewPage("car/ajaxval.jsp");
		this.setRedirect(false);

	}

}
