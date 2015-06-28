package template.test;

import java.util.*;

import javax.net.ssl.SSLEngineResult.Status;

import nz.pe.gecko.template.hr.EmpVO;
import nz.pe.gecko.template.hr.HRController;
import nz.pe.gecko.template.hr.HRService;
import nz.pe.gecko.template.test.BlogEntryController;
import nz.pe.gecko.template.test.BlogEntryService;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.StatusResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration({"file:src/main/java/config/spring/spring-config.xml"})
public class HRTest {
	
	@InjectMocks
	private HRController controller;
	
	@Mock
	private HRService hrService;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void getHRListJSONTest() throws Exception{
		ArrayList arrList  = new ArrayList();
		EmpVO emp1 = new EmpVO();
			emp1.setEmpno(7369);
			emp1.setEname("SMITH");
			emp1.setHiredate(new java.util.Date());
			emp1.setJob("CLERK");
			emp1.setMgr(7902);
			emp1.setSal(800);
			emp1.setComm(0);
			emp1.setDeptno(20);

			EmpVO emp2 = new EmpVO();
			emp2.setEmpno(7499);
			emp2.setEname("ALLEN");
			emp2.setHiredate(new java.util.Date());
			emp2.setJob("SALESMAN");
			emp2.setMgr(7698);
			emp2.setSal(1600);
			emp2.setComm(300);
			emp2.setDeptno(30);			
			
		arrList.add(emp1);
		arrList.add(emp2);
		
		Gson gson = new GsonBuilder()
			.setDateFormat("dd/MM/yyyy")
			.create();	
		String empString1 = gson.toJson(arrList);
			
		when(hrService.getEmployeeListJSON()).thenReturn(empString1);
		mockMvc.perform(get("/getHRListJSON.do"))
				.andExpect(status().isOk())
				.andExpect(content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].ename", is("SMITH")))
				.andExpect(jsonPath("$[1].deptno", is(30)))
				.andDo(print())
				
				;

		
	}
	
	/*@Test
	public void getEmployeeDetailTest() throws Exception{
		mockMvc.perform(get("/getEmpDetailJSON.do").param("empno", "7521"))
				.andDo(print());
	}*/
	
	

	
	
}
