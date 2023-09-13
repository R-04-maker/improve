package astratech.myapplication.model;

public class Orang {
    private String idOrang;
    private String namaOrang;

    public Orang() {
    }

    public Orang(String idOrang, String namaOrang) {
        this.idOrang = idOrang;
        this.namaOrang = namaOrang;
    }

    public String getIdOrang() {
        return idOrang;
    }

    public void setIdOrang(String idOrang) {
        this.idOrang = idOrang;
    }

    public String getNamaOrang() {
        return namaOrang;
    }

    public void setNamaOrang(String namaOrang) {
        this.namaOrang = namaOrang;
    }
}
