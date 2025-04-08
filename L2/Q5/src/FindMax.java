// 1. create a class called FindMax
public class FindMax {

    // 2. Create a Circle class that uses comparable interface
    static class Circle implements Comparable<Circle> {
        // 3. declare radius variable
        double radius;

        // 4. single parameterized constructor
        Circle(double radius){
            this.radius = radius;
        }

        // 7. override the compareTo method
        @Override
        public int compareTo(Circle c){
            if (radius < c.radius){
                return -1;
            } else if (radius == c.radius) {
                return 0;
            }
            else {
                return 1;
            }
        }

//         8. override toString method
        @Override
        public String toString() {
            return "Circle radius : " + radius;
        }
    }

    // 5. main program
    public static void main(String[] args) {
        // 5.1 array of Integers
        Integer [] arrInt = {1,2,3};
        System.out.println(max(arrInt));

        // 5.2 array of String
        String [] arrStr = {"red","green","blue"};
        System.out.println(max(arrStr));

        // 5.3 array of circle
        Circle [] arrCircle = {new Circle(3),new Circle(2.9),new Circle(5.9)};
        System.out.println(max(arrCircle));
    }

    // common function (no generic)
    public static void min(Integer [] list){
        int result = list[0].compareTo(list[1]);

    }

    // 6. Max Method
    public static <T extends Comparable<T>> T max(T[] list){
        // 6.1 set max
        T max = list[0];

        // Integer [] list
        // String [] list
        // Circle [] list
        Integer a = 9;
        Integer b = 8;
        int resultInt = a.compareTo(b);

        String aStr = "a";
        String bStr = "b";
        int resultStr = aStr.compareTo(bStr);

        Circle circleA = new Circle(2);
        Circle circleB = new Circle(1);
        int resultCircle = circleA.compareTo(circleB);

        for (int i = 0; i < list.length; i++) {
            if (max.compareTo(list[i])<0){
                max = list[i];
            }
        }
        return max;
    }
}