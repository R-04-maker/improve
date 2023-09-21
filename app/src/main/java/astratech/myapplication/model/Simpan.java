package astratech.myapplication.model;

public class Simpan {

    private String idLomba;
    private String namaLomba;
    private String gambarPoster;
    private String jenisDisimpan;

    public Simpan(){

    }

    public Simpan(String idLomba, String namaLomba, String gambarPoster, String jenisDisimpan) {
        this.idLomba = idLomba;
        this.namaLomba = namaLomba;
        this.gambarPoster = gambarPoster;
        this.jenisDisimpan = jenisDisimpan;
    }

    public String getIdLomba() {
        return idLomba;
    }

    public void setIdLomba(String idLomba) {
        this.idLomba = idLomba;
    }

    public String getNamaLomba() {
        return namaLomba;
    }

    public void setNamaLomba(String namaLomba) {
        this.namaLomba = namaLomba;
    }

    public String getGambarPoster() {
        return gambarPoster;
    }

    public void setGambarPoster(String gambarPoster) {
        this.gambarPoster = gambarPoster;
    }

    public String getJenisDisimpan() {
        return jenisDisimpan;
    }

    public void setJenisDisimpan(String jenisDisimpan) {
        this.jenisDisimpan = jenisDisimpan;
    }
}
