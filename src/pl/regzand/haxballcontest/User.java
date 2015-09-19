package pl.regzand.haxballcontest;

import pl.regzand.contestserver.Client;

public class User {
	
	private final String name;
	private final Client client;

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
	
	public void send(String msg){
		client.send(msg);
	}
}
