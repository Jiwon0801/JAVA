package edu.autocar.goodsinfo.command;

import edu.autocar.base.command.Command;
import edu.autocar.base.database.ConnectionProvider;

public class ExitCommand implements Command {

	@Override
	public void execute() throws Exception {
		System.out.println("종료합니다.");
		ConnectionProvider.close();
		System.exit(0);
	}
}
