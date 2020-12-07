package views;

import utils.Console;

public class ResumeView {

    public ResumeView(){
        
    }
	public boolean interact() {
        return new Console().read(Message.RESUME.getMessage()).equals("y");
	}

}
