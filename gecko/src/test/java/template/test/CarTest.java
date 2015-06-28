package template.test;

import nz.pe.gecko.template.test.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CarTest {
	@Mock
	private Engine engine;

	@InjectMocks
	private Car car;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testWarning() {
		when(engine.getRpm()).thenReturn(6000);

		car.accelerate();
		assertEquals("slow down!", car.getWarningMessage());

	}

}
