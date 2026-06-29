/**
 * Exercise 2: E-commerce Platform Search Function
 *
 * Product class with attributes used for searching:
 *   - productId   : unique identifier
 *   - productName : name of the product
 *   - category    : product category
 */
public class Product implements Comparable<Product> {

    private int    productId;
    private String productName;
    private String category;

    // ── Constructor ──────────────────────────────────────────────────────────
    public Product(int productId, String productName, String category) {
        this.productId   = productId;
        this.productName = productName;
        this.category    = category;
    }

    // ── Getters ──────────────────────────────────────────────────────────────
    public int    getProductId()   { return productId;   }
    public String getProductName() { return productName; }
    public String getCategory()    { return category;    }

    /**
     * Natural ordering by productId — required so the sorted array used
     * in binary search stays in a well-defined order.
     */
    @Override
    public int compareTo(Product other) {
        return Integer.compare(this.productId, other.productId);
    }

    @Override
    public String toString() {
        return String.format("Product{id=%d, name='%s', category='%s'}",
                productId, productName, category);
    }
}
