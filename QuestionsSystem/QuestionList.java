package QuestionsSystem;

import java.util.ArrayList;

public class QuestionList {
	ArrayList<Question> questions;
	String courseCode, Set;

	public QuestionList(String courseCode, String Set) {
		this.courseCode = courseCode;
		this.Set = Set;
		questions = new ArrayList<Question>();
	}

	void addQuestion(Question q) {
		questions.add(q);
	}

	void display() {
		System.out.println("Course Code: " + courseCode);
		System.out.println("Set: " + Set);
		System.out.println("Total Question: " + questions.size());
		double mark = 0;

		for (int i = 0; i < questions.size(); i++) {
			Question q = questions.get(i);
			System.out.println((i + 1) + "." + q.question + " > " + q.marks);
			mark = mark + q.marks;
		}
		System.out.println("Total Marks: " + mark);
	}

	public static void main(String[] args) {

	}

}
