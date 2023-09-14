package astratech.myapplication.model;

public class HistoryXP {

    private int idHistoryXP;
    private String namaKegiatan;
    private String tanggalKegiatan;
    private int jumlahXP;

    public HistoryXP(){

    }

    public HistoryXP(int idHistoryXP, String namaKegiatan, String tanggalKegiatan, int jumlahXP) {
        this.idHistoryXP = idHistoryXP;
        this.namaKegiatan = namaKegiatan;
        this.tanggalKegiatan = tanggalKegiatan;
        this.jumlahXP = jumlahXP;
    }


    public int getIdHistoryXP() {
        return idHistoryXP;
    }

    public void setIdHistoryXP(int idHistoryXP) {
        this.idHistoryXP = idHistoryXP;
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

    public int getJumlahXP() {
        return jumlahXP;
    }

    public void setJumlahXP(int jumlahXP) {
        this.jumlahXP = jumlahXP;
    }
}
