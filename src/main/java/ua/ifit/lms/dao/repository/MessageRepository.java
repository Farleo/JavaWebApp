package ua.ifit.lms.dao.repository;

//get and put date to database

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
        stmt.setString(3,message.getDate_created());

        System.out.println(stmt.toString());

        stmt.executeUpdate();
    }  catch (SQLException e) {
        e.printStackTrace();
    }
}


}