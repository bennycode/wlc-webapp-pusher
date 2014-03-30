package com.welovecoding.web.pusher;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.jdbc.ScriptRunner;

public class InsertSQL {

  private static final Logger LOG = Logger.getLogger(InsertSQL.class.getName());

  public static void main(String[] args) throws ClassNotFoundException {

    Class.forName("com.mysql.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/welovecoding";
    String user = System.getProperty("sql.user", "welovecoding");
    String password = System.getProperty("sql.password", "123456");
    String script = System.getProperty("sql.script", "test/insert.sql");

    Properties info = new Properties();
    info.put("user", user);
    info.put("password", password);

    InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(script);

    if (in == null) {
      LOG.log(Level.WARNING, "Test file not found.");
    } else {
      try {
        Connection connection = DriverManager.getConnection(url, info);
        ScriptRunner runner = new ScriptRunner(connection);
        runner.runScript(new BufferedReader(new InputStreamReader(in)));
        System.out.println("Script executed.");
      } catch (SQLException ex) {
        Logger.getLogger(InsertSQL.class.getName()).log(Level.SEVERE, null, ex);
      }
    }
  }
}
