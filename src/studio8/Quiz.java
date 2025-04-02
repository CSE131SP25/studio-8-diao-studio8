package studio8;

import java.util.Scanner;

import support.cse131.NotYetImplementedException;

public class Quiz {
	
	private Question[] questions;
	/**
	 * Constructor
	 * @param questions
	 */
	public Quiz(Question[] questions) {
		this.questions = questions;
	}
	
	/**
	 * Prompts the user to answer, then returns a String containing their answer.
	 * @param in
	 * @return String answer
	 */
	private String getUserAnswer(Scanner in) {
		System.out.print("Please enter your answer: ");
		String out = in.next();
		return out;
	}
	
	/**
	 * Gets the number of points possible in the quiz.
	 * @return int number of total points
	 */
	public int getTotalPoints() {
		int totalPoints = 0;
		for (Question Q: questions) {
			totalPoints += Q.getPoints();
		}
		return totalPoints;
	}
	
	/**
	 * Asks the user all question in the quiz, then prints out 
	 * the amount of points the user earned. This print statement
	 * should include "You earned ____ points"
	 * 
	 * @param in Scanner object to feed into getUserAnswer
	 */
	public void takeQuiz(Scanner in) {
		int earnedPointsTotal = 0;
		for (Question Q: questions) {
			Q.displayPrompt();
			int earnedPoints = Q.checkAnswer(this.getUserAnswer(in));
			System.out.println("You earned " + earnedPoints + " points for this question");
			earnedPointsTotal += earnedPoints;
		}
		System.out.println("You earned " + earnedPointsTotal + " points out of " + this.getTotalPoints() + " points");
	}
	
	
	public static void main(String[] args) {
		// TODO: Make your own Quiz!
		Scanner in = new Scanner(System.in);
		Question Q1 = new Question("what is the answer", "answer", 100);
		Question[] questions = {Q1};
		Quiz QQ1 = new Quiz(questions);
		QQ1.takeQuiz(in);
		
	}
}
