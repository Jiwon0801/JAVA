package edu.autocar.contact.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ContactService {
	List<Contact> contactlist;

	private ContactService() {
		contactlist = new ArrayList<>();
	}

	private static ContactService instance = new ContactService();
	
	public static ContactService getInstance() {
		return instance;
	}
	
	public void add(Contact contact) {
		contactlist.add(contact);
	}
	
	public Contact[] getContactList() {
		Contact[] arr = new Contact[contactlist.size()];
		return  contactlist.toArray(arr);
	}
	
	public void save(File file) throws Exception {
		try (FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);){
			oos.writeObject(contactlist);
			oos.flush();
		} 
	}
	
	public void open(File file) throws Exception {
		try (FileInputStream fis = new FileInputStream(file);
				ObjectInputStream ois = new ObjectInputStream(fis);){
			contactlist = (List<Contact>)ois.readObject();
		} 
	}
}
