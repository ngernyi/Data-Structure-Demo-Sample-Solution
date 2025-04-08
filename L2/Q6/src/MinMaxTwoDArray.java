// 1. create a class called MinMaxTwoDArray
public class MinMaxTwoDArray  {

    // A) 1. min method to return minimum element in 2D Array
    public static <T extends Comparable<T>> T min (T [][] list){
        // A) 2. set min
        T min = list[0][0];

        // A) 3. loop through all the elements in the 2D array
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (min.compareTo(list[i][j]) > 0){
                    min = list[i][j];
                }
            }
        }
        return min;
    }

    // B) 1. max method to return minimum element in 2D Array
    public static <T extends Comparable<T>> T max (T [][] list){
        // A) 2. set max
        T max = list[0][0];

        // A) 3. loop through all the elements in the 2D array
        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[0].length; j++) {
                if (max.compareTo(list[i][j]) < 0){
                    max = list[i][j];
                }
            }
        }
        return max;
    }

    // C) 1. Test
    public static void main(String[] args) {
        // C) 2. create 2d array
        Integer [][] arr = {{4,5,6},
                            {1,2,3}};
        // C) 3. print max and min
        System.out.println("Max = "+max(arr));
        System.out.println("Min = "+min(arr));
    }
}

// 1) T extends Comparable<T>
//  => in the method, T object will compareTo another T object
//  T obj1, T obj2 => obj1.compareTo(obj2)
//  make sure that the T object will have compareTo function in their class

// 2) implement Comparable<Obj<T>>
// => Obj<T> compareTo Obj<T>
//