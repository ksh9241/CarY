package car.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;
import common.domain.CarInfoVO;
import common.domain.OptionVO;
import common.domain.UserVO;
import project.persistence.CarDAOMyBatis;
import project.persistence.UserDAOMyBatis;

public class DetailAction extends AbstractAction {
   
   CarDAOMyBatis dao=new CarDAOMyBatis();
   UserDAOMyBatis udao=new UserDAOMyBatis();
   @Override
   public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
      
      String idx=req.getParameter("idx");
      CarInfoVO vo=dao.selectCarDetail(Integer.parseInt(idx.trim()));
      List<OptionVO> option=dao.selectOption(idx);
      int useridx=vo.getMember_idx();
      UserVO user=udao.sellUser(useridx); 
      
      
      req.setAttribute("option", option);
      req.setAttribute("DetailList", vo);
      req.setAttribute("user", user);
      this.setViewPage("car/cardetail2.jsp");
      this.setRedirect(false);

   }

}