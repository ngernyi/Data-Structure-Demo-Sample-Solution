// Modify the program to generic class

//public class StorePair {
//    private int first, second;
//    public StorePair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//    public int getFirst() {
//        return first;
//    }
//    public int getSecond() {
//        return second;
//    }
//    public void setPair(int first, int second) {
//        this.first = first;
//        this.second = second;
//    }
//    public String toString() {
//        return "first = " + first + " second = " + second;
//    }
//}


// A) 1. Add generic to the class
//       => extends comparable (compare T and T)
//       => implements Comparable<StorePair<T>> (compare 2 StorePair objects)

// C) 1. implement the Comparable interface
public class StorePair<T extends Comparable<T>> implements Comparable<StorePair<T>>{

    // A) 2. change the int to T
    private T first, second;

    // A) 3. change the argument data type from int to T
    public StorePair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    // A) 4. change the return data type from int to T
    public T getFirst() {
        return first;
    }
    public T getSecond() {
        return second;
    }

    // A) 5. change the argument data type from int to T
    public void setPair(T first, T second) {
        this.first = first;
        this.second = second;
    }

    public String toString() {
        return "first = " + first + " second = " + second;
    }

    // B) 1. override the object equals() in the class [first values of two objects]
    @Override
    public boolean equals(Object o){

        // B) 2. Cast the argument from Object to StorePair
        StorePair<T> other = (StorePair<T>) o;

        // B) 3. compare the first value in this class and in other's class
        return this.first.equals(other.first);
    }

    // C) 1. override the compareTo() method
    @Override
    public int compareTo(StorePair<T> o){
        // C) 2. compare first element in this class and in other's class
        return this.first.compareTo(o.first);
    }

    // D) Test Program
    public static void main(String[] args) {

        // D) 1. set a b c
        StorePair<Integer> a = new StorePair<>(6,4);
        StorePair<Integer> b = new StorePair<>(2,2);
        StorePair<Integer> c = new StorePair<>(6,3);

        // E) 1. Invoke compareTo()
        System.out.println(a.compareTo(b));
        System.out.println(a.compareTo(c));
        System.out.println(b.compareTo(c));

        // E) 2. Invoke equals()
        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
        System.out.println(b.equals(c));

        System.out.println(a.toString());
        System.out.println(b.toString());
        System.out.println(c.toString());




    }


}