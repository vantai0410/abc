package handling_fractions_program_w7;

import java.util.ArrayList;
import java.util.Random;

public class Fractions {
    private int tuSo;
    private int mauSo;

    public Fractions() {
        tuSo = 0;
        mauSo = 1;
    }

    public Fractions(int tuSo, int mauSo) {
        if (mauSo == 0) {
            System.out.println("Mau so khong duoc bang 0");
            tuSo = 0;
            mauSo = 1;
        } else {
            this.tuSo = tuSo;
            this.mauSo = mauSo;
        }
    }

    public int getTuSo() {
        return tuSo;
    }

    public void setTuSo(int tuSo) {
        this.tuSo = tuSo;
    }

    public int getMauSo() {
        return mauSo;
    }

    public void setMauSo(int mauSo) {
        this.mauSo = mauSo;
    }

    public Fractions add(Fractions ps2) {
        int ts = tuSo * ps2.mauSo + ps2.tuSo * mauSo;
        int ms = mauSo * ps2.mauSo;
        return new Fractions(ts, ms);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    private Fractions simpleFraction(int tuSo, int mauSo) {
        int gcd = gcd(tuSo, mauSo);
        return new Fractions(tuSo/gcd,mauSo/gcd);
    }
    public static ArrayList<Fractions> generateRandomFractions(int n) {
        ArrayList<Fractions> fractions = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            int numerator = random.nextInt(10) + 1;
            int denominator = random.nextInt(10) + 1;
            fractions.add(new Fractions(numerator, denominator));
        }

        return fractions;
    }

    @Override
    public String toString() {
        return  tuSo + "/" + mauSo;
    }
}
