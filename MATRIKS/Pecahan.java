class Pecahan{
    private int pembilang;
    private int penyebut;

    public Pecahan(int pembilang, int penyebut) {
        if (penyebut == 0) {
            throw new IllegalArgumentException("Penyebut tidak boleh nol");
        }
        this.pembilang = pembilang;
        this.penyebut = penyebut;
    }

    public int getPembilang() {
        return pembilang;
    }

    public int getPenyebut() {
        return penyebut;
    }

    @Override
    public String toString() {
        return pembilang + "/" + penyebut;
    }
}
