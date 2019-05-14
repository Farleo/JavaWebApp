package ua.ifit.lms.dao.repository;

import ua.ifit.lms.dao.entity.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageRepository {

    public void saveMassage(Message message){
        DataSource dataSource = new DataSource();
        try (
                Connection conn = dataSource.getConnection();
                PreparedStatement stmt =
                        conn.prepareStatement("INSERT INTO message (user_id, text, date_created) VALUES (?,?,?)")
        ) {
            stmt.setLong(1, message.getUser_id());
            stmt.setString(2, message.getText());
            stmt.setDate(3, new java.sql.Date(message.getDate_created().getTime()));

            System.out.println(stmt.toString());

            stmt.executeUpdate();
        }  catch (SQLException e) {
            e.printStackTrace();
        }
    }
}