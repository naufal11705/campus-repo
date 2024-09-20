public class HandPhone {
    private String noSeri, model, versiOs;
    private boolean on, mute;
    private int volume;

    public HandPhone(String noSeri, String model, String versiOs) {
        this.noSeri = noSeri;
        this.model = model;
        this.versiOs = versiOs;
        this.on = false;
        this.volume = 0;
        this.mute = false;
    }

    public void power(){
        if (on) {
            on = false;
        } else {
            on = true;
        }
    }

    public void tambahVolume(){
        if (on) {
            if (mute) {
                System.out.println("HandPhone sedang dalam keadaan Mute!");
            } else if (volume == 100){
                System.out.println("Volume sudah mencapai 100%");
            } else {
                volume += 20;
            }
        } else {
            System.out.println("Tidak bisa menambah volume!. HandPhone dalam posisi off");
        }
    }

    public void kurangVolume(){
        if (on) {
            if (mute) {
                System.out.println("HandPhone sedang dalam keadaan Mute!");
            } else if (volume == 0){
                System.out.println("Volume sudah mencapai 0%");
            } else {
                volume -= 20;
            }
        } else {
            System.out.println("Tidak bisa mengurangi volume!. HandPhone dalam posisi off");
        }
    }

    public void mute(){
        if (on) {
            if (mute == false) {
                mute = true;
                System.out.println("Memanggil Method Mute!");
            } else {
                mute = false;
                System.out.println("Memanggil Method Mute!");
            }
        } else {
            System.out.println("Tidak bisa melakukan mute!. HandPhone dalam posisi off");
        }

    }

    public void info(){
        if (on) {
            System.out.println("HandPhone dalam keadaan menyala");
        } else {
            System.out.println("HandPhone dalam keadaan mati");
        }

        if (mute) {
            System.out.println("Volume saat ini: 0%");
        } else {
            System.out.println("Volume saat ini: " + volume +"%");
        }

        if (mute) {
            System.out.println("Status mute: True");
        } else {
            System.out.println("Status mute: False");
        }
    }
}
