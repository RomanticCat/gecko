package nz.pe.gecko.template.jpa.service;


import java.util.List;

import javax.transaction.TransactionManager;

import nz.pe.gecko.template.jpa.model.Dept;
import nz.pe.gecko.template.jpa.model.Emp;
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
public class HRServiceJpa {
	
/*	@Autowired
	@Qualifier("txManagerJPA")
	private TransactionManager txManagerJPA;
*/	
	@Autowired
	private HREmpRepository hrEmpRepo;
	
	@Autowired
	private HRDeptRepository hrDeptRepo;
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public List<Emp> findAllEmp(){
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
	public String getEmpListWithDept(String ename){
		Gson gson = new GsonBuilder()
		.setDateFormat("dd/MM/yyyy")
		.create();
		return gson.toJson(hrEmpRepo.findEmpListWithDept(ename));
	}
	
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public void addEmp(Emp emp){
		//hrEmpRepo.saveAndFlush(emp);
		hrEmpRepo.save(emp);
		hrEmpRepo.flush();
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public void addDept(Dept dept){
		//hrDeptRepo.saveAndFlush(dept);
		hrDeptRepo.save(dept);
		hrDeptRepo.flush();
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public String updateDept(Dept dept){
		hrDeptRepo.saveAndFlush(dept);
		
		Gson gson = new GsonBuilder()
			.setDateFormat("dd/MM/yyyy")
			.create();
		
		return gson.toJson(getDeptByDeptno(dept.getDeptno()));
	}
	
	@Transactional(value="transactionManagerJPA", propagation = Propagation.REQUIRED)
	public Dept getDeptByDeptno(Long deptno){
		Dept dept = hrDeptRepo.findOne(deptno);
		return dept;
	}
	
	
	

}