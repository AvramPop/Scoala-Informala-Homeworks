package com.greetings;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

/**
 * The AccomodationFairRelationDAO is a data-access-model
 * that connects to a postgresql db table named "accomodation_fair_relation"
 * via its driver and can make actions on it.
 */
public class AccomodationFairRelationDAO {
    /**
     * The add method receives a AccomodationFairRelation-object and adds it to
     * the according table in the db("accomodation_fair_relation").
     * @param accomodationFairRelation
     */
    public void add(AccomodationFairRelation accomodationFairRelation) {
        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                PreparedStatement stm =
                        conn.prepareStatement("INSERT INTO accomodation_fair_relation(id_accomodation, id_room_fair) values(?,?)");
        ){
            stm.setLong(1, accomodationFairRelation.getAccomodationId());
            stm.setLong(2, accomodationFairRelation.getRoomFairId());

            stm.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    /**
     * The getAll method returns a list which contains all the "accomodation_fair_relation" entries in the db
     */
    public List<AccomodationFairRelation> getAll() {
        List<AccomodationFairRelation> result = new LinkedList<>();

        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("select id, id_accomodation, id_room_fair from accomodation_fair_relation");
        ){
            while (rs.next()) {
                AccomodationFairRelation st = new AccomodationFairRelation();

                st.setId(rs.getLong("id"));
                st.setAccomodationId(rs.getLong("id_accomodation"));
                st.setRoomFairId(rs.getLong("id_room_fair"));

                result.add(st);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /**
     * The printWholeResultOfJoin method joins the tables of which foreign keys are memorized in this
     * table and prints the result of the join to the standard output: the room type, fair value and season.
     */
    public void printWholeResultOfJoin() {
        try (
                Connection conn = newConnection("postgresql", "localhost", "5432", "booking", "dani", "dani");
                Statement stm = conn.createStatement();
                ResultSet rs = stm.executeQuery("SELECT * \n" +
                        "FROM accomodation_fair_relation JOIN room_fair ON room_fair.id = accomodation_fair_relation.id_room_fair \n" +
                        " JOIN accomodation ON accomodation.id = accomodation_fair_relation.id_accomodation; ");
        ){
            int i = 0;
            while (rs.next()) {
                if(i % 4 == 0){
                    System.out.println(rs.getString("type"));
                }
                System.out.print(rs.getString("season") + ", ");
                System.out.println(rs.getFloat("value") + "$");
                i++;
                if(i == 4){
                    i = 0;
                }

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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

