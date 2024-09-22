import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Question {
    String question;
    String[] options;
    int correctAnswerIndex;

    public Question(String question, String[] options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }
}

public class QuizApp {
    private final List<Question> questions;
    private int score;

    public QuizApp() {
        questions = new ArrayList<>();
        score = 0;

        // Sample questions
        questions.add(new Question("What is the capital of France?",
                new String[]{"1. Berlin", "2. Madrid", "3. Paris", "4. Rome"}, 2));
        questions.add(new Question("Which planet is known as the Red Planet?",
                new String[]{"1. Earth", "2. Mars", "3. Jupiter", "4. Saturn"}, 1));
        questions.add(new Question("Who wrote 'Romeo and Juliet'?",
                new String[]{"1. Charles Dickens", "2. Mark Twain", "3. William Shakespeare", "4. Jane Austen"}, 2));
    }

    public void startQuiz() {
        try (Scanner scanner = new Scanner(System.in)) {
            for (Question q : questions) {
                System.out.println(q.question);
                for (String option : q.options) {
                    System.out.println(option);
                }
                
                System.out.print("Select your answer (1-" + q.options.length + "): ");
                int userAnswer = scanner.nextInt() - 1; // Subtract 1 to match array index
                
                if (userAnswer == q.correctAnswerIndex) {
                    System.out.println("Correct!\n");
                    score++;
                } else {
                    System.out.println("Wrong! The correct answer was: " + q.options[q.correctAnswerIndex] + "\n");
                }
            }
            
            System.out.println("Quiz finished! Your score: " + score + "/" + questions.size());
        }
    }

    public static void main(String[] args) {
        QuizApp quizApp = new QuizApp();
        quizApp.startQuiz();
    }
}
