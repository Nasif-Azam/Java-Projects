import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

class Menu {
	Scanner sc = new Scanner(System.in);
	static String name;
	static String pass;
	static int addMoney;
	int currentBalance;
	int userIndexPos;

	public Menu(String name, String pass, int addMoney) {
		this.name = name;
		this.pass = pass;
		this.addMoney = addMoney;
	}

	public Menu(int currentBalance, int userIndexPos) {
		this.currentBalance = currentBalance;
		this.userIndexPos = userIndexPos;
	}

	void Menu(ArrayList<String> userNames, ArrayList<String> userPass, ArrayList<Integer> userBlnc) {
		boolean repeat = true;
		while (repeat) {
			System.out.println("*----------------------------------*");
			System.out.println("|    Money Transaction System\t|");
			System.out.println("*----------------------------------*");
			System.out.println("|\t" + "1. Admin Panel." + "\t\t" + "|");
			System.out.println("|\t" + "2. User Panel." + "\t\t\t" + "|");
			System.out.println("|\t" + "3. Registration." + "\t\t\t" + "|");
			System.out.println("|\t" + "4. Exit." + "\t\t\t\t" + "|");
			System.out.println("*----------------------------------*");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("*----------------------------------*");
				System.out.println("    Welcome to Admin Panel");
				System.out.println("*----------------------------------*");
				AdminPanel AP = new AdminPanel();
				AP.admin(userNames, userPass, userBlnc);
				break;
			}
			case 2: {
				System.out.println("*----------------------------------*");
				System.out.println("      Welcome to User Panel");
				System.out.println("*----------------------------------*");
				UserPanel UP = new UserPanel();
//				userBlnc.set(userIndexPos, currentBalance);
				UP.user(userNames, userPass, userBlnc);
//				userBlnc.add(userIndexPos) = currentBalance;
				break;
			}
			case 3: {
				System.out.println("*----------------------------------*");
				System.out.println("     Welcome to Registration");
				System.out.println("*----------------------------------*");
				RegistrationPanel RP = new RegistrationPanel();
				RP.registration();
				userNames.add(name);
				userPass.add(pass);
				userBlnc.add(addMoney);
				break;
			}
			case 4: {
				repeat = false;
				System.exit(0);
			}
			default:
				System.out.println("Invalid choice!!");
			}
			try {
				BufferedWriter BW = new BufferedWriter(new FileWriter("Admin.txt"));
//				BW = 
				BW.write("Name:\t Passwords:\t Balance:\n");
				for (int i = 0; i < userNames.size(); i++) {
					BW.write(userNames.get(i) + "\t   ");
					BW.write(userPass.get(i) + "\t   \t");
					BW.write(userBlnc.get(i).toString());
					BW.newLine();
				}
				BW.close();
			} catch (Exception e) {
				System.out.println("File not found: " + e);
				e.printStackTrace();
			}

		}
	}
}

public class HomePage {

	public static void main(String[] args) {
		Menu M = new Menu(null, null, 0);
		ArrayList<String> userNames = new ArrayList<String>();
		ArrayList<String> userPass = new ArrayList<String>();
		ArrayList<Integer> userBlnc = new ArrayList<Integer>();

		userNames.add("Azam");
		userPass.add("111");
		userBlnc.add(785);
		userNames.add("Zisha");
		userPass.add("222");
		userBlnc.add(1500);
		M.Menu(userNames, userPass, userBlnc);
	}
}
