package week1.arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Comparison of performance characteristics between ArrayList and LinkedList.
 * Demonstrates differences in insertion, access, and removal operations.
 */
public class ArrayListAndLinkedListObs {

    private static final int ELEMENT_COUNT = 1_000_000;
    private static final int MIDDLE_INDEX = 500_000;

    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        runBenchmarks(arrayList, linkedList);
    }

    private static void runBenchmarks(List<Integer> arrayList, List<Integer> linkedList) {
        System.out.println("=== Performance Comparison: ArrayList vs LinkedList ===\n");

        // Add elements
        benchmarkAddOperation(arrayList, linkedList);

        // Access middle element
        benchmarkAccessOperation(arrayList, linkedList);

        // Remove operations
        benchmarkRemoveOperations(arrayList, linkedList);

        // Add at end
        benchmarkAddAtEnd(arrayList, linkedList);
    }

    private static void benchmarkAddOperation(List<Integer> arrayList, List<Integer> linkedList) {
        System.out.println("--- Adding Elements ---");
        long duration = measureOperation(() -> {
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                arrayList.add(i);
            }
        });
        System.out.printf("ArrayList: %,d ns%n", duration);

        duration = measureOperation(() -> {
            for (int i = 0; i < ELEMENT_COUNT; i++) {
                linkedList.add(i);
            }
        });
        System.out.printf("LinkedList: %,d ns%n\n", duration);
    }

    private static void benchmarkAccessOperation(List<Integer> arrayList, List<Integer> linkedList) {
        System.out.println("--- Accessing Middle Element ---");
        long duration = measureOperation(() -> {
            @SuppressWarnings("unused")
            Integer unused = arrayList.get(MIDDLE_INDEX);
        });
        System.out.printf("ArrayList: %,d ns%n", duration);

        duration = measureOperation(() -> {
            @SuppressWarnings("unused")
            Integer unused = linkedList.get(MIDDLE_INDEX);
        });
        System.out.printf("LinkedList: %,d ns%n\n", duration);
    }

    private static void benchmarkRemoveOperations(List<Integer> arrayList, List<Integer> linkedList) {
        System.out.println("--- Removing Middle Element ---");
        long duration = measureOperation(() -> arrayList.remove(MIDDLE_INDEX));
        System.out.printf("ArrayList: %,d ns%n", duration);

        duration = measureOperation(() -> linkedList.remove(MIDDLE_INDEX));
        System.out.printf("LinkedList: %,d ns%n\n", duration);

        System.out.println("--- Removing First Element ---");
        duration = measureOperation(() -> arrayList.remove(0));
        System.out.printf("ArrayList: %,d ns%n", duration);

        duration = measureOperation(() -> linkedList.remove(0));
        System.out.printf("LinkedList: %,d ns%n\n", duration);

        System.out.println("--- Removing Last Element ---");
        duration = measureOperation(() -> arrayList.remove(arrayList.size() - 1));
        System.out.printf("ArrayList: %,d ns%n", duration);

        duration = measureOperation(() -> linkedList.remove(linkedList.size() - 1));
        System.out.printf("LinkedList: %,d ns%n\n", duration);
    }

    private static void benchmarkAddAtEnd(List<Integer> arrayList, List<Integer> linkedList) {
        System.out.println("--- Adding Element at End ---");
        long duration = measureOperation(() -> arrayList.add(10));
        System.out.printf("ArrayList: %,d ns%n", duration);

        duration = measureOperation(() -> linkedList.add(10));
        System.out.printf("LinkedList: %,d ns%n", duration);
    }

    /**
     * Measures the execution time of an operation in nanoseconds.
     *
     * @param operation the operation to measure
     * @return execution time in nanoseconds
     */
    private static long measureOperation(Runnable operation) {
        long start = System.nanoTime();
        operation.run();
        long end = System.nanoTime();
        return end - start;
    }
}
