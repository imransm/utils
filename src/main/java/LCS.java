/**
 * Created by moshaik on 11/4/2014.
 *
 * Given two strings, find the longest common subsequence.
 *
 * LCS(A[0,m], B[0, n]) =  LCS(A[0, m-1), B(0, n-1)) if (A[m] == B[n]),
 *                         else max(LCS(A[0, m-1], B[0, n]), LCS(A[0, m], B[0, n-1]))
 *
 */
public class LCS {

    public String findLCS(String a, String b) {
        if(a == null || b== null)
            return null;
        if(a.isEmpty() || b.isEmpty())
            return a;
        int m = a.length();
        int n = b.length();
        int[][] lcs = new int[m+1][n+1];
        init(m, n, lcs);
        for(int i=1; i<m+1; i++) {  // represents a
            for(int j=1; j<n+1; j++) { // represents b
                if(a.charAt(i-1) == b.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1] +1;
                } else {
                    lcs[i][j] = Math.max(lcs[i][j-1], lcs[i-1][j]);
                }
            }
        }
        // Now we have the maximum length of lcs. Now figure out the string.
        return findString(lcs, a, b);

    }

    private String findString(int[][] lcs, String a, String b) {

        // Start from bottom right, look left and top.
        int m = a.length();
        int n = b.length();
        StringBuilder buffer = new StringBuilder();
        int i=m; int j=n;
       do {
           int value = lcs[i][j];
           if(lcs[i-1][j-1] < value) {
              buffer.append(a.charAt(i-1));
               i--;
               j--;
           }
           else if(value == lcs[i-1][j]){
               i--;
           }
           else {j--;}
       } while(i >0 && j>0);
        return buffer.reverse().toString();
    }

    private void init(int m, int n, int[][] lcs) {
        for(int i =0; i<n+1; i++)
            lcs[0][i] = 0;
        for(int i=0; i<m+1;i++)
            lcs[i][0] = 0;
    }
}
