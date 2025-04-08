
public class MinMax {

    // 1. create minmax method
    // 1.1 takes in an array of generic type
    // 1.2 returns a string
    public static <T extends Comparable<T>> String minmax(T [] arr){

        // 2. set min and max
        T min = arr[0];
        T max = arr[0];

        // 3. loop through all the elements in the arr
        for (int i = 0; i <arr.length; i++) {
            // 4. update min and max if necessary
            if (min.compareTo(arr[i]) > 0){
                min = arr[i];
            }
            if (max.compareTo(arr[i]) < 0){
                max = arr[i];
            }
        }

        // 4. Return the string
        return "Min = " + min + " Max = "+max;
    }

    // 5. testing
    public static void main(String[] args) {
        Integer[] intArr = {5, 3, 7, 1, 4, 9, 8, 2};
        String[] strArr = {"red","blue","orange","tan"};

        String intStr = minmax(intArr); //intStr = “Min = 1 Max = 9
        String str = minmax(strArr); //str= “Min = blue Max = tan

        System.out.println(intStr);
        System.out.println(str);
    }
}