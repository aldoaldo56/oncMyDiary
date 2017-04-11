package id.ac.umn.onc.mydiary.model;

/**
 * Created by ASUS-PC on 11/04/2017.
 */

public class Memo {
    private Integer Id;
    private Integer IdCustomer;
    private String Emotion;
    private String Note;
    private String Image;
    private String Date;

    public Memo(){}

    public Memo(Integer id, Integer idCustomer, String emotion, String note, String image, String date) {
        Id = id;
        IdCustomer = idCustomer;
        Emotion = emotion;
        Note = note;
        Image = image;
        Date = date;
    }

    public Memo(Integer idCustomer, String emotion, String note, String image, String date) {
        IdCustomer = idCustomer;
        Emotion = emotion;
        Note = note;
        Image = image;
        Date = date;
    }

    public Integer getId() {
        return Id;
    }

    public Integer getIdCustomer() {
        return IdCustomer;
    }

    public String getEmotion() {
        return Emotion;
    }

    public String getNote() {
        return Note;
    }

    public String getImage() {
        return Image;
    }

    public String getDate() {
        return Date;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public void setIdCustomer(Integer idCustomer) {
        IdCustomer = idCustomer;
    }

    public void setEmotion(String emotion) {
        Emotion = emotion;
    }

    public void setNote(String note) {
        Note = note;
    }

    public void setImage(String image) {
        Image = image;
    }

    public void setDate(String date) {
        Date = date;
    }
}
