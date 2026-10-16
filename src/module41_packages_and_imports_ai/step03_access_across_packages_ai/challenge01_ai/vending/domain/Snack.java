// AI-Generated
package module41_packages_and_imports_ai.step03_access_across_packages_ai.challenge01_ai.vending.domain;

class Snack {
    private String name;
    private int price;
    private int count;

    Snack(String name, int price, int count) {
        this.name = name;
        this.price = price;
        this.count = count;
    }

    String getName() {
        return this.name;
    }

    public int getPrice() {
        return this.price;
    }

    public int getCount() {
        return this.count;
    }

    public boolean sell() {
        if (this.count == 0) {
            return false;
        }
        this.count--;
        return true;
    }

    void refill(int count) {
        this.count += count;
    }
}
