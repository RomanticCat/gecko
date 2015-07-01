package nz.pe.gecko.template.orm.hr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HRJpaController {

	@Autowired
	HRJpaService svc;
	
	@ResponseBody
	@RequestMapping(value = "/addEmpJpa.do", method = RequestMethod.GET)
	public String addEmpJpa() {
		svc.addEmpJpa();

		
		
		return "done";
	}
	
}
