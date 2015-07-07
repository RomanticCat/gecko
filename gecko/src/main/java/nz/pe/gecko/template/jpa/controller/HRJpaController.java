package nz.pe.gecko.template.jpa.controller;


import java.util.Locale;

import nz.pe.gecko.template.hr.EmpVO;
import nz.pe.gecko.template.jpa.model.DeptJpa;
import nz.pe.gecko.template.jpa.model.EmpJpa;
import nz.pe.gecko.template.jpa.service.HRJpaServiceJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("HRControllerJPA")
public class HRJpaController {
	private static final Logger logger = LoggerFactory
			.getLogger(HRJpaController.class);	
	
	
	@Autowired
	private HRJpaServiceJpa hrSvcJpa;
	
	@RequestMapping(value = "/HRJpa.do", method = RequestMethod.GET)
	public String HRJpa(Locale locale, Model model) {
		logger.info("HRControllerJPA > HRJpa :", locale);

		/*List<MemberVO> memberList = memberSvc.getMemberList();
		model.addAttribute("result", memberList);*/
		return "HRJpa";
	}
	
	@ResponseBody
	@RequestMapping(value = "/getEmpListJSONJpa.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getEmpListJSONJpa(Locale locale, Model model) {
		logger.info("HRControllerJPA > getEmpListJSONJpa :");
		return hrSvcJpa.getEmpListJSONJpa();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getEmpByEmpNoJSONJpa.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getEmpByEmpNoJSONJpa(Locale locale, Model model, Long empno) {
		logger.info("HRController > getEmpByEmpNoJSONJpa :", locale);
		return hrSvcJpa.getEmpByEmpNoJSONJpa(empno);
	}	
	
	
	@ResponseBody
	@RequestMapping(value = "/getDeptListJSONJpa.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getDeptListJSONJpa(Locale locale, Model model) {
		logger.info("HRControllerJPA > getDeptListJSONJpa :");
		return hrSvcJpa.getDeptListJSONJpa();
	}	
	
	/*@ResponseBody
	@RequestMapping(value = "/updateEmployeeJpa.do", method = RequestMethod.POST)
	public String updateEmployeeJpa(@RequestBody EmpJpa emp){
		logger.info("HRControllerJPA > updateEmployeeJpa ");
		logger.info("     HRControllerJPA > updateEmployeeJpa ] empno:"+emp.getEmpno() +"   ename:"+emp.getEname() +"    hiredate:"+emp.getHiredate().toString() + "   DeptNo:"+emp.getDeptno());
		hrSvcJpa.updateEmp(emp);
		return hrSvcJpa.getEmpListJSONJpa();
	}*/
	
	@ResponseBody
	@RequestMapping(value = "/saveEmployeeJpa.do", method = RequestMethod.POST)
	public String insertEmployeeJpa(@RequestBody EmpJpa emp){
		logger.info("HRControllerJPA > saveEmployeeJpa ");
		logger.info("     HRControllerJPA > saveEmployeeJpa ] empno:"+emp.getEmpno() +"   ename:"+emp.getEname() +"    hiredate:"+emp.getHiredate().toString() + "   DeptNo:"+emp.getDeptno());
		hrSvcJpa.save(emp);
		return hrSvcJpa.getEmpListJSONJpa();
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/deleteEmployeeJpa.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String deleteEmployeeJpa(Long empno){
		logger.info("HRControllerJPA > deleteEmployeeJpa ");
		logger.info("       HRControllerJPA > deleteEmployeeJpa ] empno:"+empno);
		hrSvcJpa.deleteEmp(empno);
		
		return  hrSvcJpa.getEmpListJSONJpa();
	}
	
	
	
	
	
	
	
	@ResponseBody
	@RequestMapping(value = "/getEmpListJPA.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getEmpList(Locale locale, Model model) {
		logger.info("HRController > getEmpList :", locale);
		return hrSvcJpa.findAllEmpJSON();
	}
	
	@ResponseBody
	@RequestMapping(value = "/getEmpListWithDeptJPA.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getEmpListWithDept(Locale locale, Model model) {
		logger.info("HRController > getEmpListWithDept :", locale);
		return hrSvcJpa.getEmpListWithDept();
	}

	
	
	@ResponseBody
	@RequestMapping(value = "/getDeptListJPA.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getDeptList(Locale locale, Model model) {
		logger.info("HRController > getDeptList :", locale);
		return hrSvcJpa.findAllDeptJSON();
	}
	
	@ResponseBody
	@RequestMapping(value = "/updateDeptJPA.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String updateDept(Locale locale, Model model) {
		logger.info("HRController > updateDept :", locale);

		DeptJpa dept = hrSvcJpa.getDeptByDeptno(1L);
		dept.setLoc("Ulsan");
		return hrSvcJpa.updateDept(dept);
	}
	
	@ResponseBody
	@RequestMapping(value="addSampleDataJPA.do", method = RequestMethod.GET)
	public String addSampleData(){
		DeptJpa dept1 = new DeptJpa();
		dept1.setDname("Sales");;
		dept1.setLoc("Seoul");
		hrSvcJpa.addDept(dept1);
		
		DeptJpa dept2 = new DeptJpa();
		dept2.setDname("HR");;
		dept2.setLoc("Jeju");
		hrSvcJpa.addDept(dept2);
		
		
		for (int ins=0; ins < 30 ; ins++){
			EmpJpa emp = new EmpJpa();
			emp.setEname("Kim "+ins);
			if(ins%2 != 0){
				emp.setJob("Sales");
				emp.setDeptno(dept1.getDeptno());
				emp.setComm(2000L);
				emp.setMgr(2020L);
			}  else {
				emp.setJob("Engineer");
				emp.setDeptno(dept2.getDeptno());
				emp.setComm(3000L);
				emp.setMgr(3030L);
			}
			hrSvcJpa.addEmp(emp);
			
		}
		
		return "done";
	}
	

}
