/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.*;
import config.database;
/**
 *
 * @author AXIOO
 */
public class Connection extends database {
    public PreparedStatement ps;
    public java.sql.Connection conn;
    public ResultSet rs;
    public Statement st;
    private String url;
    
    public void connect()
    {
        this.url = "jdbc:mysql://"+this.get_host()+":"+this.get_port()+"/"+this.get_database()+"?autoReconnect=true&useSSL=false";
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            this.conn = DriverManager.getConnection(this.url, this.get_username(), this.get_password());
        } 
        catch(SQLException e) 
        {
            System.out.print(e.toString());
        }
        catch(ClassNotFoundException e)
        {
            System.out.println("JDBC Class Not Found");
        }
    }
}
