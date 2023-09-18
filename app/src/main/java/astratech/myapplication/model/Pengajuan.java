package astratech.myapplication.model;

public class Pengajuan {

    private String idPengajuan;
    private String namaPengajuan;
    private String jenisPengajuan;
    private String tglPengajuan;

    private String status;

    public Pengajuan() {
    }

    public Pengajuan(String idPengajuan, String namaPengajuan, String jenisPengajuan, String tglPengajuan, String status) {
        this.idPengajuan = idPengajuan;
        this.namaPengajuan = namaPengajuan;
        this.jenisPengajuan = jenisPengajuan;
        this.tglPengajuan = tglPengajuan;
        this.status = status;
    }

    public String getIdPengajuan() {
        return idPengajuan;
    }

    public void setIdPengajuan(String idPengajuan) {
        this.idPengajuan = idPengajuan;
    }

    public String getNamaPengajuan() {
        return namaPengajuan;
    }

    public void setNamaPengajuan(String namaPengajuan) {
        this.namaPengajuan = namaPengajuan;
    }

    public String getJenisPengajuan() {
        return jenisPengajuan;
    }

    public void setJenisPengajuan(String jenisPengajuan) {
        this.jenisPengajuan = jenisPengajuan;
    }

    public String getTglPengajuan() {
        return tglPengajuan;
    }

    public void setTglPengajuan(String tglPengajuan) {
        this.tglPengajuan = tglPengajuan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
