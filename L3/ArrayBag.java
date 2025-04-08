public class ArrayBag<T> implements BagInterface<T> {

    //-----------------QUESTION 1------------------------//
    // variables
    private T[] bag;
    private int DEFAULT_CAPACITY = 25;
    private int numberOFEntries;

    // constructor with given capacity
    public ArrayBag(int capacity){
        bag = (T[])new Object[capacity]; // cast to T[]
    }

    // constructor with default capacity
    public ArrayBag(){
        bag = (T[]) new Object[DEFAULT_CAPACITY]; // cast to T[]
    }

    /** Gets the current number of entries in this bag.
     @return the integer number of entries currently in the bag */
    @Override
    public int getCurrentSize() {
        return numberOFEntries;
    }

    /** Sees whether this bag is full.
     @return true if the bag is full, or false if not */
    @Override
    public boolean isFull() {
        if (numberOFEntries >= bag.length){
            return true;
        }
        return false;
    }

    /** Sees whether this bag is empty.
     @return true if the bag is empty, or false if not */
    @Override
    public boolean isEmpty() {
        if (numberOFEntries == 0){
            return true;
        }
        return false;
    }

    /** Adds a new entry to this bag.
     @param newEntry the object to be added as a new entry
     @return true if the addition is successful, or false if not */
    @Override
    public boolean add(T newEntry) {
        if (isFull()){
            return false;
        }
        bag[numberOFEntries] = newEntry;
        numberOFEntries++;

        return true;
    }

    /** Removes one unspecified entry from this bag, if possible.
     @return either the removed entry, if the removal was successful,
     or null */
    @Override
    public T remove() {
        // assume that the last entry is removed
        if (!isEmpty()){
            T result = bag[numberOFEntries-1];
            bag[numberOFEntries-1] = null;
            numberOFEntries--;
            return result;
        }
        // nothing to remove
        else {
            return null;
        }
    }

    /** Removes one occurrence of a given entry from this bag.
     @param anEntry the entry to be removed
     @return true if the removal was successful, or false if not */
    @Override
    public boolean remove(T anEntry) {
        // if the bag is empty
        if (isEmpty()){
            return false;
        }
        int counter = 0;
        int index = -1;
        while (counter < numberOFEntries){
            if (bag[counter].equals(anEntry)){
                index = counter;
                break;
            }
            counter++;
        }

        // if the entry is not found
        if (index == -1){
            return false;
        }
        // 12 3 4 5
        // if the entry found is in the last index, no replacement
        if (index == numberOFEntries-1){
            bag[index] = null;
        }
        // not the last index, replace the last entry to the index
        else{
            bag[index] = bag[numberOFEntries-1];
            bag[numberOFEntries-1] = null;
        }
        numberOFEntries--;
        return true;
    }

    /** Removes all entries from this bag. */
    @Override
    public void clear() {
        while (!isEmpty()){
            remove();
        }
    }

    /** Counts the number of times a given entry appears in this bag.
     @param anEntry the entry to be counted
     @return the number of times anEntry appears in the bag */
    @Override
    public int getFrequencyOf(T anEntry) {
        int counter = 0;
        for (int i = 0; i < numberOFEntries; i++) {
            if (bag[i].equals(anEntry)){
                counter++;
            }
        }
        return counter;
    }

    /** Tests whether this bag contains a given entry.
     @param anEntry the entry to locate
     @return true if this bag contains anEntry, or false otherwise */
    @Override
    public boolean contains(T anEntry) {
        for (int i = 0; i < numberOFEntries; i++) {
            if (bag[i].equals(anEntry)){
                return  true;
            }
        }
        return false;
    }

    /** Retrieves all entries that are in this bag.
     @return a newly allocated array of all the entries in the bag */
    @Override
    public T[] toArray() {
        T[] res = (T[]) new Object[numberOFEntries];

        for (int i = 0; i < numberOFEntries; i++) {
            res[i] = bag[i];
        }
        return res;
    }

    //-------------QUESTION 2---------------//

    public BagInterface<T> union(BagInterface<T> anotherBag){
        // size of the new Bag
        int size = getCurrentSize() + anotherBag.getCurrentSize();

        // create a unionBag
        BagInterface<T> unionBag = new ArrayBag<>(size);

        // cast the another bag to ArrayBag
        ArrayBag<T> another = (ArrayBag<T>) anotherBag;

        // add all items in current bag into the unionBag
        for (int i = 0; i < getCurrentSize(); i++) {
            unionBag.add(bag[i]);
        }

        // add all items in another bag into the unionBag
        for (int i = 0; i < anotherBag.getCurrentSize(); i++) {
            unionBag.add(another.bag[i]);
        }

        return unionBag;
    }

    //---------------QUESTION 3-------------------//
    public BagInterface<T> intersection(BagInterface<T> anotherBag){
        // create a intersectionBag with default size
        BagInterface<T> intersectionBag = new ArrayBag<>();

        // cast the another bag to ArrayBag
        ArrayBag<T> another = (ArrayBag<T>) anotherBag;

        // copy the another Bag (items will be removed)
        BagInterface<T> copyOfAnotherBag = new ArrayBag<>();
        for (int i = 0; i < another.getCurrentSize(); i++) {
            copyOfAnotherBag.add(another.bag[i]);
        }
        // BAG 1 => 1 2 3 3 4
        // BAG 2 => 3 4 6 6
        // COPY =>  4 6 6
        // INTER => 3
        // add items that shows in both bag into the intersection Bag
        for (int i = 0; i < getCurrentSize(); i++) {
            // if another bag contains this element in bag
            if (copyOfAnotherBag.contains(bag[i])){
                // add into intersectionBag
                intersectionBag.add(bag[i]);

                // remove this item from copyOfAnotherBag to prevent duplication
                copyOfAnotherBag.remove(bag[i]);
            }
        }

        return intersectionBag;
    }

    //------------------------QUESTION 4-------------------//
    public BagInterface<T> difference(BagInterface<T> anotherBag){
        // create a differenceBag with default size
        BagInterface<T> differenceBag = new ArrayBag<>();

        // cast the another bag to ArrayBag
        ArrayBag<T> another = (ArrayBag<T>) anotherBag;

        // copy this bag
        for (int i = 0; i < getCurrentSize(); i++) {
            differenceBag.add(bag[i]);
        }
        // EXPECTED RESULT => 1 4 6
        // BAG1 => 1 2 3 4
        // BAG2 => 2 3
        // DIFF => 1 4 6
        // check items with another bag
        for (int i = 0; i < another.getCurrentSize(); i++) {
            // if this bag contains the current element from another bag
            if (differenceBag.contains(another.bag[i])){
                // delete this element from differenceBag
                differenceBag.remove(another.bag[i]);
            }
        }

        return differenceBag;
    }

}
