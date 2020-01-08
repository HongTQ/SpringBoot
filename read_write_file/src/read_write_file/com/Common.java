package read_write_file.com;

import java.util.Scanner;

public class Common {
	ListPerson listPerson = new ListPerson();

	public void Menu() {
		int choose;
		System.out.println("Choose the menu : ");
		System.out.println("===========");
		System.out.println("1.View All person.");
		System.out.println("2.Add person.");
		System.out.println("3.Edit person.");
		System.out.println("4.Delete person.");
		System.out.println("5.Find person by ID");
		System.out.println("6.Read file upload.");
		System.out.println("7. Update file upload.");
		System.out.println("8. Exit.");
		System.out.println("Choose the menu.");
		Scanner sc = new Scanner(System.in);
		choose = sc.nextInt();
		switch (choose) {
		case 1:
			listPerson.viewAllListPerson();
			Menu();
			break;
		case 2:
			listPerson.addListPerson();
			Menu();
			break;
		case 3:
			int idEdit;
			System.out.println("Enter id :");
			idEdit = sc.nextInt();
			listPerson.editPerson(idEdit);
			Menu();
			break;
		case 4:
			int idDel;
			System.out.println("Enter id :");
			idDel = sc.nextInt();
			listPerson.deleteById(idDel);
			Menu();
			break;
		case 5:
			int idFind;
			System.out.println("Enter id :");
			idFind = sc.nextInt();
			listPerson.findById(idFind);
			Menu();
			break;
		case 6:
			listPerson.readFile();
			Menu();
			break;
		case 7:
			listPerson.writeFile();
			Menu();
			break;
		case 8:
			System.exit(0);
			break;
		default:
			Menu();
			break;
		}
		sc.close();
	}
}
