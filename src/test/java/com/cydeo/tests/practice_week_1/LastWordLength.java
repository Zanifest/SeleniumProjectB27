package com.cydeo.tests.practice_week_1;

public class LastWordLength {

    /*
    leet
Length of Last Word Task:

Given a string s consisting of words and spaces, return the length of the last word in the string.

A word is a maximal substring consisting of non-space characters only.



Example 1:

Input: s = "Hello World"
Output: 5
Explanation: The last word is "World" with length 5.

Example 2:
Input: s = "   fly me   to   the moon  "
Output: 4
Explanation: The last word is "moon" with length 4.

Example 3:
Input: s = "luffy is still joyboy"
Output: 6
Explanation: The last word is "joyboy" with length 6

     */
    public static void main(String[] args) {

        String s = "luffy is still joyboy".trim();
        String lastWord = s.substring(s.lastIndexOf(" ") + 1);

        int count = 0;
        for (int i = 0; i < lastWord.length(); i++) {
            count++;
        }
        System.out.println("length of last word = " + count);
        System.out.println("lastWord.length() = " + lastWord.length()); // either or works but no need to go in a loop

    }
}
