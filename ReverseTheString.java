//package com.weightwatchers.test;

public class ReverseTheString
{
    static void reverseEverything(String s)
    {
        //when you get the input, split it up
    	String[] words = s.split(" ");
         
        String reverseTheString = "";
         
        for (int i = 0; i < words.length; i++) 
        {
            //start doing the work of taking each word and then reversing it
        	String word = words[i];
             
            String reverseTheWord = "";
             
            for (int j = word.length()-1; j >= 0; j--) 
            {
                reverseTheWord = reverseTheWord + word.charAt(j);
            }
             
            //finish it up
            reverseTheString = reverseTheString + reverseTheWord + " ";
        }
        //then display the output via println statements
        System.out.println("This is the original string:");
        System.out.println(s);
        System.out.println("===========================================");
        System.out.println("Here is the output in reverse:");
        System.out.println(reverseTheString);
        System.out.println("");
    }
     
    public static void main(String[] args) 
    {
        reverseEverything("hope you are doing well");
        reverseEverything("how does this string look when reversed");
        reverseEverything("reversing another one");
        System.out.println("Should be done after this one");
    }
}
