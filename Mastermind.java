import views.MastermindView;

class Mastermind {

	public Mastermind(){

	}

	public void play(){
		new MastermindView().interact();
	}

	
	public static void main(String[] args) {
		new Mastermind().play();
	}

}