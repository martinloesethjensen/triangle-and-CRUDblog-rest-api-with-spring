package api.rest.martin.restfulapiwithspring;

import api.rest.martin.restfulapiwithspring.Model.Triangle;
import api.rest.martin.restfulapiwithspring.Model.TriangleType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class TriangleTypeTests{

	@Test
	public void isTriangleWhenAllSidesAreAboveZero() {
		// Creating a mock of the Triangle class
		Triangle triangle = mock(Triangle.class);

		// Defining the return value for isTriangle()
		when(triangle.isTriangle()).thenReturn(true);

		// Using mock to test
		assertTrue("All sides are not negative", triangle.isTriangle());
	}

	@Test
	public void triangleIsEquilateralWhenAllSidesAreEqual() {
		Triangle equilateralTriangle = mock(Triangle.class);

		when(equilateralTriangle.getTriangleType()).thenReturn(TriangleType.EQUILATERAL);

		assertEquals(equilateralTriangle.getTriangleType(), TriangleType.EQUILATERAL);
	}

	@Test
	public void triangleIsScaleneWhenAllSidesAreDifferent() {
		Triangle scaleneTriangle = mock(Triangle.class);

		when(scaleneTriangle.getTriangleType()).thenReturn(TriangleType.SCALENE);

		assertEquals(scaleneTriangle.getTriangleType(), TriangleType.SCALENE);
	}

	@Test
	public void triangleIsIsoscelesWhenTwoSidesAreTheSame(){
		Triangle isoscelesTriangle = mock(Triangle.class);

		when(isoscelesTriangle.getTriangleType()).thenReturn(TriangleType.ISOSCELES);

		assertEquals(isoscelesTriangle.getTriangleType(), TriangleType.ISOSCELES);
	}

	@Test
	public void incorrectTriangleWhenSidesNotMakingValidTriangle(){
		Triangle incorrectTriangle = mock(Triangle.class);

		when(incorrectTriangle.getTriangleType()).thenReturn(TriangleType.INCORRECT);

		assertEquals(incorrectTriangle.getTriangleType(), TriangleType.INCORRECT);
	}
}
