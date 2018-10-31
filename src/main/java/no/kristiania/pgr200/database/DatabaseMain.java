package no.kristiania.pgr200.database;

import org.postgresql.ds.PGPoolingDataSource;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import javax.sql.DataSource;



public class DatabaseMain {
    public static void createTable(){

        DataSource dataSource = createDataSource();

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String sql = "CREATE TABLE Conference (\n" + "conference_id integer PRIMARY KEY, \n" +
                "days integer NOT NULL, \n" + "date integer NOT NULL \n" +
                ");";
        try (Connection conn = DriverManager.getConnection(url)) {
            try (Statement statement = conn.createStatement()) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args){
        createTable();
    }

    public static DataSource createDataSource(){
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUser("gyllenhaal");
        dataSource.setPassword("admin");

        return dataSource;
    }
}
