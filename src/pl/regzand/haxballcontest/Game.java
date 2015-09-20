package pl.regzand.haxballcontest;

public class Game {
	
	private final User[] users;
	private boolean active;
	
	public Game(User u1, User u2){
		this.users = new User[]{u1,u2};
		u1.game = this;
		u2.game = this;
		
		this.active = true;
	}

	public boolean isActive() {
		return active;
	}
	
}
