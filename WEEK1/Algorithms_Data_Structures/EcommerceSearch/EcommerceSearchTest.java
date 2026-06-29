/**
 * Exercise 2: E-commerce Platform Search Function
 * Test / Driver class
 */
public class EcommerceSearchTest {

    public static void main(String[] args) {

        // ── Sample product catalogue (unsorted) ──────────────────────────────
        Product[] catalogue = {
            new Product(105, "Laptop",        "Electronics"),
            new Product(203, "Running Shoes", "Footwear"),
            new Product(10,  "Novel - Dune",  "Books"),
            new Product(310, "Coffee Maker",  "Kitchen"),
            new Product(47,  "Headphones",    "Electronics"),
            new Product(156, "Yoga Mat",      "Sports"),
            new Product(89,  "Backpack",      "Travel"),
        };

        System.out.println("=================================================");
        System.out.println("   E-Commerce Platform Search Function Demo");
        System.out.println("=================================================\n");

        // ── 1. Linear Search ─────────────────────────────────────────────────
        System.out.println("── Linear Search (unsorted array) ──");
        int[] searchIds = {47, 310, 999};   // 999 is intentionally absent

        for (int id : searchIds) {
            long start  = System.nanoTime();
            int  index  = SearchAlgorithms.linearSearch(catalogue, id);
            long elapsed = System.nanoTime() - start;

            if (index >= 0) {
                System.out.printf("  Found  : %s  [index=%d, time=%d ns]%n",
                        catalogue[index], index, elapsed);
            } else {
                System.out.printf("  NOT FOUND: productId=%d  [time=%d ns]%n",
                        id, elapsed);
            }
        }

        // ── 2. Binary Search ─────────────────────────────────────────────────
        System.out.println("\n── Binary Search (sorted array required) ──");
        Product[] sorted = SearchAlgorithms.sortById(catalogue);

        System.out.println("  Sorted catalogue:");
        for (Product p : sorted) {
            System.out.println("    " + p);
        }
        System.out.println();

        for (int id : searchIds) {
            long start   = System.nanoTime();
            int  index   = SearchAlgorithms.binarySearch(sorted, id);
            long elapsed = System.nanoTime() - start;

            if (index >= 0) {
                System.out.printf("  Found  : %s  [index=%d, time=%d ns]%n",
                        sorted[index], index, elapsed);
            } else {
                System.out.printf("  NOT FOUND: productId=%d  [time=%d ns]%n",
                        id, elapsed);
            }
        }

        // ── Analysis Summary ─────────────────────────────────────────────────
        System.out.println("\n─────────────────────────────────────────────────");
        System.out.println("  Time Complexity Comparison");
        System.out.println("─────────────────────────────────────────────────");
        System.out.println("  Algorithm       Best     Average   Worst");
        System.out.println("  Linear Search   O(1)     O(n)      O(n)");
        System.out.println("  Binary Search   O(1)     O(log n)  O(log n)");
        System.out.println();
        System.out.println("  Recommendation for large e-commerce platforms:");
        System.out.println("  → Binary Search is far more efficient at scale.");
        System.out.println("    For 1,000,000 products, binary search needs");
        System.out.println("    at most ~20 comparisons vs 1,000,000 for linear.");
        System.out.println("=================================================");
    }
}
