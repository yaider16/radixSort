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

        int[][] sortedNums = new int[10][100];

        //This for loop is to get the first digit of each number and put it in the array sortedNums
        for (int i =0; i<MAX_NUMBERS;i++) {

            // Here I get the first digit of the number
            int digit  = Integer.parseInt(String.valueOf(String.valueOf(numsCopy[i]).charAt(0)));

            // This for loop is to find an empty space in the array to put the number
            for (int j = 0; j < 100; j++) {
                if (sortedNums[digit][j] == 0) {
                    sortedNums[digit][j] = numsCopy[i];
                    break;
                }
            }
        }


        // This for loop is to get the second digit of each number and put it in the array sortedNums
        int[][] sortedNums2 = new int[10][100];

        for (int i =0; i<10;i++) {

            // This for loop is to find an empty space in the array to put the number
            for (int j = 0; j < 100; j++) {

                // Here I get the second digit of the number and if it does not have a number I will count it as 0
                int digit =0;
                if (sortedNums[i][j]>9){
                    digit = Integer.parseInt(String.valueOf(String.valueOf(numsCopy[i]).charAt(1)));
                }

                // Here I put the number in the array
                if (sortedNums2[digit][j] == 0) {
                    sortedNums2[digit][j] = sortedNums[i][j];
                    break;
                }
            }
        }

        // This for loop is to get the third digit of each number and put it in the array sortedNums

        int[][] sortedNums3 = new int[10][100];

        for (int i =0; i<10;i++) {

            // This for loop is to find an empty space in the array to put the number
            for (int j = 0; j < 100; j++) {

                // Here I get the third digit of the number and if it does not have a number I will count it as 0
                int digit =0;
                if (sortedNums2[i][j]>99){
                    digit = Integer.parseInt(String.valueOf(String.valueOf(numsCopy[i]).charAt(2)));
                }

                // Here I put the number in the array
                if (sortedNums3[digit][j] == 0) {
                    sortedNums3[digit][j] = sortedNums2[i][j];
                    break;
                }
            }
        }

        // This for loop is to get the fourth digit of each number and put it in the array sortedNums

        int[][] sortedNums4 = new int[10][100];

        for (int i =0; i<10;i++) {

            // This for loop is to find an empty space in the array to put the number
            for (int j = 0; j < 100; j++) {

                // Here I get the fourth digit of the number and if it does not have a number I will count it as 0
                int digit =0;
                if (sortedNums3[i][j]>999){
                    digit = Integer.parseInt(String.valueOf(String.valueOf(numsCopy[i]).charAt(3)));
                }

                // Here I put the number in the array
                if (sortedNums4[digit][j] == 0) {
                    sortedNums4[digit][j] = sortedNums3[i][j];
                    break;
                }
            }
        }

        // This for loop is to put everything into a one dimensional array
        int count =0;
        for (int i =0; i<10;i++) {
            for (int j = 0; j < 100; j++) {
                if (sortedNums4[i][j] != 0) {
                    numsCopy[count] = sortedNums4[i][j];
                    count++;
                }
            }
        }
        return numsCopy;
    }
}