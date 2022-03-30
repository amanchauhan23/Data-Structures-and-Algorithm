public class validateStackSequence {

    public static boolean validateStackSequences(int[] pushed, int[] popped) {

        // #1 O(n) | auxSpace O(n)
        // Stack<Integer> stack = new Stack<>();
        // int j = 0;
        // for (int i = 0; i < pushed.length; i++) {
        // stack.push(pushed[i]);
        // while (!stack.isEmpty() && stack.peek() == popped[j]) {
        // j++;
        // stack.pop();
        // }
        // }
        // return stack.isEmpty();

        // #2 O()
        int j = 0, k = 0, n = pushed.length;
        for (int i = 0; i < n; i++) { // // O(n) | auxSpace O(1) // modify the given array, i.e. pushed

            pushed[k++] = pushed[i];
            while (k > 0 && popped[j] == pushed[k - 1]) {
                j++;
                k--;
            }

        }
        return j == n;
    }

    public static void main(String[] args) {

    }
}
