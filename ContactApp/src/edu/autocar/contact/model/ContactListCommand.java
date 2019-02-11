package edu.autocar.contact.model;

import edu.autocar.base.command.Command;

public class ContactListCommand implements Command {

	@Override
	public void execute() throws Exception {
		ContactService service = ContactService.getInstance();
		Contact[] contacts = service.getContactList();

		if (contacts.length == 0) {
			System.err.println("유효한 파일을 열어주세요.");
		} else {
			for (int i = 0; i < contacts.length; i++) {
				Contact c = contacts[i];
				System.out.printf("%3d] %-10s %-15s %-15s\n", i + 1, c.getName(), c.getPhone(), c.getEmail());
			}
		}
	}
}