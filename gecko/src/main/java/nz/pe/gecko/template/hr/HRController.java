package nz.pe.gecko.template.hr;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

import nz.pe.gecko.template.mybatis.MemberVO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HRController {
	
	@Autowired
	private HRService HRSvc;
	
	
	
	private static final Logger logger = LoggerFactory
			.getLogger(HRController.class);	
	
	@RequestMapping(value = "/HR.do", method = RequestMethod.GET)
	public String main(Locale locale, Model model) {
		logger.info("HRController > main :", locale);

		/*List<MemberVO> memberList = memberSvc.getMemberList();
		model.addAttribute("result", memberList);*/
		return "HR";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getHRListJSON.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getHRListJSON(Locale locale, Model model) {
		logger.info("HRController > getHRListJSON :");
		return HRSvc.getEmployeeListJSON();
	}

	
	@RequestMapping(value = "/getEmployeeCount.do")
	@ResponseBody
	public int getEmployeeCount() {
	/* public int getEmployeeCount(@RequestParam(value = "currCnt", required = false) int currCnt) {
		//  @RequestParam annotation could be ommited (default value for 'required' is true) 
		logger.info("HRController > getEmployeeCount ] currCnt : " + currCnt); */
		logger.info("HRController > getEmployeeCount ");
		return HRSvc.getEmployeeCount();
	}	
	
	@ResponseBody
	@RequestMapping(value = "/insertEmployee.do", method = RequestMethod.POST)
	public String insertEmployee(@RequestBody EmpVO emp){
		logger.info("HRController > insertEmployee ");
		
		
		logger.info("HRController > insertEmployee ] empno:"+emp.getEmpno() +"   ename:"+emp.getEname() +"    hiredate:"+emp.getHiredate().toString());
		HRSvc.insert(emp);
		
		return HRSvc.getEmployeeListJSON();
	}

	
	@ResponseBody
	@RequestMapping(value = "/getEmpDetailJSON.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getEmpDetailJSON(String empno) {
		logger.info("HRController > getEmpDetailJSON : [param - empno:"+empno+" ]");
		return HRSvc.getEmployeeDetail(empno);
	}	
	


}
