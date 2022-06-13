import java.util.PriorityQueue;
import java.util.Scanner;

public class Greedy_10954 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			if (n == 0)
				break;

			PriorityQueue<Integer> PQ = new PriorityQueue<Integer>();
			for (int i = 0; i < n; i++)
				PQ.offer(sc.nextInt()); // Inserts the specified element into this priority queue.

			int cost = 0;
			while (!PQ.isEmpty() && n > 1) {
				int x = PQ.poll() + PQ.poll(); // Take & Remove the 1st item of this queue.
				cost += x;
				PQ.offer(x);
				n--;
			}
			System.out.println(cost);
		}
	}
}
