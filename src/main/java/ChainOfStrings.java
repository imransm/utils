import java.util.*;

/**
 * Created by Imran on 11/11/2014.
 * Given an array of strings, find if the strings can be chained to form a circle.
 * Example1: {"for", "geek", "rig", "kaf"}
 * Yes, chain is: for, rig, geek, kaf
 * Example2: {"aab", "bac", "aaa", "cda"}
 * Yes, chain is: aab, bac, cda, aaa
 *
 * This is actually equivalent to finding euler circuits.
 *
 */
public class ChainOfStrings {

    private List<String> chain;
    public boolean isChain(String[] stringList) {
        chain = new ArrayList<String>();
        if(stringList == null || stringList.length == 0)
            return true;
        ArrayList<String> currentChain = new ArrayList<String>();
        currentChain.add(stringList[0]);
        findChain(stringList, currentChain, stringList[0].charAt(stringList[0].length() - 1));
        return chain.size() == stringList.length;
    }

    private void findChain(String[] stringList, ArrayList<String> currentChain, char nextChar) {
        if(currentChain.size() == stringList.length ) {
            if(chain.size() == 0)
            copyCurrentChain(currentChain, chain);
            return;
        }

        List<String> allSuitableStrings = findAllNextWith(stringList, currentChain, nextChar);
        if(allSuitableStrings != null && allSuitableStrings.size() > 0) {
            for(String s: allSuitableStrings) {
                // Bad approach to avoid list clone.
                currentChain.add(s);
                findChain(stringList, currentChain, s.charAt(s.length() - 1));
                currentChain.remove(s);
            }
        }
    }

    private void copyCurrentChain(ArrayList<String> currentChain, List<String> chain) {
        for(String s : currentChain) {
            chain.add(s);
        }
    }

    List<String> findAllNextWith(String[] stringList, List<String> pickedUp, char c) {
       List<String> result = new ArrayList<String>();
       for(String s : stringList) {
           if(s.charAt(0) == c && !pickedUp.contains(s))
               result.add(s);
       }
       return result;
   }
    public List<String> getChain() {
        return chain;
    }

}
