/*
 * Classname InputName
 *
 * Version info
 * IntelliJ IDEA 2021.3 (Community Edition)
 *
 * Copyright notice
 * 2022, Mangde Satya
 */
package com.quiz;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Make a welcome and input name
public class InputName extends Variabel {


    public static void name() {

        System.out.println("<------ Welcome ------>\n\n");
        System.out.print("Please Input Your Name : ");
        name = input.nextLine();
        if (isValidName(name)) {
            System.out.println("\n\nWelcome " + name +" " + "Good Luck My Dear :)");
            System.out.println();
            Topic.inputTopic();
        } else {
            name();
        }
    }

    public static boolean isValidName(String name) {
        // Regex to check valid username.
        String regex = "^[A-Z a-z]+";
        Pattern p = Pattern.compile(regex);
        if (name == null) {
            return false;
        }
        Matcher m = p.matcher(name);
        return m.matches();
    }
}
