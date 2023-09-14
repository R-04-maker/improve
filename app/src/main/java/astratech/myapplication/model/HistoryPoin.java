package astratech.myapplication.model;

public class HistoryPoin {
    private int idHistoryPoin;
    private String namaKegiatan;
    private String tanggalKegiatan;
    private int jumlahPoin;

    public HistoryPoin(){

    }

    public HistoryPoin(int idHistoryPoin, String namaKegiatan, String tanggalKegiatan, int jumlahPoin) {
        this.idHistoryPoin = idHistoryPoin;
        this.namaKegiatan = namaKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
        this.jumlahPoin = jumlahPoin;
    }

    public int getIdHistoryPoin() {
        return idHistoryPoin;
    }

    public void setIdHistoryPoin(int idHistoryPoin) {
        this.idHistoryPoin = idHistoryPoin;
    }

    public String getNamaKegiatan() {
        return namaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        this.namaKegiatan = namaKegiatan;
    }

    public String getTanggalKegiatan() {
        return tanggalKegiatan;
    }

    public void setTanggalKegiatan(String tanggalKegiatan) {
        this.tanggalKegiatan = tanggalKegiatan;
    }

    public int getJumlahPoin() {
        return jumlahPoin;
    }

    public void setJumlahPoin(int jumlahPoin) {
        this.jumlahPoin = jumlahPoin;
    }
}
