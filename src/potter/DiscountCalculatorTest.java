package potter;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


class DiscountCalculatorTest {
	DiscountCalculator calculator = null;
	public static final double ERROR_DELTA = 0.001;
	
	@BeforeEach
	void createCalculator() {
		calculator = new DiscountCalculator();
	}
	
	@Test
	void emptyBasketShouldBeZero() {
		int[] shoppingCart = {};
				
		double result = calculator.calculate(shoppingCart);
		
		assertEquals(result, 0.0, ERROR_DELTA);
	}
	
	@Test
	void onlyOneBookShouldNotHaveAnyDiscounts() {
		int[] shoppingCart = { 0 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0, ERROR_DELTA);
	}
	
	@Test
	void twoBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 1 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0 * 2 * 0.95, ERROR_DELTA);
	}
	
	@Test
	void threeBooksShouldHaveADiscount() {
		int[] shoppingCart = { 0, 1, 2 };
		
		double result = calculator.calculate(shoppingCart);
				
		assertEquals(result, 8.0 * 3 * 0.9, ERROR_DELTA);
	}
}