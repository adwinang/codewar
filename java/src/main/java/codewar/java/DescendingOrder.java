package codewar.java;

// Instructions
// Output
// Your task is to make a function that can take any non-negative integer as a argument and return it with its digits in descending order. Essentially, rearrange the digits to create the highest possible number.

// Examples:

// Input: 21445 Output: 54421

// Input: 145263 Output: 654321

// Input: 123456789 Output: 987654321

public class DescendingOrder {
    public static void main(String[] args) {
        int number = 123456789;
        int sortedNumber = 0;
        for (int i = 9; i >= 0; i--)
        {
            int tmpNumber = number;
            while (tmpNumber > 0)
            {
                int digit = tmpNumber % 10;             
                if (digit == i)
                {
                    sortedNumber *= 10;
                    sortedNumber += digit;
                }
                tmpNumber /= 10;                
            }               
        }
        System.out.println(sortedNumber);
        mySolution(123456789);
    }

    public static int mySolution(int num) {
        while (num > 0) {
            System.out.println(num % 10);
            num = num / 10;
        }
        return 3;
    }

}