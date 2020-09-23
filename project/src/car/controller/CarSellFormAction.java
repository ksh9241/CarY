package car.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.controller.AbstractAction;

public class CarSellFormAction extends AbstractAction {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		this.setViewPage("/car/carsell1.jsp");
		this.setRedirect(false);

	}

}
