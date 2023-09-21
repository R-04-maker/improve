package astratech.myapplication.model;

public class Review {

    private int idReview;
    private String namaPereview;
    private String tglReview;
    private String captionReview;
    private String gambarReview;

    private String jenisReview;

    public Review(){

    }

    public Review(int idReview, String namaPereview, String tglReview, String captionReview, String gambarReview, String jenisReview) {
        this.idReview = idReview;
        this.namaPereview = namaPereview;
        this.tglReview = tglReview;
        this.captionReview = captionReview;
        this.gambarReview = gambarReview;
        this.jenisReview = jenisReview;
    }


    public int getIdReview() {
        return idReview;
    }

    public void setIdReview(int idReview) {
        this.idReview = idReview;
    }

    public String getNamaPereview() {
        return namaPereview;
    }

    public void setNamaPereview(String namaPereview) {
        this.namaPereview = namaPereview;
    }

    public String getTglReview() {
        return tglReview;
    }

    public void setTglReview(String tglReview) {
        this.tglReview = tglReview;
    }

    public String getCaptionReview() {
        return captionReview;
    }

    public void setCaptionReview(String captionReview) {
        this.captionReview = captionReview;
    }

    public String getGambarReview() {
        return gambarReview;
    }

    public void setGambarReview(String gambarReview) {
        this.gambarReview = gambarReview;
    }

    public String getJenisReview() {
        return jenisReview;
    }

    public void setJenisReview(String jenisReview) {
        this.jenisReview = jenisReview;
    }
}
