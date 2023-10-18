package PECAHAN;

public class PECAHAN {
    private int pembilang;
    private int penyebut;

    public PECAHAN(int pembilang, int penyebut) {
        if (penyebut == 0) {
            throw new IllegalArgumentException("Penyebut tidak boleh nol");
        }
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public PECAHAN tambah(PECAHAN other) {
        int newPenyebut = this.penyebut * other.penyebut;
        int newPembilang = (this.pembilang * other.penyebut) + (other.pembilang * this.penyebut);
        return sederhana(newPembilang, newPenyebut);
    }

    public PECAHAN kurang(PECAHAN other) {
        int newPenyebut = this.penyebut * other.penyebut;
        int newPembilang = (this.pembilang * other.penyebut) - (other.pembilang * this.penyebut);
        return sederhana(newPembilang, newPenyebut);
    }

    public PECAHAN kali(PECAHAN other) {
        int newPembilang = this.pembilang * other.pembilang;
        int newPenyebut = this.penyebut * other.penyebut;
        return sederhana(newPembilang, newPenyebut);
    }

    public PECAHAN bagi(PECAHAN other) {
        if (other.pembilang == 0) {
            throw new IllegalArgumentException("Pembilang pembagi tidak boleh nol");
        }
        int newPembilang = this.pembilang * other.penyebut;
        int newPenyebut = this.penyebut * other.pembilang;
        return sederhana(newPembilang, newPenyebut);
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private PECAHAN sederhana(int pembilang, int penyebut) {
        int gcd = gcd(pembilang, penyebut);
        return new PECAHAN(pembilang / gcd, penyebut / gcd);
    }

    @Override
    public String toString() {
        return pembilang + "/" + penyebut;
    }

    public static void main(String[] args) {
        PECAHAN pecahan1 = new PECAHAN(1, 2);
        PECAHAN pecahan2 = new PECAHAN(3, 4);

        PECAHAN hasilTambah = pecahan1.tambah(pecahan2);
        PECAHAN hasilKurang = pecahan1.kurang(pecahan2);
        PECAHAN hasilKali = pecahan1.kali(pecahan2);
        PECAHAN hasilBagi = pecahan1.bagi(pecahan2);

        System.out.println("Hasil dari penjumlahan: " + pecahan1 + " + " + pecahan2 + " = " + hasilTambah);
        System.out.println("Hasil dari pengurangan: " + pecahan1 + " - " + pecahan2 + " = " + hasilKurang);
        System.out.println("Hasil dari perkalian: " + pecahan1 + " * " + pecahan2 + " = " + hasilKali);
        System.out.println("Hasil dari pembagian: " + pecahan1 + " / " + pecahan2 + " = " + hasilBagi);
    }
}
