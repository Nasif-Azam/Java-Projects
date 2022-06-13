package QuestionsSystem;

public class Main {

	public static void main(String[] args) {
		QuestionList q = new QuestionList("CSE 102", "A");
		Question q1 = new Question("What is name1?", 2);
		Question q2 = new Question("What is name2?", 2);
		Question q3 = new Question("What is name3?", 2);

		q.addQuestion(q1);
		q.addQuestion(q2);
		q.addQuestion(q3);
		q.display();

	}
}
