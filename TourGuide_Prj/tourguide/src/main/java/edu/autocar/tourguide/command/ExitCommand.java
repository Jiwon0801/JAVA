package edu.autocar.tourguide.command;
import edu.autocar.base.command.Command;

public class ExitCommand implements Command {
	@Override
	public void execute() throws Exception {
		System.out.println("종료합니다.");
		System.exit(0);
	}
}
