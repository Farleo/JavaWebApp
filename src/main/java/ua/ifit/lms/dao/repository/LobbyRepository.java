package ua.ifit.lms.dao.repository;

import ua.ifit.lms.dao.entity.Room;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class LobbyRepository {

    public List<Room> getPublicRooms() {

        DataSource dataSource = new DataSource();

        String query = "SELECT id, name, description, owner_id, room_password, date_created FROM room";

        try (
                // get connection with our database
                Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
        )
        {
            List<Room> roomList = new ArrayList<>();
            if (resultSet.next())  {
                Room room =  new Room();
                room.setId(resultSet.getLong("id"));
                room.setName(resultSet.getString("name"));
                room.setDescription(resultSet.getString("description"));
                room.setOwnerId(resultSet.getLong("owner_id"));
                room.setRoomPassword(resultSet.getString("room_password"));
                room.setDateCreated(resultSet.getDate("date_created"));
                roomList.add(room);
            }

            return roomList;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}