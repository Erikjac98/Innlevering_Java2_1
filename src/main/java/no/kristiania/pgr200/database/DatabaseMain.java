package no.kristiania.pgr200.database;

import javax.swing.plaf.nimbus.State;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;

public class DatabaseMain {


    public static void createTable(String url, String sql){

        try (Connection conn = DriverManager.getConnection(url);
        Statement statement = conn.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void addTalk(String url) {

        Scanner scanner = new Scanner(System.in);
        String talkTitle = scanner.nextLine();
        int talkID = scanner.nextInt();
        String talkDescription = scanner.nextLine();
        String talkTopic = scanner.nextLine();
        int conferenceID = scanner.nextInt();


        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){
            statement.execute("INSERT INTO TABLE talks (talk_title, talk_id, talk_description, talk_topic, conference_id) \n"
                                    + "VALUES \n("  + talkID + ", " + talkTitle + ", " + talkDescription + ", " + talkTopic + ", "
                                    + conferenceID + ");");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void showTalks(String url){

        String sql = "SELECT * FROM talks";

        try (Connection conn = DriverManager.getConnection(url);
             Statement statement = conn.createStatement()){
            statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

    public static void main(String[] args){
    addTalk("dsd");
    }
}
