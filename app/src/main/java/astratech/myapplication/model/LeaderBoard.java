package astratech.myapplication.model;

public class LeaderBoard {

    private int idLeaderBoard;
    private String namaOrang;
    private int jumlahXP;

    public LeaderBoard() {
    }

    public LeaderBoard(int idLeaderboard, String namaLomba, int jumlahXP) {
        this.idLeaderBoard = idLeaderboard;
        this.namaOrang = namaLomba;
        this.jumlahXP = jumlahXP;
    }

    public int getIdLeaderBoard() {
        return idLeaderBoard;
    }

    public void setIdLeaderBoard(int idLeaderBoard) {
        this.idLeaderBoard = idLeaderBoard;
    }

    public String getNamaOrang() {
        return namaOrang;
    }

    public void setNamaOrang(String namaOrang) {
        this.namaOrang = namaOrang;
    }

    public int getJumlahXP() {
        return jumlahXP;
    }

    public void setJumlahXP(int jumlahXP) {
        this.jumlahXP = jumlahXP;
    }

    @Override
    public String toString() {
        return "LeaderBoard{" +
                "idLeaderboard='" + idLeaderBoard + '\'' +
                ", namaOrang='" + namaOrang + '\'' +
                ", jumlahXP='" + jumlahXP + '\'' +
                '}';
    }
}
