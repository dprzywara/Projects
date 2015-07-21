import java.util.LinkedList;

public class Round {

	private LinkedList<Integer> listOfRolls = new LinkedList<Integer>();
	private Round nextRound = null;

	public Round getNextRound() {
		return nextRound;
	}

	public void setNextRound(Round nextRound) {
		this.nextRound = nextRound;
	}

	public LinkedList<Integer> getListOfRolls() {
		return listOfRolls;
	}

//	public Round(int firstRoll) {
//		listOfRolls.add(firstRoll);
//	}

	public Integer getRoll(int index) {
		return listOfRolls.get(index);
	}

	public void addRoll(int roll) {
		listOfRolls.add(roll);
	}

	public int sumOfRound() {
		int sum = 0;
		for (Integer integer : listOfRolls) {
			sum += integer;
		}
		return sum;
	}

	public int sumOfTwoRolls() {
		int sum = listOfRolls.get(0);
		if (listOfRolls.size() >= 2) {
			sum += listOfRolls.get(1);
		}

		return sum;
	}

	public boolean isStrike() {

		return listOfRolls.get(0) == 10;
	}

	public boolean isSpare() {
		return listOfRolls.get(0) != 10 && sumOfRound() == 10;
	}

	public int getScore() {
		int sumOfRound = sumOfRound();
		if (isStrike() && hasNext()) {
			sumOfRound += nextRound.sumOfTwoRolls();
			if (nextRound.isStrike() && nextRound.hasNext()) {
				sumOfRound += nextRound.getNextRound().getRoll(0);
			}
		}

		if (isSpare() && hasNext()) {
			sumOfRound += nextRound.getRoll(0);
		}
		return sumOfRound;

	
	}

	private boolean hasNext() {
		return nextRound != null;
	}
	
	public boolean isEndOfRound(){
		return (isStrike() || listOfRolls.size() == 2) ;
			 
					
	}

}
