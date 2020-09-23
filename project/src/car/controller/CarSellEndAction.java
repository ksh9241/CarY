package car.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import common.base.CommonUtil;
import common.controller.AbstractAction;
import common.domain.CarInfoVO;
import common.domain.CategoryVO;
import common.domain.UserVO;
import project.persistence.CarDAOMyBatis;

public class CarSellEndAction extends AbstractAction {
	
	CarDAOMyBatis cdao = new CarDAOMyBatis();
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		
		// 1. 업로드할 디렉토리 절대경로 얻어오기.
		ServletContext app = req.getServletContext();
		String upDir = app.getRealPath("/images");
		System.out.println("업로드 디렉토리 주소: "+upDir);
		
		// 2. 이미지 파일들 업로드 처리. -> cos.jar // images 에 업로드
		MultipartRequest mr = new MultipartRequest(req, upDir, 10*1024*1024, "UTF-8", new DefaultFileRenamePolicy());

		// 3. 사용자가 입력한 값 받기.
		
		// 로그인한 회원 번호 받아와서 넘기기
		HttpSession session = req.getSession();
		UserVO user = (UserVO)session.getAttribute("loginUser");
		
		int member_idx = user.getMember_idx();
		
		/* System.out.println("회원번호="+member_idx); */
		
		//탭[1]
		String carNum = mr.getParameter("carNum");
		String carKind = mr.getParameter("carKind");
		String dmodel = mr.getParameter("dmodel"); 
		String fuel = mr.getParameter("fuel");
		String age = mr.getParameter("date");
		String cc = mr.getParameter("cc");
		String seater = mr.getParameter("seater"); 
		String gear = mr.getParameter("gear");		
		String color = mr.getParameter("color");
		String km = mr.getParameter("km");
		
		// 탭[2] : 옵션 정보 배열로 받기 
		String[] opt1 = mr.getParameterValues("opt1");

		// 탭[3]
		String carPrice = mr.getParameter("carPrice");
		String carTest_Img = mr.getFilesystemName("carTest_Img"); // null
		String carIntro = mr.getParameter("introd"); // null
		
		// 탭[4]
		String car_Img1 = mr.getFilesystemName("car_Img1"); // null
		String car_Img2 = mr.getFilesystemName("car_Img2"); // null
		String car_Img3 = mr.getFilesystemName("car_Img3"); // null
		
		// 유효성 체크
		if (carNum == null || carKind == null || dmodel == null || fuel == null || age == null
		     || cc == null || seater == null || gear == null || color == null || km == null
		     || carPrice == null || carNum.trim().isEmpty() || carKind.trim().isEmpty() ||
		     dmodel.trim().isEmpty() || fuel.trim().isEmpty() ||  age.trim().isEmpty() || 
		     cc.trim().isEmpty() ||  seater.trim().isEmpty() ||  gear.trim().isEmpty() ||
		     color.trim().isEmpty() || km.trim().isEmpty() ||  carPrice.trim().isEmpty() || 
		     carNum.trim().isEmpty() || carKind.trim().isEmpty()) {
			
			this.setViewPage(CommonUtil.addMsgback(req, "입력을 다시 확인해 주세요."));
			this.setRedirect(false);
			return;
		}
		
		// db number 값 int화
		int cc_int = Integer.parseInt(cc);
		int km_int = Integer.parseInt(km);
		int carPrice_int = Integer.parseInt(carPrice);
		
		// 세부모델(dmodel)로 세부정보를 찾는 메소드
		CategoryVO dcode = cdao.searchByDemodel(dmodel);
		
		CarInfoVO item = new CarInfoVO(0, carNum, carKind, dcode.getB_code(), dcode.getM_code(), dcode.getS_code(), fuel, age, cc_int,
				seater, gear, color, km_int, carPrice_int, carTest_Img, carIntro, member_idx, car_Img1, car_Img2, car_Img3, null, 0);
		
		// 매물 등록을 처리하는 메소드
		int n = cdao.carInsert(item);
		String msg =(n>0)? "매물이 등록 되었습니다." : "매물 등록에 실패 했습니다.";
		String loc ="../index.do";

		// 해쉬맵을 이용하여 옵션정보를 저장하는 메소드
		Map<String, Integer> p = new HashMap<>();
		for(String opt : opt1){
			p.put("idx", item.getIdx());
			p.put("opt", Integer.parseInt(opt.trim()));
			int inopt = cdao.insertOptInfo(p);
		}
		
		this.setViewPage(CommonUtil.addMsgLoc(req, msg, loc));
		this.setRedirect(false);

	}

}
