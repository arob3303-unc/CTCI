package ctci;

public class Chapter3 {

    // 3.1 Three stacks in one array
    // the class for this implementation.
    static class FixedMultiStack {
        private final int numberOfStacks = 3;
        private int stackCapacity;
        private int[] values;
        private int[] sizes;

        public FixedMultiStack(int stackSize) {
            this.stackCapacity = stackSize;
            this.values = new int[stackSize * this.numberOfStacks];
            this.sizes = new int[this.numberOfStacks];
        }

        // push value onto the stack
        public void push(int stackNum, int value) throws FullStackException {
            // check if we have space for next element
            if (isFull(stackNum)) {

            }
        }

    }
}
