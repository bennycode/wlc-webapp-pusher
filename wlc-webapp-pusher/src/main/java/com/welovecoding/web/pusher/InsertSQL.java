package com.welovecoding.web.pusher;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.jdbc.ScriptRunner;

public class InsertSQL {

  public static void main(String[] args) throws ClassNotFoundException {

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/welovecoding";

    String user = System.getProperty("jdbc.user", "welovecoding");
    String password = System.getProperty("jdbc.password", "123456");

    Properties info = new Properties();
    info.put("user", user);
    info.put("password", password);

    try {
      Connection connection = DriverManager.getConnection(url, info);
      ScriptRunner runner = new ScriptRunner(connection);
    } catch (SQLException ex) {
      Logger.getLogger(InsertSQL.class.getName()).log(Level.SEVERE, null, ex);
    }

  }

}
