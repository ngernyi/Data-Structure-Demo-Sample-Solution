// 1. CompareMax class
public class CompareMax {
    // 2. create a generic static method called maximum

    // 3. generic type extends comparable
    //（inside the function the variables will need to be compared with each other）

    // Integer int1 compareTo Integer int 2
    // 4. receive 3 parameters
    public static <T extends Comparable<T>> T maximum(T a, T b, T c){
        // 5. find the maximum of 3 values

        // 5.1 assume a is the maximum
        T max = a;

        // 5.2 compare b with the max
        if (b.compareTo(max) > 0){
            max = b; // b is the largest
        }

        // 5.3 compare c with the max
        if (c.compareTo(max) > 0){
            max = c; // c is the largest
        }

        // 5.4 return maximum value
        return max;
    }

    // 6. main method for testing
    public static void main(String[] args) {
        // 6.1 Integer
        int n1 = 3;
        int n2 = 4;
        int n3 = 5;

        System.out.println("Max of "+n1+" "+n2+" "+n3+" is "+maximum(n1,n2,n3));

        // 6.2 Double
        double d1 = 1.1;
        double d2 = 2.2;
        double d3 = 3.3;

        System.out.println("Max of "+d1+" "+d2+" "+d3+" is "+maximum(d1,d2,d3));

        // 6.3 String
        String s1 = "abcd";
        String s2 = "zhhq";
        String s3 = "bzdg";

        System.out.println("Max of "+s1+" "+s2+" "+s3+" is "+maximum(s1,s2,s3));
    }

}


