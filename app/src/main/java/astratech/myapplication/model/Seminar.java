package astratech.myapplication.model;

public class Seminar {
    private String idSeminar;
    private String namaSeminar;
    private String gambarPoster;

    public Seminar() {
    }

    public Seminar(String idSeminar, String namaSeminar, String gambarPoster) {
        this.idSeminar = idSeminar;
        this.namaSeminar = namaSeminar;
        this.gambarPoster = gambarPoster;
    }

    public String getIdSeminar() {
        return idSeminar;
    }

    public void setIdSeminar(String idSeminar) {
        this.idSeminar = idSeminar;
    }

    public String getNamaSeminar() {
        return namaSeminar;
    }

    public void setNamaSeminar(String namaSeminar) {
        this.namaSeminar = namaSeminar;
    }

    public String getGambarPoster() {
        return gambarPoster;
    }

    public void setGambarPoster(String gambarPoster) {
        this.gambarPoster = gambarPoster;
    }

    @Override
    public String toString() {
        return "Seminar{" +
                "idSeminar='" + idSeminar + '\'' +
                ", namaSeminar='" + namaSeminar + '\'' +
                ", gambarPoster='" + gambarPoster + '\'' +
                '}';
    }
}
