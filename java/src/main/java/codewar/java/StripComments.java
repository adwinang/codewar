package codewar.java;

import java.util.Arrays;
import java.util.stream.Collectors;

// Complete the solution  so that it strips all text that follows any of a set of comment markers passed in. 
// Any whitespace at the end of the line should also be stripped out. e.g. ea #l\n, the space after ea has to be removed

// Example:

// Given an input string of:

// apples, pears # and bananas
// grapes
// bananas !apples
// The output expected would be:

// apples, pears
// grapes
// bananas
// The code would be called like so:

// var result = solution("apples, pears # and bananas\ngrapes\nbananas !apples", ["#", "!"])
// // result should == "apples, pears\ngrapes\nbananas"

public class StripComments {

    public static void main(String[] args) {    
        String test = mySolution("Test# last\nhi\n\n hi", new String[] { "#", "$", "!", "-" });
        System.out.println(test);
    }

    // Recursive solution
    // Take into account for comment markers that is more than one character
	public static String mySolution(String text, String[] commentSymbols) {
        String[] lines = text.split("(?=\\n)");
        text = "";

        for (String line : lines) {
            //Find position of comment marker
            for (int i = 0; i < line.length(); i++) {
                boolean commentFound = false;
                for (String z : commentSymbols) {
                    // Take into consideration if the comment marker string contains more than one char
                    for (int x = 0; x < z.length(); x++) {
                        if ((z.charAt(x) != line.charAt(i+x)) && !commentFound) {
                            commentFound = false;
                            i += x;
                        } else {
                            commentFound = true;
                            break;
                        }

                    }
                        
                }
                if (commentFound) {
                    line = line.substring(0, i);
                }

                boolean escape = true;
                // Remove all empty spaces at the back of the string
                while (escape) {
                    if (line != null && line.length() > 0 && line.charAt(line.length() - 1) == ' ') {
                        line = line.substring(0, line.length() - 1);
                    } else {
                        escape = false;
                    }
                }

            } 
            text += line;
        }
		return text;
    }

    // Java 8 solution, to be converted to Java 12
    
    // public static String cleanerSolution(String text, String[] commentSymbols) {
    //     String pattern = String.format(
    //         "[ ]*([%s].*)?$",
    //         Arrays.stream( commentSymbols ).collect( Collectors.joining() )
    //     );

    //     return Arrays.stream( text.split( "\n" ) )
    //         .map( x -> x.replaceAll( pattern, "" ) )
    //         .collect( Collectors.joining( "\n" ) );
    // }
}