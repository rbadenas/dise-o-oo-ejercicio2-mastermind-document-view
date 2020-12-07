package views;

import java.util.ArrayList;

import models.Attempt;
import models.SecretCombination;
import utils.Console;

public class MastermindView {
    
    private ArrayList<Attempt> attempts = new ArrayList<Attempt>();
	private SecretCombination secretCombination;
	private final int NUM_ATTEMPS = 10;


	public MastermindView() {
        secretCombination = new SecretCombination();
	}
	
	public void interact() {
		new Console().write(Message.START_TITLE.getMessage());

		do {
			newAttempt();
		} while (new ResumeView().interact());
    }

	private void newAttempt() {
		Console console = new Console();

		do {
			console.write(this.attempts.size() + Message.ATTEMPT_CAPTION.getMessage());
			console.write(this.secretCombination.toString());	

			var attempt = new AttemptInputView().interact(secretCombination);
			attempts.add(attempt);
			displayAllAttempts();
		} while (!isGameOver() && !currentAttempt().isWinner());

		console.write(getGameResult());

	}

	private void displayAllAttempts() {
		Console console = new Console();
		for (int i = 0; i < attempts.size(); i++) {
			console.write(attempts.get(i).toString());
		}
	}

	private String getGameResult() {
		if (currentAttempt().isWinner()) {
			return Message.WINNER.getMessage();
		} else {
			return Message.LOOSER.getMessage();
		}
	}

	private boolean isGameOver() {
		return attempts.size() >= NUM_ATTEMPS;
	}

	private Attempt currentAttempt() {
		return attempts.get(attempts.size() - 1);
	}

}