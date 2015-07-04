package nz.pe.gecko.template.jpa.controller;


import java.util.Locale;

import nz.pe.gecko.template.jpa.model.Dept;
import nz.pe.gecko.template.jpa.model.Emp;
import nz.pe.gecko.template.jpa.service.HRServiceJpa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller("HRControllerJPA")
public class HRController {
	private static final Logger logger = LoggerFactory
			.getLogger(HRController.class);	
	
	
	@Autowired
	private HRServiceJpa hrSvcJpa;
	
	
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
	@RequestMapping(value = "/getEmpListWithDeptAndEnameJPA.do", method = RequestMethod.GET, produces={"application/json;charset=UTF-8"})
	public String getEmpListWithDeptAndEname(Locale locale, Model model, String ename) {
		logger.info("HRController > getEmpListWithDeptAndEname :", locale);
		return hrSvcJpa.getEmpListWithDept(ename);
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

		Dept dept = hrSvcJpa.getDeptByDeptno(1L);
		dept.setLoc("Ulsan");
		return hrSvcJpa.updateDept(dept);
	}
	
	@ResponseBody
	@RequestMapping(value="addSampleDataJPA.do", method = RequestMethod.GET)
	public String addSampleData(){
		Dept dept1 = new Dept();
		dept1.setDname("Sales");;
		dept1.setLoc("Seoul");
		hrSvcJpa.addDept(dept1);
		
		Dept dept2 = new Dept();
		dept2.setDname("HR");;
		dept2.setLoc("Jeju");
		hrSvcJpa.addDept(dept2);
		
		
		for (int ins=0; ins < 30 ; ins++){
			Emp emp = new Emp();
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
