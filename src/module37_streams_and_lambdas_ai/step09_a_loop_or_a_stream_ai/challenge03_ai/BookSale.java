// AI-Generated
package module37_streams_and_lambdas_ai.step09_a_loop_or_a_stream_ai.challenge03_ai;

public class BookSale {
    private String title;
    private int copies;
    private int price;

    public BookSale(String title, int copies, int price) {
        this.title = title;
        this.copies = copies;
        this.price = price;
    }

    public String getTitle() {
        return this.title;
    }

    public int getCopies() {
        return this.copies;
    }

    public int getPrice() {
        return this.price;
    }

    public int total() {
        return this.copies * this.price;
    }
}
