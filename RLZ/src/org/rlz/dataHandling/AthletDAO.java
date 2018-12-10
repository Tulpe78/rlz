package org.rlz.dataHandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rlz.dataModel.Athlet;

public class AthletDAO {

	public static List<Athlet> selectAthlet(Connection conn) throws SQLException {
        String sql = "SELECT id, last_name, first_name, year, gender,contact_id, club_id  FROM athletes";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Athlet> list = new ArrayList<Athlet>();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String lastName = rs.getString("last_name");
            String firstName = rs.getString("first_name");
            int year = rs.getInt("year");
            String gender = rs.getString("gender");
            int contactId = rs.getInt("contact_id");
            int clubId = rs.getInt("club_id");
   
            Athlet athlet = new Athlet(id, lastName, firstName, year, gender, contactId, clubId);
      
            list.add(athlet);
        }
        return list;
    }
	
	public static List<Athlet> selectMyAthlet(Connection conn, String userName) throws SQLException {
        String sql = "SELECT a.id, a.last_name, a.first_name, a.year, a.gender, a.contact_id, a.club_id  "
        		     + "FROM athletes a "
        		     + "INNER JOIN user_athletes ua ON a.id = ua.athlet_id"  
        		     +" WHERE ua.user_name = '"+userName+"'";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Athlet> list = new ArrayList<Athlet>();
        
        while (rs.next()) {
            int id = rs.getInt("id");
            String lastName = rs.getString("last_name");
            String firstName = rs.getString("first_name");
            int year = rs.getInt("year");
            String gender = rs.getString("gender");
            int contactId = rs.getInt("contact_id");
            int clubId = rs.getInt("club_id");
   
            Athlet athlet = new Athlet(id, lastName, firstName, year, gender, contactId, clubId);
      
            list.add(athlet);
        }
        return list;
    }
 
    public static Athlet findAthlet(Connection conn, int idIn) throws SQLException {
        String sql = "SELECT id, last_name, first_name, year, gender,contact_id, club_id FROM athletes WHERE id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            int id = rs.getInt("id");
            String lastName = rs.getString("last_name");
            String firstName = rs.getString("first_name");
            int year = rs.getInt("year");
            String gender = rs.getString("gender");
            int contactId = rs.getInt("contact_id");
            int clubId = rs.getInt("club_id");

            Athlet athlet = new Athlet(id, lastName, firstName, year, gender, contactId, clubId);
            return athlet;
        }
        return null;
    }
 
    public static void insertAthlet(Connection conn, Athlet athlet) throws SQLException {
        String sql = "INSERT INTO athletes(last_name, first_name, year, gender, contact_id, club_id) "
        		   + "VALUES (?,?,?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setString(1, athlet.getLastName());
        pstm.setString(2, athlet.getFirstName());
        pstm.setInt(3, athlet.getYear());
        pstm.setString(4, athlet.getGender());
        pstm.setInt(5, athlet.getContactId());
        pstm.setInt(6, athlet.getClubId());
        
        System.out.println(pstm.toString());    
        pstm.executeUpdate();
    }
 
    public static void deleteAthlet(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM athletes WHERE id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
 
        pstm.executeUpdate();
    }
    
    public static void addAthlet(Connection conn, int id) throws SQLException {
        String sql = "INSERT INTO user_athletes(user_name, athlet_id) values('Thomas',?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, id);
        pstm.executeUpdate();
    }
    
    public static void addAthletEvent(Connection conn, int event_id, int athlet_id) throws SQLException {
        String sql = "INSERT INTO athlet_event(event_id, athlet_id) values('?',?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);

        pstm.setInt(1, event_id);
        pstm.setInt(2, athlet_id);
        pstm.executeUpdate();
    }
    
    public static void removeMyAthlet(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM user_athletes WHERE user_name = 'Thomas' AND athlet_id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
        pstm.executeUpdate();
    }
 
}

