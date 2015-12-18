package me.TheKawaiiAsian.xReport.utils;

import me.TheKawaiiAsian.xReport.Core;

import java.sql.*;

/**
 * *******************************************************************
 * » Copyright Dylzqn (c) 2015. All rights Reserved.
 * » Any code contained within this document, and any associated APIs with similar branding
 * » are the sole property of Dylzqn. Distribution, reproduction, taking snippets, or
 * » claiming any contents as your own will break the terms of the licence, and void any
 * » agreements with you. the third party.
 * » Thanks :D
 * ********************************************************************
 */
public class MySQL {

    private static String username = Core.getInstance().getConfig().getString("Username");
    private static String password = Core.getInstance().getConfig().getString("Password");
    private static String database = Core.getInstance().getConfig().getString("Database");
    private static String host = Core.getInstance().getConfig().getString("Host");
    private static String port = Core.getInstance().getConfig().getString("Port");

    private static Connection connection;

    public MySQL() {

        try {
            if (connection != null) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
        } catch (Exception ex) {
            System.out.println("§4§lCould Not Enable xReport due to MySql connection. Disabling xReport");
        }
    }

    public static Connection getConnection() {
        return connection;
    }

    public ResultSet getResultSet(String qry) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(qry);
        return statement.executeQuery();
    }

    public void executeUpdate(String qry) throws SQLException {

        PreparedStatement statement = connection.prepareStatement(qry);
        statement.executeUpdate();
        statement.close();
    }

    public void close () {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void createTable () {

        try {
            executeUpdate("CREATE TABLE IF NOT EXISTS `xReportManager` (ID INT NOT NULL AUTO_INCREMENT, PlayerUUID VARCHAR(100), PlayerName VARCHAR(100), ReporterUUID VARCHAR(100), ReporterName VARCHAR(100), ReportReason VARCHAR(100), ReportTime VARCHAR(100), PRIMARY KEY (ID))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
