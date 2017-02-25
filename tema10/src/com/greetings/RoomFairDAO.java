package com.greetings;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * The RoomFairDAO is a data-access-model
 * that connects to a postgresql db table named "room_fair"
 * via its driver and can make actions on it.
 */
public class RoomFairDAO {
    /**
     * The add method receives a RoomFair-object and adds it to
     * the according table in the db("room_fair").
     * @param roomFair
     */
    public void add(RoomFair roomFair) {
        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                PreparedStatement stm =
                        conn.prepareStatement("INSERT INTO room_fair(value, season) values(?,?)");
        ){
            stm.setFloat(1, roomFair.getValue());
            stm.setString(2, roomFair.getSeason());
            stm.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    /**
     * The getAll method returns a list which contains all the "room_fair" entries in the db
     */
    public List<RoomFair> getAll() {
        List<RoomFair> result = new LinkedList<>();

        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select value, season, id from room_fair");

        ){
            while (rs.next()) {
                RoomFair st = new RoomFair();

                st.setId(rs.getLong("id"));
                st.setValue(rs.getFloat("value"));
                st.setSeason(rs.getString("season"));

                result.add(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver").newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.err.println("Can’t load driver. Verify CLASSPATH");
            System.err.println(e.getMessage());
        }

    }

    private static Connection newConnection(String type, String host, String port, String dbName, String user,
                                            String pw) {

        loadDriver();
        DriverManager.setLoginTimeout(60); // wait 1 min; optional: DB may be
        // busy, good to set a higher
        // timeout
        try {
            String url = new StringBuilder().append("jdbc:").append(type) // “mysql”
                    // /
                    // “db2”
                    // /
                    // “mssql”
                    // /
                    // “oracle”
                    // /
                    // ...
                    .append("://").append(host).append(":").append(port).append("/").append(dbName).append("?user=")
                    .append(user).append("&password=").append(pw).toString();
            return DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.err.println("Cannot connect to the database: " + e.getMessage());
        }

        return null;
    }
}
