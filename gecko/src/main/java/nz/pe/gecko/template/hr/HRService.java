package nz.pe.gecko.template.hr;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service
public class HRService {
	private static final Logger logger = LoggerFactory
			.getLogger(HRService.class);
	
	@Autowired
	private HrDAOImpl daoImpl;	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public ArrayList<EmpVO> getEmployeeList(){
		return daoImpl.getEmployees();
	}
	@Transactional(propagation = Propagation.REQUIRED)
	public String getEmployeeListJSON(){
		 //Gson gson = new Gson();
		Gson gson = new GsonBuilder()
						.setDateFormat("dd/MM/yyyy")
						.create();
		 String rtnString = gson.toJson(daoImpl.getEmployees());
		 
		 return rtnString;
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void insert(EmpVO emp){
		logger.info("HRService > insertEmployee ]]] ");
		daoImpl.insertEmployee(emp);
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateEmployee(EmpVO emp){
		logger.info("HRService > updateEmployee ]]] ");
		daoImpl.updateEmployee(emp);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public int deleteEmployee(int empno){
		logger.info("HRService > deleteEmployee ]]] ");
		return daoImpl.deleteEmployee(empno);
	}	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public int getEmployeeCount(){
		return daoImpl.getEmployeeCount();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public String getEmployeeDetail(String empno){
		EmpVO emp = new EmpVO();
		if((empno != null) && (! empno.trim().equals(""))){
			int empnoInt = Integer.parseInt(empno);
			emp.setEmpno(empnoInt);
		} 
		
		Gson gson = new GsonBuilder()
			.setDateFormat("dd/MM/yyyy")
			.create();
		String rtnString = gson.toJson(daoImpl.getEmployeeDetail(emp));
		
		return rtnString;
	}
		
}
