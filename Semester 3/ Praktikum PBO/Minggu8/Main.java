package UTS;

public class Main {
    public static void main(String[] args) {
        Mac mac1 = new Mac("Apple", 2700, 16, "M1", "Lithium Polymer", "Touch ID");
        Windows win1 = new Windows("Acer", 3200, 32, "Intel Core i5", "Lithium Ion", "Backlit Keyboard");
        Pc pc1 = new Pc("HP", 2900, 32, "Intel Core i9", 32);

        System.out.println("------------Data Mac--------------");
        mac1.tampilMac();
        System.out.println("----------------------------------");
        System.out.println("----------Data Windows------------");
        win1.tampilWindows();
        System.out.println("----------------------------------");
        System.out.println("-------------Data Pc--------------");
        pc1.tampilPc();
        System.out.println("----------------------------------");
    }
}
