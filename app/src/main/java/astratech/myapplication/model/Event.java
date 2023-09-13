package astratech.myapplication.model;

public class Event {
    private String mIdEvent;
    private String mNamaEvent;

    public Event() {
    }

    public Event(String idEvent, String namaEvent) {
        mIdEvent = idEvent;
        mNamaEvent = namaEvent;
    }

    public String getIdEvent() {
        return mIdEvent;
    }

    public void setIdEvent(String idEvent) {
        mIdEvent = idEvent;
    }

    public String getNamaEvent() {
        return mNamaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        mNamaEvent = namaEvent;
    }
}
