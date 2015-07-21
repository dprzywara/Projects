import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BowlingGameCalculatorTest {
	private BowlingGameCalculatorImpl calc;

	@Before
	public void before() {
		calc = new BowlingGameCalculatorImpl();
	}

	@Test
	public void shouldReturnZeroForNoRoll() {
		int score = calc.score();
		Assert.assertEquals(0, score);
	}

	@Test
	public void shouldReturnSixForRollSix() {
		calc.roll(6);
		int score = calc.score();
		Assert.assertEquals(6, score);
	}

	@Test
	public void shouldReturn14ForRoll5_5_2() {
		List<Integer> dane = Arrays.asList(5,5,2);
		doRolls(dane);
		int score = calc.score();
		Assert.assertEquals(14, score);
	}

	@Test
	public void shouldReturn60for10_10_10() {
		List<Integer> dane = Arrays.asList(10, 10, 10, 10);
		doRolls(dane);
		int score = calc.score();
		Assert.assertEquals(90, score);
	}

	@Test
	public void shouldReturn300for12x10() {
		List<Integer> dane = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10);
		doRolls(dane);

		calc.displayList();
		int score = calc.score();
		Assert.assertEquals(300, score);
	}

	private void doRolls(List<Integer> dane) {
		for (Integer integer : dane) {
			calc.roll(integer);

		}
	}

	@Test
	public void shouldReturn136forExample() {
		List<Integer> dane = Arrays.asList(6, 2, 5, 4, 5, 5, 6, 2, 10, 7, 2, 6,
				4, 10, 7, 2, 10, 6, 3);
		doRolls(dane);
		
		calc.displayList();
		int score = calc.score();
		Assert.assertEquals(136, score);
	}

	@Test
	public void shouldReturn187forExample() {

		List<Integer> dane = Arrays.asList(10, 9, 1, 5, 5, 7, 2, 10, 10, 10, 9,
				0, 8, 2, 9, 1, 10);
		doRolls(dane);
		calc.displayList();
		int score = calc.score();
		Assert.assertEquals(187, score);
	}

	@Test
	public void shouldReturn270for9x10() {
		List<Integer> dane = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10,
				0, 10, 10);
		doRolls(dane);
		calc.displayList();
		int score = calc.score();
		Assert.assertEquals(270, score);
	}

	@Test
	public void shouldReturn300for14x10() {
		List<Integer> dane = Arrays.asList(10, 10, 10, 10, 10, 10, 10, 10, 10,
				10, 10, 10, 10, 10);
		doRolls(dane);

		calc.displayList();
		int score = calc.score();
		Assert.assertEquals(300, score);
	}

}
