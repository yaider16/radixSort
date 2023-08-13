import java.util.Random;

public class Main {
    public static int MAX_NUMBERS = 1000;
    public static int[] nums = new int[MAX_NUMBERS];


    public static void main(String[] args) {

        // Algorithm to create 1000 random numbers between 1 and 1000 and without repetition
        Random random = new Random();

        for (int i =0; i<MAX_NUMBERS;i++){
            nums[i] = random.nextInt(MAX_NUMBERS)+1;
            for (int g=0;g<MAX_NUMBERS;g++){
                if(g!=i){
                    while(nums[i]==nums[g]) {
                        nums[i] = random.nextInt(MAX_NUMBERS)+1;
                        g = 0;
                     }
                 }
            }
        }

        int[] sortedArr = radixSort();
        // print the sorted array
        for (int i =0; i<MAX_NUMBERS;i++){
            System.out.println(sortedArr[i]);
        }
        //System.arraycopy(nums, 0, numsCopy, 0, nums.length);
    }

    public static int[] radixSort(){
        // radix sort algorithm
        int[] numsCopy = new int[MAX_NUMBERS];
        System.arraycopy(nums, 0, numsCopy, 0, nums.length);
        int[] sortedArr = new int[MAX_NUMBERS];
        int[] count = new int[10];
        int[] temp = new int[MAX_NUMBERS];
        int digit = 1;
        int radix = 10;
        int max = numsCopy[0];
        int min = numsCopy[0];


        for (int i = 1; i < MAX_NUMBERS; i++) {
            if (numsCopy[i] > max)
                max = numsCopy[i];
            if (numsCopy[i] < min)
                min = numsCopy[i];
        }

        int maxDigit = (int) Math.log10(max);
        int minDigit = (int) Math.log10(min);
        int maxDigits = Math.max(maxDigit, minDigit);

        for (int i = 0; i < maxDigits + 1; i++) {
            for (int j = 0; j < radix; j++) {
                count[j] = 0;
            }
            for (int j = 0; j < MAX_NUMBERS; j++) {
                int subArr = (numsCopy[j] / digit) % radix;
                count[subArr]++;
            }
            for (int j = 1; j < radix; j++) {
                count[j] += count[j - 1];
            }
            for (int j = MAX_NUMBERS - 1; j >= 0; j--) {
                int subArr = (numsCopy[j] / digit) % radix;
                temp[count[subArr] - 1] = numsCopy[j];
                count[subArr]--;
            }
            System.arraycopy(temp, 0, numsCopy, 0, MAX_NUMBERS);
            digit *= 10;
        }
        System.arraycopy(numsCopy, 0, sortedArr, 0, MAX_NUMBERS);
        return sortedArr;
    }
}