import java.util.*;

/**
 * Created by Imran on 10/7/2014.
 *
 * Generate sequence such that each number in sequence is of the form 2^i + 5^j. Generate numbers in increasing order.
 *
 */
public class Sequence {



    void printSequence() {
        int k = 1;
        int maxLimitK = 10;  // limit where we can stop the program.
        int i=0;  // 2 power
        int j = 0; // 5 power

        Set<Integer> generated = new TreeSet<Integer>();  // maintains sorted list of elements, doesn’t allow duplicates.

        generated.add(1); // add the first element.
        while(k < maxLimitK) {
            Set<Integer> generatedForK = new TreeSet<Integer>();
            Iterator<Integer> iterator = generated.iterator();
            while(iterator.hasNext()) {
                Integer element = iterator.next();
                Integer element2= element*2;
                Integer element5 = element*5;
                generatedForK.add(element2);
                generatedForK.add(element5);


            }  // while loop ends here.
            // Add all elements in this iteration to super set.
            generated.addAll(generatedForK);
            k++;
        }

        // Generated numbers, print collection.
        printCollection(generated);
    }

    void printCollection(Set<Integer> generated) {
        Iterator<Integer> iterator = generated.iterator();
        while(iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }
    }

    public List<Integer> generateWith(int mul, Set<Integer> generated) {
       Iterator iterator = generated.iterator();
       List<Integer> toReturn = new ArrayList<Integer>();

        while(iterator.hasNext()) {
            Integer element = (Integer)iterator.next();
            toReturn.add(element *mul);
        }
        return toReturn;
    }

    public static void main(String[] args) {
        Sequence sequence = new Sequence();
        sequence.printSequence();
    }

}
