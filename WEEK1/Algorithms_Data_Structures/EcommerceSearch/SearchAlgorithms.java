import java.util.Arrays;

/**
 * Exercise 2: E-commerce Platform Search Function
 *
 * Implements two search strategies:
 *   1. Linear Search  – O(n) time, works on any array
 *   2. Binary Search  – O(log n) time, requires a sorted array
 *
 * ─── Asymptotic Notation Analysis ────────────────────────────────────────────
 *
 * Big O notation describes the upper bound on time complexity as input grows.
 *
 * LINEAR SEARCH
 *   Best case    : O(1)  – target found at index 0
 *   Average case : O(n)  – target found in the middle on average
 *   Worst case   : O(n)  – target is the last element or not present
 *
 * BINARY SEARCH
 *   Best case    : O(1)    – target is the middle element on first check
 *   Average case : O(log n)– each step halves the remaining search space
 *   Worst case   : O(log n)– target is not present; array is exhausted
 *
 * ─── Which algorithm to use? ─────────────────────────────────────────────────
 *
 * • Use Linear Search when the product catalogue is small or unsorted.
 * • Use Binary Search when the catalogue is large and kept sorted by productId.
 *   For an e-commerce platform with millions of products, binary search is
 *   drastically faster (e.g., 1 000 000 items → max 20 comparisons vs. 1 000 000).
 */
public class SearchAlgorithms {

    // ── 1. Linear Search ─────────────────────────────────────────────────────
    /**
     * Scans every element from left to right until the target productId
     * is found or the array is exhausted.
     *
     * @param products  array of Product objects (any order)
     * @param targetId  productId to search for
     * @return index of the found product, or -1 if not found
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static int linearSearch(Product[] products, int targetId) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].getProductId() == targetId) {
                return i;          // found – return index immediately
            }
        }
        return -1;                 // not found
    }

    // ── 2. Binary Search ─────────────────────────────────────────────────────
    /**
     * Searches a SORTED array by repeatedly halving the search space.
     * The array must be sorted by productId in ascending order.
     *
     * @param sortedProducts  sorted array of Product objects
     * @param targetId        productId to search for
     * @return index of the found product, or -1 if not found
     *
     * Time Complexity  : O(log n)
     * Space Complexity : O(1)
     */
    public static int binarySearch(Product[] sortedProducts, int targetId) {
        int low  = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;        // avoids integer overflow
            int midId = sortedProducts[mid].getProductId();

            if (midId == targetId) {
                return mid;                           // found
            } else if (midId < targetId) {
                low = mid + 1;                        // target is in right half
            } else {
                high = mid - 1;                       // target is in left half
            }
        }
        return -1;                                    // not found
    }

    // ── Helper: sort array by productId ──────────────────────────────────────
    /**
     * Returns a new array sorted by productId (ascending) using
     * Arrays.sort which uses a dual-pivot quicksort — O(n log n).
     */
    public static Product[] sortById(Product[] products) {
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted);           // uses Product.compareTo (productId)
        return sorted;
    }
}
