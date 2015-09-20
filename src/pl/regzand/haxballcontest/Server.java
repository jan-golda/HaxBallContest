package pl.regzand.haxballcontest;

import java.util.HashMap;
import java.util.Map;

import pl.regzand.contestserver.Client;
import pl.regzand.contestserver.Command;
import pl.regzand.contestserver.CommandException;
import pl.regzand.contestserver.ContestServer;
import pl.regzand.haxballcontest.commands.JoinCommand;

public class Server extends ContestServer implements Command {
	
	private Map<Client, User> users = new HashMap<Client, User>();
	
	public Server(int port){
		super(port);
		
		registerCommands();
		registerErrors();
		
		super.start();
	}
	
	private void registerCommands(){
		cmdHandler.addCommand("LOGIN",		this);
		cmdHandler.addCommand("JOIN",		new JoinCommand(this));
	}
	
	private void registerErrors(){
		cmdHandler.addError(200, "user already connected");
		cmdHandler.addError(201, "already logged in");
		cmdHandler.addError(202, "authorization required");
		cmdHandler.addError(300, "already in game");
	}
	
	@Override
	public void handle(Client client, String[] args) throws CommandException {
        if(args.length!=1)
            throw new CommandException(103);
		
        if(this.getUser(client)!=null)
        	throw new CommandException(201);
        
    	for(User u : users.values())
    		if(u.getName().equalsIgnoreCase(args[0]))
    			throw new CommandException(200);
    	
        //TODO: password check
    	
    	users.put(client, new User(args[0], client));
        
        client.send("OK\n");
        System.out.println("User '"+args[0]+"' joined");
	}
	
	@Override
    protected void onClientDisconnect(Client client) {
        User u = users.remove(client);
        if(u!=null)
        	System.out.println("User '"+u.getName()+"' left");
    }
	
	public User getUser(Client client){
		return users.get(client);
	}
}
