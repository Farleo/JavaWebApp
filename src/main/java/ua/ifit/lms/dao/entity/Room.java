package ua.ifit.lms.dao.entity;

import java.util.Date;

public class Room {
    private long id;
    private String name;
    private String description;
    private long owner_id;
    private String room_password;
    private Date date_created;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getOwnerId() {
        return owner_id;
    }

    public void setOwnerId(long owner_id) {
        this.owner_id = owner_id;
    }

    public String getRoomPassword() {
        return room_password;
    }

    public void setRoomPassword(String room_password) {
        this.room_password = room_password;
    }

    public Date getDateCreated() {
        return date_created;
    }

    public void setDateCreated(Date date_created) {
        this.date_created = date_created;
    }

    @Override
    public String toString() {
        return "Room [name=" + name + ", description=" + description
                + ", owner=" + owner_id + ", room password=" + room_password + ", created=" + date_created + "]";
    }
}
