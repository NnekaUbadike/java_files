package labs6topresent;
import java.util.*;
public class Lab7_class_example {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Perceptron p1 = new Perceptron();
		Perceptron p2 = new Perceptron();
		p2.state = 1;
		System.out.println("p1 predicts: " + p1.predictAnswer()); //object
		System.out.println("p2 predicts: " + p2.predictAnswer()); //object
		System.out.println("p1 predicts (static): " + 
					predictAnswer(p1));  //static
		System.out.println("p1 predicts (static): " + 
					predictAnswer(p2));  //static
		int randomBit = scan.nextInt();
		Coin c1 = new Coin();
		int correctPredictionCount = 0;
		int correctCoinPredictionCount = 0;
		int randomCount = 0;
		while(randomBit != -1) {
			int prediction = p1.predictAnswer();
			int flipResult = c1.flip();
			int coinPrediction = p2.predictAnswer();
			int predictionCorrect = randomBit == prediction ? 1 : 0;
			int coinPredictionCorrect = flipResult == coinPrediction ? 1 : 0;
			p1.correctnessFeedback(predictionCorrect);
			p2.correctnessFeedback(coinPredictionCorrect);
			correctPredictionCount += predictionCorrect;
			correctCoinPredictionCount += coinPredictionCorrect;
			randomCount++;
			randomBit = scan.nextInt();
		} 
		double correctRatio = p1.percentCorrect();
		System.out.printf("(human) perceptron was right %.1f%%\n", 
				correctRatio);
		double correctCoinRatio = p2.percentCorrect();
		System.out.printf("(computer) perceptron was right %.1f%%\n", 
				correctCoinRatio);
		System.out.println("p1: " + p1 + " p2: " + p2);
		
	}
	/*
	 * This method is the action of asking a 
	 * perceptron a question, which it answers
	 * based on whatever state it is in.
	 */
	public static int predictAnswer(Perceptron p) {
		return p.state;
	}
}

class Perceptron {
	int state;  //by default state = 0
	int numberOfPredictions;
	int numberOfCorrectPredictions;
	
	/*
	 * This method is the action of asking a 
	 * perceptron a question, which it answers
	 * based on whatever state it is in.
	 */
	public int predictAnswer() {
		numberOfPredictions++;
		return state; //what is the scope of state.
	}
	
	/*This method will give feedback to the perceptron.
	 * If the answer was correct, set the parameter to 1
	 * If the answer was incorrect, set the parameter to 0.
	 */
	public void correctnessFeedback(int correct) {
		numberOfCorrectPredictions += correct;
		if(correct == 0) {
			state = 1 - state;
		}
	}
	
	public String toString() {
		return "{" + state + ", " + percentCorrect() + "}";
	}
	
	public double percentCorrect() {
		return 100 * (numberOfCorrectPredictions / 
				(double) numberOfPredictions);
	}
}

class Coin {
	Random rand = new Random();
	
	public int flip() {
		return rand.nextInt(2);
	}
}



