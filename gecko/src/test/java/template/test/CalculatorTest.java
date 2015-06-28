package template.test;

import nz.pe.gecko.template.test.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;


import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CalculatorTest {
	@Mock
	private Calculator calc ;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
		
		//calc = new Calculator();
	}
	
	
	@Test
	public void testAbs(){

		when(calc.abs(-20)).thenReturn(20);
		assertEquals(20, calc.abs(-20));
		
		
		//assertEquals(4, calc.abs(-4));
		
		/*
		//JUnit #1
		//assertEquals(2,1);
		assertEquals(1,1);
		
		//JUnit #2
		Calculator calc = new Calculator();
		int expected = 4;
		int actual = calc.abs(-4);
		assertEquals(expected, actual);
		*/
		
	}

}
