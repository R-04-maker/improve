package astratech.myapplication.model;

public class Notifikasi {

    private String idNotifikasi;
    private String namaNotifikasi;
    private String jenisNotifikasi;
    private String deskripsiNotifikasi;
    private String waktuNotifikasi;

    public Notifikasi(){

    }

    public Notifikasi(String idNotifikasi, String namaNotifikasi, String jenisNotifikasi, String deskripsiNotifikasi, String waktuNotifikasi) {
        this.idNotifikasi = idNotifikasi;
        this.namaNotifikasi = namaNotifikasi;
        this.jenisNotifikasi = jenisNotifikasi;
        this.deskripsiNotifikasi = deskripsiNotifikasi;
        this.waktuNotifikasi = waktuNotifikasi;
    }

    public String getIdNotifikasi() {
        return idNotifikasi;
    }

    public void setIdNotifikasi(String idNotifikasi) {
        this.idNotifikasi = idNotifikasi;
    }

    public String getNamaNotifikasi() {
        return namaNotifikasi;
    }

    public void setNamaNotifikasi(String namaNotifikasi) {
        this.namaNotifikasi = namaNotifikasi;
    }

    public String getJenisNotifikasi() {
        return jenisNotifikasi;
    }

    public void setJenisNotifikasi(String jenisNotifikasi) {
        this.jenisNotifikasi = jenisNotifikasi;
    }

    public String getDeskripsiNotifikasi() {
        return deskripsiNotifikasi;
    }

    public void setDeskripsiNotifikasi(String deskripsiNotifikasi) {
        this.deskripsiNotifikasi = deskripsiNotifikasi;
    }

    public String getWaktuNotifikasi() {
        return waktuNotifikasi;
    }

    public void setWaktuNotifikasi(String waktuNotifikasi) {
        this.waktuNotifikasi = waktuNotifikasi;
    }
}
