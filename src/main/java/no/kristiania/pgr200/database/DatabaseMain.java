package no.kristiania.pgr200.database;

import org.flywaydb.core.Flyway;
import org.postgresql.ds.PGPoolingDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseMain {
    public static void createTable(){

        DataSource dataSource = createDataSource();

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String sql = "CREATE TABLE Conference (\n" + "conference_id integer PRIMARY KEY, \n" +
                "days integer NOT NULL, \n" + "date int NOT NULL \n" +
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
        insertInto();
        selectTable();

    }

    public static DataSource createDataSource(){
        PGPoolingDataSource dataSource = new PGPoolingDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        dataSource.setUser("gyllenhaal");
        dataSource.setPassword("admin");

        /*Flyway flyway = new Flyway();
        flyway.setDataSource(dataSource);
        flyway.setBaselineOnMigrate(true);
        flyway.setPlaceholderPrefix("%{");
        flyway.repair();
        flyway.migrate();
        */
        return dataSource;
    }

    public static void insertInto() {

        DataSource dataSource = createDataSource();

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String sql = "INSERT INTO Conference (conference_id, days, date) VALUES (1, 3, 101018 );";

        try (Connection conn = DriverManager.getConnection(url)) {
            try (Statement statement = conn.createStatement()) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void selectTable(){

        DataSource dataSource = createDataSource();

        String url = "jdbc:postgresql://localhost:5432/postgres";

        String sql = "SELECT Conference_id, days, date \n" + "FROM Conference;";

        try (Connection conn = DriverManager.getConnection(url)) {
            try (Statement statement = conn.createStatement()) {
                statement.execute(sql);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}

