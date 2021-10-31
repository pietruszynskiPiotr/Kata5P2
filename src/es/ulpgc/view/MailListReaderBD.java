package es.ulpgc.view;

import java.sql.*;
import es.ulpgc.model.Mail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MailListReaderBD {

    public List<Mail> read() throws IOException {
        List<Mail> mails = new ArrayList();
        String sql = "SELECT * FROM direcc_email";
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                String dirrection = rs.getString("direccion");
                mails.add(new Mail(dirrection));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return mails;
    }

    public void selectAll() {
        String sql = "SELECT * FROM direcc_email";
        try ( Connection conn = this.connect();  Statement stmt = conn.createStatement();  ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                rs.getString("dirrecion");
                rs.getString("dirrecion");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private Connection connect() {
        String url = "jdbc:sqlite:Kata5.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

}
