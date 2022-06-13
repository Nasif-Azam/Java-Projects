
public class UPayMoney extends UCheckMoney {

	UPayMoney(String UN) {
		super(UN);
		System.out.println("Sender Name: " + UN);
	}

	UPayMoney(String UP, int UB, int index) {
		super(UP, UB, index);
	}

}
