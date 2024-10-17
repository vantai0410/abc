package handling_fractions_program_w7;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do {
            System.out.println("nhap so luong phan so (>0): ");
            while (!scanner.hasNextInt()) {
                System.out.print("vui long nhap so nguyen duong: ");
                scanner.next();
            }
            n = scanner.nextInt();
        } while (n <= 0);
        List<Fractions> listFraction = Fractions.generateRandomFractions(n);
        System.out.println("danh sach phan so ngau nhien: ");
//        for (Fractions f : listFraction) {
//            System.out.println(f);
//        }
        display(listFraction);
        Collections.sort(listFraction, new Comparator<Fractions>() {

            @Override
            public int compare(Fractions o1, Fractions o2) {
                double so1 = (double) o1.getTuSo() / o1.getMauSo();
                double so2 = (double) o2.getTuSo() / o2.getMauSo();
                                return Double.compare(so1, so2);
            }
        });
        System.out.println("danh sach sau khi sap xep: ");
//        for (Fractions f : listFraction) {
//            System.out.println(f);
//        }
        display(listFraction);



        Fractions sum = new Fractions(0, 1);
        for (Fractions fr : listFraction) {
            sum = sum.add(fr);
        }
        System.out.println("tong cac phan so: " + sum);

    }
    public static void display(List<Fractions> listFraction) {
        for (Fractions f : listFraction) {
            System.out.print(f +" ");
        }
        System.out.println();
    }
}
