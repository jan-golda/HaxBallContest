package pl.regzand.haxballcontest.commands;

import pl.regzand.contestserver.Client;
import pl.regzand.contestserver.Command;
import pl.regzand.contestserver.CommandException;
import pl.regzand.haxballcontest.Server;
import pl.regzand.haxballcontest.User;

public abstract class GameCommand implements Command {
	
	private final Server server;

	public GameCommand(Server server) {
		this.server = server;
	}
	
	@Override
    public void handle(Client client, String[] args) throws CommandException {
		User user = server.getUser(client);
		
		if(user==null)
			throw new CommandException(202);
		
		handleGameCommand(client, user, args);
	}
	
	public abstract void handleGameCommand(Client client, User user, String[] args) throws CommandException;

    public void checkArguments(String[] args, int min, int max) throws CommandException{
        if(args.length < min || args.length > max)
            throw new CommandException(103);
    }
}
