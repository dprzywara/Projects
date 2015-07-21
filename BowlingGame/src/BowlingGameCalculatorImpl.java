import java.util.LinkedList;

public class BowlingGameCalculatorImpl implements BowlingGameCalculator {
	private LinkedList<Round> rounds = new LinkedList<Round>();
	static final int NUMBER_OF_ROUNDS = 10;
	static final int MAX_NUMBER_OF_POINTS = 10;

	@Override
	public void roll(int numberOfPins) {
		if (!isFinished()) {
			if (isLastRound() && isBonusRollAllowed()) {
				rounds.getLast().addRoll(numberOfPins);
				return;
			}

			if (rounds.isEmpty() || rounds.getLast().isEndOfRound()) {
				createNewRound();
			}
			rounds.getLast().addRoll(numberOfPins);
		}
	}

	private void createNewRound() {
		Round round = new Round();
		if (!rounds.isEmpty()) {
			rounds.getLast().setNextRound(round);
		}
		rounds.add(round);
	}

	@Override
	public boolean isFinished() {
		return isLastRound() && rounds.getLast().isEndOfRound() && !isBonusRollAllowed();
	}


	private boolean isLastRound() {
		return rounds.size() == NUMBER_OF_ROUNDS;
	}

	private boolean isBonusRollAllowed() {
		return rounds.getLast().sumOfRound() >= MAX_NUMBER_OF_POINTS
				&& rounds.getLast().getListOfRolls().size() < 3;
	}

	@Override
	public int score() {
		int sum = 0;
		for (Round round : rounds) {
			sum += round.getScore();
		}
		return sum;
	}

	public void displayList() {
		for (Round roll : rounds) {
			for (Integer r : roll.getListOfRolls()) {
				System.out.print(r + " ");
			}
			System.out.println(roll.sumOfRound());
		}
	}

}
