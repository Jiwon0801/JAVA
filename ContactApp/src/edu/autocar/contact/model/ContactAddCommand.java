package edu.autocar.contact.model;

import edu.autocar.base.command.Command;
import edu.autocar.base.util.Input;

public class ContactAddCommand implements Command {

	@Override
	public void execute() throws Exception {
		ContactService service = ContactService.getInstance();
		Contact contact = createContact();
		service.add(contact);
	}

	Contact createContact() {
		System.out.println("주소록 정보를 입력하세요.");
		String name = Input.getString("이름 : ");
		String phone = Input.getString("전화번호 : ");
		String email = Input.getString("email : ");
		String group = Input.getString("그룹 : ");
		String memo = Input.getString("메모 : ");

		return new Contact(name, phone, email, group, memo);
	}
}
