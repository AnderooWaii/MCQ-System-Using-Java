/*
 * Classname Topic
 *
 * Version info
 * IntelliJ IDEA 2021.3 (Community Edition)
 *
 * Copyright notice
 * 2022, Mangde Satya
 */
package com.quiz;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// create the menuFunction that will display the MCQ's topic
public class Topic extends InputName {
    public static void menu() {
        System.out.println("Choose Your Test : ");
        System.out.println("<-----------");
        System.out.println("1. Software");
        System.out.println("2. Hardware");
        System.out.println("----------->");
        System.out.print("Input 1 Or 2 : ");
    }

    // Create function to display the mcq's topics
    public static void inputTopic() {
        // make the check part if not (1 or 2) the program will loop
        // print the MCQ's topic
        menu();
        topicInput = input.nextLine();
        switch (topicInput) {
            case "1" -> {
                System.out.println("--------------------------------");
                System.out.println(name + " Choose The Hardware Topic");
                System.out.println("Goodluck " + name);
                System.out.println("--------------------------------");
                System.out.println();
                displayMcqTopic("src\\com\\quiz\\Software.csv");
            }
            case "2" -> {
                System.out.println("--------------------------------");
                System.out.println(name + " Choose The Software Topic");
                System.out.println("Goodluck " + name);
                System.out.println("--------------------------------");
                displayMcqTopic("src\\com\\quiz\\Hardware.csv");
                System.out.println();
            }
            default -> {
                String correctChoose = "^[1]|[2]*$";
                if (!topicInput.equals(correctChoose)) {
                    System.out.println("Please Insert The Correct Input (1 Or 2)");
                    inputTopic();
                }
            }
        }

    }

    // create function to display the MCQ's topic question
    public static void displayMcqTopic(String topic) {
        try {
            // variable declaration
            int userScore = 0;
            int getWrong = 0;


            BufferedReader in = new BufferedReader(new FileReader(topic));
            // declaring variable that can be used inside this scope
            while ((line = in.readLine()) != null) {
                String[] numOfQuest = line.split(splitBy);
                do {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(numOfQuest[i]);
                    }
                    System.out.print("Your Answer Is : ");
                    Scanner userAnswer = new Scanner(System.in);
                    userSetAnswer = userAnswer.nextLine();
                    System.out.println();
                    if (userSetAnswer.equalsIgnoreCase("a")) {
                        userGetAnswer = numOfQuest[1];
                    } else if (userSetAnswer.equalsIgnoreCase("b")) {
                        userGetAnswer = numOfQuest[2];
                    } else if (userSetAnswer.equalsIgnoreCase("c")) {
                        userGetAnswer = numOfQuest[3];
                    } else if (userSetAnswer.equalsIgnoreCase("d")) {
                        userGetAnswer = numOfQuest[4];
                    } else {
                        System.out.println("> Please input a, b, c, d option <");
                        System.out.println();
                        userGetAnswer = null;
                    }
                } while (!(userSetAnswer.equalsIgnoreCase("a") || userSetAnswer.equalsIgnoreCase("b")
                        || userSetAnswer.equalsIgnoreCase("c") || userSetAnswer.equalsIgnoreCase("d")));

                // checking for the score
                if (userGetAnswer.equals(numOfQuest[5])) {
                    userScore++;
                    System.out.println("------------------------------");
                    System.out.println("Correct" + " Your Score Is =" + " " + userScore * 10 + "%");
                    System.out.println("------------------------------\n");

                } else if (userGetAnswer.equals(numOfQuest[5]) == false) {
                    getWrong++;
                    System.out.println("------------------------------");
                    System.out.println("Wrong"+ ",The Answer Is" + " " + numOfQuest[5] );
                    System.out.println("Your Score Is " + userScore * 10 + "%");
                    System.out.println("------------------------------\n");

                } else {
                    System.out.println("Please type a, b, c, or d");
                }
            }
            System.out.println( );
            System.out.println("------------------------------");
            System.out.println("Nice " + name + " ,You Have Done Your Test");
            System.out.println("Score = " + userScore * 10 + "%");
            System.out.println("Your Correct Answer = " + userScore);
            System.out.println("Your Wrong Anser = " + getWrong);
            System.out.println("------------------------------");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
