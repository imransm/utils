/**
 * Created by moshaik on 6/2/2015.
 *
 * Given a positive integer n, find all combinations of representing the integer. [vmware]
 *
 * Eg: n =5,
 * combinations
 * 1+1+1+1+1
 * 1+2+2
 * 1+3+1
 * 3+2
 * 1+4
 *
 */
public class FindCombinations {

    public static void main(String[] args) {
        find(5, 0, 1, "");
    }

    static void find(int n, int curr_sum, int curr_num, String result) {
        if(curr_sum == n) {
            System.out.println(result);
        }
        else {
            // pick up only increasing numbers to avoid duplicates
            for(int i=curr_num; i<n; i++) {
                if(i+curr_sum <= n) {
                    find(n, curr_sum + i, i, result + i);
                }
            }
        }
    }
}
