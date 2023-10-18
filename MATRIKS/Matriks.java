public class Matriks {
    private Pecahan[][] data;
    private int baris;
    private int kolom;

    public Matriks(int baris, int kolom) {
        this.baris = baris;
        this.kolom = kolom;
        data = new Pecahan[baris][kolom];
    }

    public Matriks tambah(Matriks other) {
        if (baris != other.baris || kolom != other.kolom) {
            throw new IllegalArgumentException("Ukuran matriks tidak cocok");
        }
        Matriks hasil = new Matriks(baris, kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                int newPembilang = this.data[i][j].getPembilang() * other.data[i][j].getPenyebut()
                        + other.data[i][j].getPembilang() * this.data[i][j].getPenyebut();
                int newPenyebut = this.data[i][j].getPenyebut() * other.data[i][j].getPenyebut();
                hasil.data[i][j] = new Pecahan(newPembilang, newPenyebut);
            }
        }
        return hasil;
    }

    public Matriks kurang(Matriks other) {
        if (baris != other.baris || kolom != other.kolom) {
            throw new IllegalArgumentException("Ukuran matriks tidak cocok");
        }
        Matriks hasil = new Matriks(baris, kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                int newPembilang = this.data[i][j].getPembilang() * other.data[i][j].getPenyebut()
                        - other.data[i][j].getPembilang() * this.data[i][j].getPenyebut();
                int newPenyebut = this.data[i][j].getPenyebut() * other.data[i][j].getPenyebut();
                hasil.data[i][j] = new Pecahan(newPembilang, newPenyebut);
            }
        }
        return hasil;
    }

    public Matriks dot(Matriks other) {
        if (baris != other.baris || kolom != other.kolom) {
            throw new IllegalArgumentException("Ukuran matriks tidak cocok");
        }
        Matriks hasil = new Matriks(baris, kolom);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                int newPembilang = this.data[i][j].getPembilang() * other.data[i][j].getPembilang();
                int newPenyebut = this.data[i][j].getPenyebut() * other.data[i][j].getPenyebut();
                hasil.data[i][j] = new Pecahan(newPembilang, newPenyebut);
            }
        }
        return hasil;
    }

    public Matriks transpose() {
        Matriks hasil = new Matriks(kolom, baris);
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                hasil.data[j][i] = this.data[i][j];
            }
        }
        return hasil;
    }

    public static Matriks identitas(int ukuran) {
        Matriks identitas = new Matriks(ukuran, ukuran);
        for (int i = 0; i < ukuran; i++) {
            for (int j = 0; j < ukuran; j++) {
                if (i == j) {
                    identitas.data[i][j] = new Pecahan(1, 1);
                } else {
                    identitas.data[i][j] = new Pecahan(0, 1);
                }
            }
        }
        return identitas;
    }

    // Metode untuk mencetak matriks
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < baris; i++) {
            for (int j = 0; j < kolom; j++) {
                builder.append(data[i][j]).append("\t");
            }
            builder.append("\n");
        }
        return builder.toString();
    }
public static void main(String[] args) {
        Matriks matriks1 = new Matriks(2, 2);
        Matriks matriks2 = new Matriks(2, 2);

        matriks1.data[0][0] = new Pecahan(1, 2);
        matriks1.data[0][1] = new Pecahan(1, 3);
        matriks1.data[1][0] = new Pecahan(2, 3);
        matriks1.data[1][1] = new Pecahan(3, 4);

        matriks2.data[0][0] = new Pecahan(2, 5);
        matriks2.data[0][1] = new Pecahan(1, 2);
        matriks2.data[1][0] = new Pecahan(1, 4);
        matriks2.data[1][1] = new Pecahan(3, 7);

        Matriks hasilTambah = matriks1.tambah(matriks2);
        Matriks hasilKurang = matriks1.kurang(matriks2);
        Matriks hasilDot = matriks1.dot(matriks2);
        Matriks hasilTranspose = matriks1.transpose();

        System.out.println("Matriks 1:");
        System.out.println(matriks1);
        System.out.println("Matriks 2:");
        System.out.println(matriks2);
        System.out.println("Hasil Penjumlahan:");
        System.out.println(hasilTambah);
        System.out.println("Hasil Pengurangan:");
        System.out.println(hasilKurang);
        System.out.println("Hasil Dot (Penjumlahan Elemen):");
        System.out.println(hasilDot);
        System.out.println("Hasil Transpose:");
        System.out.println(hasilTranspose);
    }
}