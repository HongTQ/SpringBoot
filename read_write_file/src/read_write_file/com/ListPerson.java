package read_write_file.com;

import java.util.ArrayList;
import java.util.Scanner;

public class ListPerson {
	ArrayList<Person> listPerson = new ArrayList<Person>();
	private Scanner sc = new Scanner(System.in);
	private ManangerFile manangerFile = new ManangerFile(); 
	
	public ListPerson() {
//		listPerson.add(new Person(1,"hong1",true,"31/08/1993", "0972608111"));
//		listPerson.add(new Person(2,"hong2",true,"31/08/1993", "0972608111"));
//		listPerson.add(new Person(3,"hong3",true,"31/08/1993", "0972608111"));
//		listPerson.add(new Person(4,"hong4",true,"31/08/1993", "0972608111"));
	}
	
	public void viewAllListPerson() {
		if (listPerson.isEmpty()) {
			System.out.println("Empty list");
		} else {
			System.out.println("List persons");
			for (Person person : listPerson) {
				System.out.println(person.toString());
			}
		}
	}

	public void addListPerson() {
		int id;
		boolean sex;
		String name, birthday, phone;
		System.out.print("Enter id : ");
		id = sc.nextInt();
		sc.nextLine();

		System.out.print("Enter name : ");
		name = sc.nextLine();

		System.out.print("Enter sex (true or false) : ");
		sex = sc.nextBoolean();
		sc.nextLine();

		System.out.print("Enter birthday : ");
		birthday = sc.nextLine();

		System.out.print("Enter phone : ");
		phone = sc.nextLine();

		listPerson.add(new Person(id, name, sex, birthday, phone));
	}

	public void editPerson(int id) {
		int index = findIndexById(id);
		if (index != -1) {
			boolean sex;
			String name, birthday, phone;
			
			System.out.print("Enter name : ");
			name = sc.nextLine();

			System.out.print("Enter sex (true or false) : ");
			sex = sc.nextBoolean();
			sc.nextLine();

			System.out.print("Enter birthday : ");
			birthday = sc.nextLine();

			System.out.print("Enter phone : ");
			phone = sc.nextLine();
			listPerson.get(index).setName(name);
			listPerson.get(index).setSex(sex);
			listPerson.get(index).setBirthday(birthday);
			listPerson.get(index).setPhone(phone);
		} else {
			System.out.println("Person not found.");
		}
	}

	public void deleteById(int id) {
		int index = findIndexById(id);
		if(index != -1) {
			listPerson.remove(index);
		}else {
			System.out.println("Person not found.");
		}
	}
	public int findIndexById(int id) {
		int i = 0, index = -1;
		for (Person person : listPerson) {
			if (person.getId() == id) {
				index = i;
			}
			i++;
		}
		return index;
	}

	public void findById(int id) {
		int index = findIndexById(id);
		if(index != -1) {
			System.out.println(listPerson.get(index).toString());
		}else {
			System.out.println("Person not found.");
		}
	}
	

	public void readFile() {
		listPerson = manangerFile.readPersonFromFile(listPerson);
	}
	
	public void writeFile() {
		manangerFile.writePersonInFile(listPerson);
	}
}
