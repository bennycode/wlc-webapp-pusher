package com.welovecoding.web.pusher;

import java.io.IOException;
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.jdbc.ScriptRunner;

public class InsertSQL {

  private static final Logger LOG = Logger.getLogger(InsertSQL.class.getName());

  public static void main(String[] args) throws ClassNotFoundException {

    Class.forName("com.mysql.jdbc.Driver");
    Resources.setCharset(Charset.forName("UTF-8"));

    String url = "jdbc:mysql://localhost:3306/welovecoding";
    String user = System.getProperty("sql.user", "welovecoding");
    String password = System.getProperty("sql.password", "123456");
    // Get "insert.sql" from:
    // "Google Drive\We Love Coding (secrets)\wlc-webapp-pusher\insert.sql"
    String script = System.getProperty("sql.script", "production/insert.sql");

    Properties info = new Properties();
    info.put("user", user);
    info.put("password", password);

    try {
      Connection connection = DriverManager.getConnection(url, info);
      Reader reader = Resources.getResourceAsReader(Thread.currentThread().getContextClassLoader(), script);
      ScriptRunner runner = new ScriptRunner(connection);
      runner.runScript(reader);
      LOG.log(Level.INFO, "Script executed.");
    } catch (SQLException | IOException ex) {
      Logger.getLogger(InsertSQL.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
