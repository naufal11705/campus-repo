public class DemoHP {
    public static void main(String[] args) {
        HandPhone hp1 = new HandPhone("21308219", "Model A", "Android 14");

        System.out.println("Pertanyaan nomor 2 --------------------------------------");
        hp1.info();

        System.out.println();

        System.out.println("Pertanyaan nomor 3 --------------------------------------");
        hp1.info();
        hp1.tambahVolume();

        System.out.println();

        System.out.println("Pertanyaan nomor 4 --------------------------------------");
        hp1.power();
        hp1.info();
        hp1.tambahVolume();
        hp1.tambahVolume();
        hp1.tambahVolume();
        hp1.tambahVolume();
        hp1.tambahVolume();
        hp1.tambahVolume();

        System.out.println();

        System.out.println("Pertanyaan nomor 5 --------------------------------------");
        hp1.kurangVolume();
        hp1.kurangVolume();
        hp1.kurangVolume();
        hp1.kurangVolume();
        hp1.kurangVolume();
        hp1.info();
        hp1.kurangVolume();
        System.out.println();

        System.out.println("Pertanyaan nomor 6 --------------------------------------");
        hp1.tambahVolume();
        hp1.tambahVolume();
        hp1.info();
        System.out.println();

        hp1.mute();

        System.out.println();
        hp1.info();
        System.out.println();

        System.out.println("Pertanyaan nomor 7 --------------------------------------");

        hp1.info();
        System.out.println();

        hp1.mute();

        System.out.println();
        hp1.info();

    }
}