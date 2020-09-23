package user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.controller.AbstractAction;
import common.domain.PostVO;
import project.persistence.PostDAOMyBatis;

public class FindZipCodeAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		HttpSession session = req.getSession();
		
		String roadName = "";
		String tempName = req.getParameter("roadName");
		if(tempName != null) {
			roadName = tempName.replaceAll(" ", "").replaceAll("-", "");
		}
		
		/* roadName = "%"+roadName+"%"; */
		System.out.println("action의 로드네임= "+roadName);
		
		String cpStr = req.getParameter("cpage");		
		if (cpStr == null || cpStr.trim().isEmpty()) {
			if(cpStr == null) {
				cpStr = "1";
			}
		}
		
		String psStr = req.getParameter("pageSize");
		if(psStr == null || psStr.trim().isEmpty()) {
			psStr = (String)session.getAttribute("pageSize");
			if(psStr == null) {
				psStr="20";
			}
		}
		
		int cpage = Integer.parseInt(cpStr);
		
		////////////////////////페이징 처리 /////////////////////////////////

		session.setAttribute("cpage", cpage);
		session.setAttribute("pageSize", psStr);
	
		PostDAOMyBatis postDao = new PostDAOMyBatis();

		int totalPostResult = postDao.getTotalPost(roadName); // 총 검색 글 수	
		int pageSize = Integer.parseInt(psStr.trim()); // 한 페이지당 보여줄 검색 수
		int pageCount = (totalPostResult-1)/pageSize+1; // 총 페이지 수
				
		if(cpage < 1) {
			cpage = 1; // 첫 페이지로 지정
		}
		if(cpage > pageCount) {
			cpage = pageCount; // 마지막 페이지로 지정
		}
		
		// start, end 값 구하는 식
		int end = cpage * pageSize;
		int start = end - (pageSize-1);
				
		// 이전, 이후 처리
		int pagingBlock = 5; // 페이지를 5개 단위로 블럭 처리.
		int prevBlock = 0, nextBlock = 0;
		
		prevBlock = (cpage-1)/pagingBlock * pagingBlock;
		nextBlock = prevBlock + (pagingBlock+1);
		
		// 맵퍼로 넘겨주기 위한 해쉬맵
		Map<String, String> paging = new HashMap<>();
		paging.put("roadName", roadName);
		paging.put("start", String.valueOf(start));
		paging.put("end", String.valueOf(end));
		System.out.println(paging);
		List<PostVO> postList = postDao.ListPostByRoadName(paging);
		/*
		 * System.out.println("postList= "+postList.get(0).getDoro_Kor());
		 */		
		//////////////////////// 검색 결과 처리 ////////////////////////
		
		String addr1, addr2;
		String addr= "";
		String postCode = "";
		List<String> addrList = new ArrayList<>();
		List<String> postCodeList = new ArrayList<>();
		
		// 보여주는 형식 설정
		if (postList.isEmpty()) {
			addrList = null;
		} else {	
			for(int i=0; i<postList.size(); i++){
				addr1 = postList.get(i).getSido_Kor() + " " + postList.get(i).getSigungu_Kor() + " "
						+ postList.get(i).getDoro_Kor() + " " + postList.get(i).getBld_Origin_Num();
				addr2 = (postList.get(i).getBld_Reefr_Num() != 0) ? addr1 + "-" + postList.get(i).getBld_Reefr_Num() : addr1;
				addr = (postList.get(i).getSigungu_Bld_Name() == null) ? addr2 : addr2 + "(" + postList.get(i).getSigungu_Bld_Name() + ")";
				addrList.add(addr);
				
				postCode = postList.get(i).getNew_Post_Code();
				postCodeList.add(postCode);
	
			}
		}
		
		
		/* System.out.println("addrList="+addrList.get(0)); */

		req.setAttribute("addrList", addrList);
		req.setAttribute("postCode", postCodeList);
		req.setAttribute("roadName", roadName);
		
		req.setAttribute("pageCount", pageCount);
		req.setAttribute("cpage", cpage);
		req.setAttribute("totalPostResult", totalPostResult);
		
		req.setAttribute("pagingBlock", pagingBlock);
		req.setAttribute("prevBlock", prevBlock);
		req.setAttribute("nextBlock", nextBlock);
		
		this.setViewPage("member/postCheckResult.jsp");
		this.setRedirect(false);
	}
}
