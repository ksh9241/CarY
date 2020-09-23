package customerService.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CsVO;
import project.persistence.CSDAOMybatis;

public class CSIndexAction extends AbstractAction {

	public void execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception{
		//1.dao 선언		
		CSDAOMybatis csdao = new CSDAOMybatis();
		
		//2.dao에서 select문 써서 method만들어주고 이때 전체 데이터 가져와야한다
		
		//3.List<CsVO> csList 
		
		
		//4.setAttribute("",);
		String pStr = req.getParameter("page");
		if (pStr == null || pStr.trim().isEmpty()) {
			pStr = "1";
		}

		int page = Integer.parseInt(pStr);


		// 총 게시글 수 가져오기
		
		int totalCount = csdao.getTotalCount();
		System.out.println("총 검색 수:"+totalCount);
		
		int pageSize = 5;// 한 페이지당 보여줄 게시글 수
		int pageCount = (totalCount-1 ) / pageSize+1;

		if (page < 1) {
			page = 1;// 첫페이지
		}
		if (page > pageCount) {
			page = pageCount;// 마지막 페이지
		}

		int end = page * pageSize;
		int start = end - (pageSize-1);

		
		// 게시목록 가져오기
		Map<String, String> list = new HashMap<>();

		list.put("start", String.valueOf(start));
		list.put("end", String.valueOf(end));
		
		List<CsVO> csList = csdao.pageCs(list);

		
		int pagingBlock=5;//페이지를 10개 단위로 블럭 처리
		
		int prevBlock=0; 
		int nextBlock=0; 
				 	  
		
		prevBlock=(page-1)/pagingBlock * pagingBlock;
		nextBlock=prevBlock + (pagingBlock+1);
		


		req.setAttribute("pageCount", pageCount);
		req.setAttribute("page", page);
		req.setAttribute("totalCount", totalCount);
		req.setAttribute("csList", csList);
		req.setAttribute("pagingBlock", pagingBlock); 
		req.setAttribute("prevBlock", prevBlock);
		req.setAttribute("nextBlock", nextBlock);
		
		
		this.setViewPage("customerService/cs.jsp");//뷰페이지 지정
		this.setRedirect(false);//이동방식은 forward이동으로 설정
		
		
	}
}
