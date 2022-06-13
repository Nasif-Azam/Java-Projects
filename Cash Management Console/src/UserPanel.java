import java.util.ArrayList;
import java.util.Scanner;

public class UserPanel {
	Scanner sc = new Scanner(System.in);
	int currentBalance;

	public void user(ArrayList<String> userNames, ArrayList<String> userPass, ArrayList<Integer> userBlnc) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter User Name: ");
		String un = sc.next();
		System.out.print("Enter User Password: ");
		String up = sc.next();
		int i;
		for (i = 0; i < userNames.size(); i++) {
			if (un.equals(userNames.get(i)) && up.equals(userPass.get(i))) {
				currentBalance = userBlnc.get(i);
				Operations(userNames.get(i), userPass.get(i), userBlnc.get(i), i);
				break;
			}

		}
		if (i == userNames.size()) {
			System.out.println("Invalid Password!!");
		}
	}

	public void Operations(String UN, String UP, int UB, int index) {
		int count = 0;
		boolean repeat = true;
		while (repeat) {
			System.out.println("*----------------------------------*");
			System.out.println("|    \tUser Panel Options\t\t|");
			System.out.println("*----------------------------------*");
			System.out.println("|\t" + "1. Check Money." + "\t\t" + "|");
			System.out.println("|\t" + "2. Send Money." + "\t\t" + "|");
			System.out.println("|\t" + "3. Pay Money." + "\t\t\t" + "|");
			System.out.println("|\t" + "4. Exit." + "\t\t\t\t" + "|");
			System.out.println("*----------------------------------*");
			System.out.print("Enter your choice: ");
			int ch = sc.nextInt();
			switch (ch) {
			case 1: {
				System.out.println("*----------------------------------*");
				System.out.println("\t\tCheck Money");
				System.out.println("*----------------------------------*");
				UCheckMoney CM;
				CM = new UCheckMoney(UN); // Static Polymorphism
				UB = currentBalance;
				CM = new UCheckMoney(UP, UB, index); // Static Polymorphism
				break;
			}
			case 2: {
				count++;
				System.out.println("*----------------------------------*");
				System.out.println("\t\tSend Money");
				System.out.println("*----------------------------------*");
				USendMoney SM;
				SM = new USendMoney(UP, UB, index);
				currentBalance = SM.sendMoneyRecord(count);
				break;
			}
			case 3: {
				System.out.println("*----------------------------------*");
				System.out.println("\t\tPay Money");
				System.out.println("*----------------------------------*");

				break;
			}
			case 4: {
				repeat = false;
				System.exit(0);
			}
			default:
				System.out.println("Invalid choice!!");
			}

		}

	}
}
