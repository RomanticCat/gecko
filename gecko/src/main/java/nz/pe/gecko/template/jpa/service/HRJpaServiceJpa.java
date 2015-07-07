package nz.pe.gecko.template.jpa.service;


import java.util.List;

import javax.transaction.TransactionManager;

import nz.pe.gecko.template.hr.EmpVO;
import nz.pe.gecko.template.jpa.model.DeptJpa;
import nz.pe.gecko.template.jpa.model.EmpJpa;
import nz.pe.gecko.template.jpa.repository.HRDeptRepository;
import nz.pe.gecko.template.jpa.repository.HREmpRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Service("HRServiceJpa")
public class HRJpaServiceJpa {
	
/*	@Autowired
	@Qualifier("txManagerJPA")
	private TransactionManager txManagerJPA;
*/	
	@Autowired
	private HREmpRepository hrEmpRepo;
	
	@Autowired
	private HRDeptRepository hrDeptRepo;
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public List<EmpJpa> findAllEmp(){
		return hrEmpRepo.findAll();
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String findAllEmpJSON(){
		Gson gson = new GsonBuilder()
			.setDateFormat("dd/MM/yyyy")
			.create();
		
		return gson.toJson(hrEmpRepo.findAll());
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String findAllDeptJSON(){
		Gson gson = new GsonBuilder()
		.setDateFormat("dd/MM/yyyy")
		.create();
		return gson.toJson(hrDeptRepo.findAll());
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String getEmpListWithDept(){
		Gson gson = new GsonBuilder()
		.setDateFormat("dd/MM/yyyy")
		.create();
		return gson.toJson(hrEmpRepo.findEmpListWithDept());
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String getEmpByEmpNoJSONJpa(Long empno){
		Gson gson = new GsonBuilder()
		.setDateFormat("dd/MM/yyyy")
		.create();
		return gson.toJson(hrEmpRepo.getEmpByEmpNoJSONJpa(empno));
	}
	
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public void addEmp(EmpJpa emp){
		//hrEmpRepo.saveAndFlush(emp);
		hrEmpRepo.save(emp);
		hrEmpRepo.flush();
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public void addDept(DeptJpa dept){
		//hrDeptRepo.saveAndFlush(dept);
		hrDeptRepo.save(dept);
		hrDeptRepo.flush();
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String updateDept(DeptJpa dept){
		hrDeptRepo.saveAndFlush(dept);
		
		Gson gson = new GsonBuilder()
			.setDateFormat("dd/MM/yyyy")
			.create();
		
		return gson.toJson(getDeptByDeptno(dept.getDeptno()));
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public DeptJpa getDeptByDeptno(Long deptno){
		DeptJpa dept = hrDeptRepo.findOne(deptno);
		return dept;
	}

	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String getEmpListJSONJpa() {
		
		Gson gson = new GsonBuilder()
		.setDateFormat("dd/MM/yyyy")
		.create();
		
		
		return gson.toJson(hrEmpRepo.findEmpListWithDept());
	}

	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String getDeptListJSONJpa() {
		Gson gson = new GsonBuilder().setDateFormat("dd/MM/yyyy").create();

		return gson.toJson(hrDeptRepo.findAll());
	}

	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public void save(EmpJpa emp) {
		hrEmpRepo.saveAndFlush(emp);
		
	}

	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public void deleteEmp(Long empno) {
		hrEmpRepo.delete(empno);
		
	}
	
	
	

}