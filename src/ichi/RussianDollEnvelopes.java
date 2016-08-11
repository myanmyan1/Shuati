/**
 * 
 */
package ichi;

/**
 * @author kje511
 *
 */
public class RussianDollEnvelopes {

    /**
     * @param args
     */
    public static void main(String[] args) {

        int[][] env = {{2, 3}, {5, 4}, {6, 4}, {6, 7}};

        int result = maxEnvelopes(env);

        System.out.println(result);
    }

    public static int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null) {
            return 0;
        }

        // suppose sorted

        int size = envelopes.length;

        int[][] p = new int[size][size];
        for (int i = 0; i < size; i++) {
            p[i][i] = 1;
        }

        for (int i = 0; i < size - 1; i++) {
            for (int j = i + 1; j < size; j++) {

                int value = 0;
                for (int k = i; k <= j; k++) {
                    if (envelopes[i][0] < envelopes[k][0] && envelopes[i][1] < envelopes[k][1]
                            && envelopes[k][0] < envelopes[j][0] && envelopes[k][1] < envelopes[j][1]) {
                        value = Math.max(value, p[i][k] + p[k][j]);
                    } else {
                        value = Math.max(value, Math.max(p[i][k], p[k][j]));
                    }
                }
                p[i][j] = value;
            }
        }

        return p[0][size - 1];
    }
}
