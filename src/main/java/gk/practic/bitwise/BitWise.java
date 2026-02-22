package gk.practic.bitwise;

public class BitWise {
    public static void main(String[] args) {
        BitWise app = new BitWise();
        int a = 11;
//        System.out.println(a >> 1);// Right shift(/2)
//        System.out.println(a << 1); // Left shift(*2)
//        System.out.println(app.isEven(a));
//        app.swap(11, 17);
//        System.out.println(app.iThBitSet(a, 1));
        System.out.println(app.powerOfTwo(a));
        System.out.println(app.powerOfTwo(16));
        System.out.println(app.countSetBits(a));
        System.out.println(app.countSetBits(0));
        System.out.println(app.countSetBits(9));
        System.out.println(app.getIthBit(9, 2));
        System.out.println(app.getIthBit(9, 0));
        int ithBit = app.setIthBit(9, 1);
        System.out.println(ithBit);
    }

    private int countSetBits(int a) {
        int bitSet = 0;
        while (a > 0) {
            a = a & (a-1);
            bitSet++;
        }
        return bitSet;
    }

    int getIthBit(int num, int i) {
        return (num & (1 << i)) == 0 ? 0 : 1;
    }

    private boolean powerOfTwo(int a) {
        return (a & (a-1)) == 0;
    }

    public boolean isEven(int num) {
        return (num & 1) == 0;
    }

    public boolean iThBitSet(int num, int i) {
        return (num & (1 << i)) == 1;
    }

    public int setIthBit(int num, int i) {
        return num | (1 << i);
    }

    public void swap(int num1, int num2) {
        System.out.println("BEFORE Swap num1: " + num1 + " and num2:" + num2);
        num1 ^= num2;
        num2 ^= num1;
        num1 ^= num2;
        System.out.println("After Swap num1: " + num1 + " and num2:" + num2);
    }
}
