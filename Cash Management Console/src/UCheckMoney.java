import java.util.Scanner;

public class UCheckMoney {
	Scanner sc = new Scanner(System.in);

	UCheckMoney(String UN) { // Constructor Overloading
		System.out.println("User Name : " + UN);
	}

	UCheckMoney(String UP, int UB, int index) { // Constructor Overloading
		System.out.print("Enter Your Password: ");
		String enteredPass = sc.next();
		for (int i = 0; i < 1; i++) {
			if (UP.equals(enteredPass)) {
				System.out.println("User Balance : " + UB);
			} else {
				System.out.println("Invalid Password!!");
//				break;
			}
		}

	}

}
