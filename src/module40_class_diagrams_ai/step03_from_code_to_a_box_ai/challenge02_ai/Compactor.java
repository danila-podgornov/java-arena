// AI-Generated
package module40_class_diagrams_ai.step03_from_code_to_a_box_ai.challenge02_ai;

public class Compactor {
    private int cansPerBlock;
    private int cans;
    private int blocks;

    public Compactor() {
        this(50);
    }

    public Compactor(int cansPerBlock) {
        this.cansPerBlock = cansPerBlock;
        this.cans = 0;
        this.blocks = 0;
    }

    public void load(int cans) {
        if (this.cans + cans <= 150) {
            this.cans += cans;
        }
    }

    public int press() {
        if (this.blocksReady() == 0) {
            return 0;
        }
        this.blocks++;
        this.cans -= this.cansPerBlock;
        return this.cansPerBlock;
    }

    public int getBlocks() {
        return this.blocks;
    }

    @Override
    public String toString() {
        return this.blocks + " blocks, " + this.cans + " cans waiting";
    }

    private int blocksReady() {
        return this.cans / this.cansPerBlock;
    }
}
