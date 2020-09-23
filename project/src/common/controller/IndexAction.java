package common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexAction extends AbstractAction {
	
	public void execute(HttpServletRequest req, HttpServletResponse res)
	throws Exception {
		
		this.setViewPage("index1.jsp");
		this.setRedirect(false);
	}

}
