import java.io.BufferedWriter;
import java.io.FileWriter;

class USendMoney extends UCheckMoney {
//	Scanner sc=new Scanner(System.in);
	String userPass;
	String senderNumber;
	int userBalance;
	int userIndexPos;
	int currentBalance;

	USendMoney(String UP, int UB, int index) {
		super(UP, UB, index);
		userPass = UP;
		userBalance = UB;
		userIndexPos = index;
	}

	int sendMoneyRecord(int count) {
		System.out.print("Enter Sender Number: ");
		senderNumber = sc.next();
		System.out.print("Enter Ammount: ");
		int ammount = sc.nextInt();
		currentBalance = userBalance - ammount;
		System.out.println("Current Balance: " + currentBalance);
		Menu M = new Menu(currentBalance, userIndexPos);
		try {
			BufferedWriter BW = new BufferedWriter(new FileWriter("Send Money Record.txt"));
			BW.write("Sender Number:\t Ammount:\n");
			String Am = Integer.toString(ammount);
//			for (int i = 0; i <= count; i++) {}
			BW.write(senderNumber + "\t   ");
			BW.write(Am);
			BW.newLine();
			BW.close();
		} catch (Exception e) {
			System.out.println("File not found: " + e);
			e.printStackTrace();
		}

		return currentBalance;
	}
}
