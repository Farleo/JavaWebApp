package ua.ifit.lms.dao.entity;

public class Message {
private long id;
private long user_id;
private String text;
private String date_created;


public Message(){}

public Message(long id, long user_id, String text, String date_created){
this.id=id;
this.user_id=user_id;
this.text=text;
this.date_created=date_created;
}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", user_id=" + user_id +
                ", text='" + text + '\'' +
                ", date_created='" + date_created + '\'' +
                '}';
    }
}
