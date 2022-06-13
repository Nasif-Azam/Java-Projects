import java.security.SecureRandom;
import java.util.Scanner;

public class RegistrationPanel {
	Scanner sc = new Scanner(System.in);
	String codeArr[] = new String[1];
	String allAlp = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	String allChars = "0123456789" + allAlp;

	public void registration() {
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 5; i++) {
			int randomIndex = random.nextInt(allChars.length());
			sb.append(allChars.charAt(randomIndex));
		}
		String temp = sb.toString();
		codeArr[0] = temp;

		boolean repeat = true;
		while (repeat) {
			System.out.print("Full Name: ");
			String name = sc.nextLine();

			System.out.print("Password: ");
			String pass = sc.nextLine();

			System.out.print("Need to add at least 500/= tk:  ");
			int addMoney = sc.nextInt();
			if (addMoney < 500) {
				System.out.println("Account not created!! ");
			} else {
				codeChecker();
				System.out.println("Account succesfully created.");
				Menu M = new Menu(name, pass, addMoney);
				repeat = false;
			}
		}

	}

	public void codeChecker() {
		System.out.println("Verification Code is : " + codeArr[0]);
		System.out.print("User Typed Code is :   ");
		String Code = sc.next();
		if (Code.contains(codeArr[0])) {
			System.out.println("Done!!");
		} else {
			System.out.println("Verification code isn't match!!");
		}

	}
}
