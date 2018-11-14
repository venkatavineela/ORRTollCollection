public class TollGate {
    private int twoWheelerFee;
    private int fourWheelerFee;

    public TollGate(int twoWheelerFee, int fourWheelerFee) {
        this.twoWheelerFee = twoWheelerFee;
        this.fourWheelerFee = fourWheelerFee;
    }

    public int getTwoWheelerFee() {
        return twoWheelerFee;
    }

    public int getFourWheelerFee() {
        return fourWheelerFee;
    }
}
