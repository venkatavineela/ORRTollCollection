public class TollGate {
    int number;
    private int twoWheelerFee;
    private int fourWheelerFee;

    public TollGate(int number,int twoWheelerFee, int fourWheelerFee) {
        this.number = number;
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
