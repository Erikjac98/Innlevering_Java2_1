package no.kristiania.pgr200.database;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;

public class DatabaseMain {

    public static void createTable(){

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String sql = "CREATE TABLE Conference (\n" + "conference_id integer PRIMARY KEY, \n" +
                "days integer NOT NULL, \n" + "date String NOT NULL \n" + "talk_id integer FOREIGN KEY\n" +
                ");";
        try (Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
