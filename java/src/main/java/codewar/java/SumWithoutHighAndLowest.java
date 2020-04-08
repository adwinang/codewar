package codewar.java;

// Sum all the numbers of the array (in F# and Haskell you get a list) except the highest and the lowest element (the value, not the index!).
// (The highest/lowest element is respectively only one element at each edge, even if there are more than one with the same value!)

// Example:

// { 6, 2, 1, 8, 10 } => 16
// { 1, 1, 11, 2, 3 } => 6

// If array is empty, null or None, or if only 1 Element exists, return 0.
// Note:In C++ instead null an empty vector is used. In C there is no null. ;-) 


// -- There's no null in Haskell, therefore Maybe [Int] is used. Nothing represents null.
// Have fun coding it and please don't forget to vote and rank this kata! :-)

// I have created other katas. Have a look if you like coding and challenges.


public class SumWithoutHighAndLowest {

    public static void main(String[] args) {
        sum(null);
        System.out.println(sum(new int[] { 6, 2, 1, 8, 10}));
    }

    public static int sum(int[] numbers)
    {
        if (numbers == null || numbers.length == 1 || numbers.length == 0) {
            return 0;
        }
        int highest,lowest,total;
        highest = lowest = numbers[0];
        total = 0;
        for (int i : numbers) {
            if (i >= highest) {
                highest = i;
            } else if (i <= lowest) {
                lowest = i;
            }
            total += i;
        }

        total -= highest + lowest;

        return total;
    }

    // public static int oneLine(int[] numbers)
    // {
    //     return (numbers == null || numbers.length <= 2) ? 0 : IntStream.of(numbers).sum() - IntStream.of(numbers).max().getAsInt() - IntStream.of(numbers).min().getAsInt();
    // }
}