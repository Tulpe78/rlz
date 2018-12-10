package org.rlz.dataHandling;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.rlz.dataModel.Event;

public class EventDAO {

	public static List<Event> selectEvent(Connection conn) throws SQLException {
        String sql = "SELECT id, saison, exec_date, name, descn  FROM events";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        ResultSet rs = pstm.executeQuery();
        List<Event> list = new ArrayList<Event>();
        while (rs.next()) {
            int id = rs.getInt("id");
            int saison = rs.getInt("saison");
            String execDate = rs.getString("exec_date");
            String name = rs.getString("name");
            String descn = rs.getString("descn");
            
            Event event = new Event();
            event.setId(id);
            event.setSaison(saison);
            event.setExecDate(execDate);
            event.setName(name);
            event.setDescn(descn);        
            list.add(event);
            System.out.println("eventliste: "+execDate);
        }
        return list;
    }
 
    public static Event findEvent(Connection conn, int idIn) throws SQLException {
        String sql = "SELECT id, saison, exec_date, name, descn FROM events WHERE id = ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
        pstm.setInt(1, idIn);
 
        ResultSet rs = pstm.executeQuery();
 
        while (rs.next()) {
            int id = rs.getInt("id");
            int saison = rs.getInt("saison");
            String exec_date = rs.getString("exec_date");
            String name = rs.getString("name");
            String descn = rs.getString("descn");

            Event event = new Event(id, saison, exec_date, name, descn);
            return event;
        }
        return null;
    }
 
    public static void updateEvent(Connection conn, Event event) throws SQLException {
        String sql = "UPDATE events set saison =?, exec_date =?, name=?, descn=? WHERE id=? ";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, event.getId());
        pstm.setInt(2, event.getSaison());
        pstm.setString(3, event.getExecDate());
        pstm.setString(4, event.getName());
        pstm.setString(5, event.getDescn());
        pstm.executeUpdate();
    }
 
    public static void insertEvent(Connection conn, Event event) throws SQLException {
        String sql = "INSERT INTO events(saison, exec_date, name, descn) VALUES (?,?,?,?)";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, event.getSaison());
        pstm.setString(2, event.getExecDate());
        pstm.setString(3, event.getName());
        pstm.setString(4, event.getDescn());

        pstm.executeUpdate();
    }
 
    public static void deleteEvent(Connection conn, int id) throws SQLException {
        String sql = "DELETE FROM events WHERE id= ?";
 
        PreparedStatement pstm = conn.prepareStatement(sql);
 
        pstm.setInt(1, id);
 
        pstm.executeUpdate();
    }
 
}

