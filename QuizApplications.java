import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

class QuizQuestion {
    String question;
    ArrayList<String> options;
    int correctOption;

    public QuizQuestion(String question, ArrayList<String> options, int correctOption) {
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;
    }
}

class Quiz {
    ArrayList<QuizQuestion> questions;
    int currentQuestionIndex;
    int score;
    Timer timer;
    Scanner scanner;

    public Quiz(ArrayList<QuizQuestion> questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
        this.timer = new Timer();
        this.scanner = new Scanner(System.in);
    }

    public void startQuiz() {
        displayNextQuestion();
    }

    private void displayNextQuestion() {
        if (currentQuestionIndex < questions.size()) {
            QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
            System.out.println("Question " + (currentQuestionIndex + 1) + ": " + currentQuestion.question);
            for (int i = 0; i < currentQuestion.options.size(); i++) {
                System.out.println((i + 1) + ". " + currentQuestion.options.get(i));
            }

            startTimer();
        } else {
            endQuiz();
        }
    }

    private void startTimer() {
        final int timeLimitInSeconds = 10; // Adjust the time limit as needed

        // Check if the timer is canceled before scheduling a new task
        if (timer != null) {
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println("\nTime's up! Moving to the next question.\n");
                    checkAnswer(-1); // Automatically move to the next question
                }
            }, timeLimitInSeconds * 1000); // Convert seconds to milliseconds
        }

        getAnswer();
    }

    private void getAnswer() {
        System.out.print("Enter your choice (1-" + questions.get(currentQuestionIndex).options.size() + "): ");
        int userChoice = scanner.nextInt();
        checkAnswer(userChoice);
    }

    private void checkAnswer(int userChoice) {
        timer.cancel(); // Cancel the timer before checking the answer
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        int correctOption = currentQuestion.correctOption;

        if (userChoice == correctOption) {
            System.out.println("Correct!\n");
            score++;
        } else {
            System.out.println("Incorrect. The correct answer was option " + correctOption + ".\n");
        }

        currentQuestionIndex++;
        displayNextQuestion();
    }

    private void endQuiz() {
        System.out.println("Quiz completed!");
        System.out.println("Your final score: " + score + "/" + questions.size());

        // Display summary of correct/incorrect answers if needed

        // Cleanup resources
        timer.cancel();
        scanner.close();
    }
}

public class QuizApplications {
    public static void main(String[] args) {
        // Define quiz questions
        ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();
        quizQuestions.add(new QuizQuestion("Who is invented Java Programming?",
                new ArrayList<>(List.of("Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup")),
                2));
        quizQuestions.add(new QuizQuestion("Which component is used to compile, debug and execute the java programs?",
                new ArrayList<>(List.of("JRE", "JIT", "JDK", "JVM")), 3));
        quizQuestions.add(new QuizQuestion("Which one of the following is not a Java feature?",
                new ArrayList<>(List.of("Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible")),
                2));
        quizQuestions.add(new QuizQuestion("What is the extension of the java code files?",
                new ArrayList<>(List.of(".js", ".txt ", ".class", ".java")), 4));
        quizQuestions.add(new QuizQuestion("Which of the following is not an OOPS concept in Java?",
                new ArrayList<>(List.of("Polymorphism", "Inheritance", "Compilation", "Encapsulation")), 3));

        // Create and start the quiz
        Quiz quiz = new Quiz(quizQuestions);
        quiz.startQuiz();
    }
}
