package com.greetings;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * The AccomodationDAO is a data-access-model
 * that connects to a postgresql db table named "accomodation"
 * via its driver and can make actions on it.
 */

public class AccomodationDAO {

    /**
     * The add method receives a accomodation-object and adds it to the according table in the db("accomodation").
     * @param accomodation
     */

    public void add(Accomodation accomodation) {
        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                PreparedStatement stm =
                        conn.prepareStatement("INSERT INTO accomodation(type, bed_type, max_guests, description) values(?,?,?, ?)");
        ){
            stm.setString(1, accomodation.getType());
            stm.setString(2, accomodation.getBedType());
            stm.setInt(3, accomodation.getMaxGuests());
            stm.setString(4, accomodation.getDescription());

            stm.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * The getAll method returns a list which contains all the entries in this table
     */

    public List<Accomodation> getAll() {
        List<Accomodation> result = new LinkedList<>();



        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select id, type, bed_type, max_guests, description from accomodation");

        ){



            while (rs.next()) {
                Accomodation st = new Accomodation();

                st.setId(rs.getLong("id"));
                st.setType(rs.getString("type"));
                st.setBedType(rs.getString("bed_type"));
                st.setMaxGuests(Integer.valueOf(rs.getString("max_guests")));
                st.setDescription(rs.getString("description"));

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

