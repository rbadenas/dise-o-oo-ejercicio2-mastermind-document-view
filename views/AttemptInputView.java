package views;

import java.util.HashSet;
import java.util.Set;

import models.*;
import utils.Console;

public class AttemptInputView {

    public AttemptInputView() {

    }
    
    public Attempt interact(SecretCombination secretCombination)
    {
        String proposedString;
		do {
			proposedString = new Console().read(Message.COMBINATION_ENTER.getMessage());
        }while(!this.isValid(proposedString));
        
        return new Attempt(new ProposedCombination(proposedString), secretCombination);
    }

    private boolean isValid(String proposedString){
        Console console = new Console();

        if(proposedString.length() != Combination.LENGTH) {
            console.write(Message.COMBINATION_WRONG_LENGTH.getMessage());
            return false;
        }

        if (!this.isValidColor(proposedString)) {
            console.write(Message.COMBINATION_WRONG_COLOR.getMessage() + Color.getAvailableColors() + "\n");
            return false;
        }

        if (this.isRepeatedColor(proposedString)) {
            console.write(Message.COMBINATION_WRONG_DUPLICATE_COLOR.getMessage());
            return false;
        }
        return true;
    }

    private boolean isValidColor(String proposedString) {

        String[] proposedArray = proposedString.split("");
        for (String item : proposedArray) {
            if(!Color.getAvailableColors().contains(item)){
                return false;
            }
        }
		return true;
    }

    private boolean isRepeatedColor(String proposedString) {

        Set<Character> chars = new HashSet<Character>();
        for (char c : proposedString.toCharArray()) {
            if (!chars.add(c)) return true;
        }
        return false;
    }

}
