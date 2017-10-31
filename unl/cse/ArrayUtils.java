package unl.cse;

import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    public static int subSum(List<Integer> a, int i, int j) {
        int sum = 0;
        //swaps order of indices if incorrect order
        if(i>j){
            i = i+j;
            j = i-j;
            i = i-j;
        }
        //sets i to 0 if outside array
        if(i<0){
            i = 0;
        }
        //sets j to the final index if outside array
        if(j>=a.size()){
            j = a.size()-1;
        }
        //does Maths
        for(i = i; i <= j; i++){
            sum += a.get(i);
        }
        return sum;
    }

    public static int sum(List<Integer> a) {
        //computes subSum from 0 to the size of list
        return subSum(a, 0, a.size());
    }

    public static int maxSubArraySum(List<Integer> a) {
        //initialize variables
        int max = 0, sum = 0;
        //loop through every combination of indices
        for(int i = 0; i < a.size(); i++){
            for(int j = i; j < a.size(); j++){
                //use subSum to find the sum, then check to see
                //if it is larger than current max
                sum = subSum(a, i, j);
                if(sum > max){
                    max = sum;
                }
            }
        }
        return max;
    }

    public static boolean containsWithin(List<Integer> a, int x, int i, int j) {
        //swaps order of indices if incorrect order
        if(i>j){
            i = i+j;
            j = i-j;
            i = i-j;
        }
        //sets i to 0 if outside array
        if(i<0){
            i = 0;
        }
        //sets j to the final index if outside array
        if(j>=a.size()){
            j = a.size()-1;
        }
        //check equality
        for(i = i; i <= j; i++){
            if(a.get(i) == x){
                return true;
            }
        }
        return false;
    }

    public static boolean contains(List<Integer> a, int x) {
        //runs containsWithin from beginning to end of list
        return containsWithin(a, x ,0, a.size());
    }

    public static boolean isEqual(List<Integer> a, List<Integer> b) {
        return a.equals(b);
    }

    public static boolean containsSameElements(List<Integer> a, List<Integer> b) {
        //loop through b checking if a contains the current element of b
        for(int i = 0; i < a.size(); i++){
            if(!contains(a, b.get(i))){
                return false;
            }
        }
        return true;
    }

    public static boolean isPermutation(List<Integer> a) {
        //loop from start to end of a and check if each number exists in the array
        for(int i = 0; i < a.size(); i++){
            if(!contains(a,i)){
                return false;
            }
        }
        return true;
    }

    public static List<Integer> copyArray(List<Integer> a) {
        List<Integer> b = new ArrayList<Integer>();
        for(int i = 0; i < a.size(); i++){
            b.set(i, a.get(i));
        }
        return b;
    }

    public static int orderStatistic(List<Integer> a, int k) {
        //sort into chronological order
        selectionSort(a);
        return a.get(k);
    }

    public static void selectionSort(List<Integer> a) {
        int minIndex;
        for(int i = 0; i < a.size()-1; i++){
            minIndex = i;
            for(int j = i+1; j < a.size(); j++){
                if(a.get(minIndex) > a.get(j)){
                    minIndex = j;
                }
            }
            //swap
            int t = a.get(i);
            a.set(i, a.get(minIndex));
            a.set(minIndex, t);
        }
    }

}