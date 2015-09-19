package pl.regzand.haxballcontest;

public class Main {
	
	public static Server server;
	
	public static void main(String[] args){
		if(args.length==0){
            System.err.println("Usage: java HaxBallContest <port>");
            System.exit(10);
            return;
        }

        server = new Server(Integer.parseInt(args[0]));
	}
}
