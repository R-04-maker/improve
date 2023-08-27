package astratech.myapplication.model;

public class Lomba {

    private String idLomba;
    private String namaLomba;
    private String gambarPoster;

    public Lomba() {
    }

    public Lomba(String idLomba, String namaLomba, String gambarPoster) {
        this.idLomba = idLomba;
        this.namaLomba = namaLomba;
        this.gambarPoster = gambarPoster;
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

    @Override
    public String toString() {
        return "Lomba{" +
                "idLomba='" + idLomba + '\'' +
                ", namaLomba='" + namaLomba + '\'' +
                ", gambarPoster='" + gambarPoster + '\'' +
                '}';
    }
}
