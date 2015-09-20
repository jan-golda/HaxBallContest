package pl.regzand.haxballcontest.commands;

import java.util.LinkedList;
import java.util.Queue;

import pl.regzand.contestserver.CommandException;
import pl.regzand.haxballcontest.Game;
import pl.regzand.haxballcontest.Server;
import pl.regzand.haxballcontest.User;

public class JoinCommand extends GameCommand {
	
	private Queue<User> queue = new LinkedList<User>();
	
	public JoinCommand(Server server) {
		super(server);
	}
	
	@Override
	public void handleGameCommand(User user, String[] args) throws CommandException {
		checkArguments(args, 0, 0);
		
		if(user.isInGame())
			throw new CommandException(300);
		
		user.send("OK\n");
		
		queue.add(user);
		solveQueue();
	}
	
	public void solveQueue(){
		while(queue.size()>=2){
			User u1 = queue.remove();
			User u2 = queue.remove();
			new Game(u1, u2);
			u1.send("OK\n");
			u2.send("OK\n");
		}
	}
	
}
