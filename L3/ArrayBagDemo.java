public class ArrayBagDemo {
    public static void main(String[] args) {
        // 5) C => testing

        // I. create 2 ArrayBag(type String)
        BagInterface<String> bag1 = new ArrayBag<>();
        BagInterface<String> bag2 = new ArrayBag<>();

        // II. fill in the arrayBag using testAdd
        String[] contentsOfBag1 = {"A","A","B","A","C","A",};
        String[] contentsOfBag2 = {"A","B","A","C","B","C","D","another string"};
        testAdd(bag1,contentsOfBag1);
        testAdd(bag2,contentsOfBag2);

        // III. display the items in bag1 and bag2
        displayBag(bag1);
        displayBag(bag2);

        // IV. Test the union function
        BagInterface<String> bag3 = bag1.union(bag2);
        displayBag(bag3);

        // V. Test the intersection function
        BagInterface<String> bag4 = bag1.intersection(bag2);
        displayBag(bag4);

        // VI. Test the difference function
        BagInterface<String> bag5 = bag1.difference(bag2);
        displayBag(bag5);



    }

    // 5) A => test the add function
    private static void testAdd(BagInterface<String> aBag, String[] content){
        System.out.print("Adding ");
        for (int i = 0; i < content.length; i++) {
            aBag.add(content[i]);
            System.out.print(content[i] + " ");
        }
        System.out.println();
    }

    // 5) B => display all the items in the bag
    private static void displayBag(BagInterface<String> aBag){
        System.out.println("The bag contains "+aBag.getCurrentSize()+" string(s), as follows:");

        // use toArray function to access the items inside the bag
        Object[] bagArray = aBag.toArray();

        for (int i = 0; i < bagArray.length; i++) {
            System.out.print(bagArray[i]+" ");
        }
        System.out.println();
    }

}