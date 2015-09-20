package pl.regzand.haxballcontest;

import pl.regzand.contestserver.Client;

public class User {
	
	private final String name;
	private final Client client;
	protected Game game;

	public User(String name, Client client) {
		this.name = name;
		this.client = client;
	}

	public String getName() {
		return name;
	}

	public Client getClient() {
		return client;
	}
	
	public Game getGame(){
		return game;
	}
	
	public boolean isInGame(){
		return game!=null && game.isActive();
	}
	
	public void send(String msg){
		client.send(msg);
	}
}
