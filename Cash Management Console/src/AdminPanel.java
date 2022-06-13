import java.util.ArrayList;
import java.util.Scanner;

interface Operation { // Abstractions
	String adminName = "Nasif"; // Encapsulation, Abstractions
	String adminPass = "111"; // Encapsulation, Abstractions

	void Operations(ArrayList<String> userNames, ArrayList<String> userPass, ArrayList<Integer> userBlnc);
}

public class AdminPanel implements Operation {
	public String getAdminName() {
		return adminName;
	}

	public String getAdminPass() {
		return adminPass;
	}

	public void admin(ArrayList<String> userNames, ArrayList<String> userPass, ArrayList<Integer> userBlnc) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Admin Name: ");
		String AdminName = sc.next();
		System.out.print("Enter Admin Password: ");
		String AdminPass = sc.next();

		if (AdminName.equals(getAdminName()) && AdminPass.equals(getAdminPass())) {
			Operations(userNames, userPass, userBlnc);
		} else {
			System.out.println("Invalid pass!!");
		}
	}

// Abstract Method
	public void Operations(ArrayList<String> userNames, ArrayList<String> userPass, ArrayList<Integer> userBlnc) {
		System.out.println("Uasers Informations are: ");
		for (int i = 0; i < userNames.size(); i++) {
			System.out.print("Name: " + userNames.get(i) + "\t" + "Pasword: " + userPass.get(i) + "\t" + "Balance: "
					+ userBlnc.get(i) + "\n");
		}

	}

}
