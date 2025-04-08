// 1. create a generic class called MyGeneric
public class MyGeneric<E> {

    // 2. declare a variable called e
    private E e;

    // 3. create no arg constructor
    MyGeneric(){

    }

    // 4. create a constructor that accepts generic parameter
    MyGeneric(E e){
        this.e = e;
    }

    // 5. setter for e
    public void setE(E e) {
        this.e = e;
    }

    // 6. getter for e
    public E getE() {
        return e;
    }

    // 7. test program
    public static void main(String[] args) {
        // 8. create instances of generic class of type String and Int
        MyGeneric<String> strObj = new MyGeneric<>();
        MyGeneric<Integer> intObj = new MyGeneric<>();

        // 9. set a value for the objects using setter
        strObj.setE("Haloo");
        intObj.setE(12313);

        // 10. display the value using getter
        System.out.println(strObj.getE());
        System.out.println(intObj.getE());
    }
}