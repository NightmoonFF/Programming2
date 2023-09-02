package Lektion3_Interfaces.Opgave4;

public class OrderLine {
    private final int lineNumber;
    private final int count;

    // association 0..* --> 1 Product
    private final Product product;

    public OrderLine(int lineNumber, int count, Product product) {
        this.lineNumber = lineNumber;
        this.count = count;
        this.product = product;
    }

    /**
     * Opgave 3 - Total pris for ordrelinje
     * @return
     */
    public double orderLinePrice(){
        double total = 0;
        total = product.getUnitPrice() * count;
        return total;
    }




    public int getLineNumber() {
        return this.lineNumber;
    }

    public int getCount() {
        return this.count;
    }

    public Product getProduct() {
        return product;
    }
}
