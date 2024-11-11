package application;

import java.util.ArrayList;

public class Quiz {
	private String title;
	private ArrayList<Question> questions;

	public Quiz(String title) {
		this.title = title;
		this.questions = new ArrayList<>();
	}

	public void addQuestion(Question question) {
		questions.add(question);
	}

	public ArrayList<Question> getQuestions() {
		return questions;
	}

	public String getTitle() {
		return title;
	}
}
