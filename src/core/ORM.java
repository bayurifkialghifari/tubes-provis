/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.sql.SQLException;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;
/**
 *
 * @author AXIOO
 */
public class ORM extends Connection {
    
    private String sql_builder = "";
    private String table = "";
    private int i;
    
    public String get_table()
    {
        String child = this.getClass().getName();
        String[] childs = child.split("\\.", 0);
        
        return this.table == "" ? childs[1] : this.table;
    }
    
    public void set_table(String table)
    {
        this.table = table;
    }
    
    public String insert(String[] field, String[] data)
    {
        this.connect();
        
        try
        {            
            this.sql_builder = "insert into "+this.get_table();
            
            // Set field name           
            for(this.i = 0;this.i < field.length;this.i++)
            {
                if(this.i == 0)
                    this.sql_builder += " ("+field[this.i];
                else if(this.i < (field.length - 1))
                    this.sql_builder += ", "+field[this.i];
                else
                    this.sql_builder += ", "+field[this.i]+" ) values (";
            }
            
            // Set field to fill
            for(this.i = 0;this.i < field.length;this.i++)
            {
                if(this.i == (field.length - 1))
                    this.sql_builder += "?)";
                else
                    this.sql_builder += "?,";
            }
            
            // Prepare the query            
            this.ps = this.conn.prepareStatement(this.sql_builder);
            
            // fill the field
            for(this.i = 0;this.i < data.length;this.i++)
            {
                this.ps.setString(this.i + 1, data[i]);
            }
            
            // Execute the query            
            this.ps.executeUpdate();
            
            return this.sql_builder;
        }
        catch(SQLException e)
        {
            return e.toString();
        }
    }
    
    public String update(String[] field, String[] data, String where, String value_where)
    {
        this.connect();
        
        try
        {            
            this.sql_builder = "update "+this.get_table()+" set ";
            
            // Set field name to update           
            for(this.i = 0;this.i < field.length;this.i++)
            {
                if(this.i == (field.length - 1))
                    this.sql_builder += field[this.i] + " = ? ";
                else
                    this.sql_builder += field[this.i] + " = ?, ";
            }
            
            // Set where            
            this.sql_builder += "where "+where+" = ?";
            
            // Prepare the query            
            this.ps = this.conn.prepareStatement(this.sql_builder);
            
            // fill the field
            for(this.i = 0;this.i < data.length;this.i++)
            {
                this.ps.setString(this.i + 1, data[i]);
            }
            
            this.ps.setString(this.i + 1, value_where);
            
            // Execute the query            
            this.ps.executeUpdate();
            
            return this.sql_builder;
        }
        catch(SQLException e)
        {
            return e.toString();
        }
    }
    
    public String delete(String where, String value_where)
    {
        this.connect();
        
        try
        {            
            this.sql_builder = "delete from "+this.get_table()+" where "+where+"=?";
            
            // Prepare the query            
            this.ps = this.conn.prepareStatement(this.sql_builder);
            
            this.ps.setString(1, value_where);
            
            // Execute the query            
            this.ps.executeUpdate();
            
            return this.sql_builder;
        }
        catch(SQLException e)
        {
            return e.toString();
        }
    }
    
    public CachedRowSet all() throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select * from "+this.get_table();
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
    public CachedRowSet select_all(String select) throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select "+select+" from "+this.get_table();
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
    public CachedRowSet select_where(String select, String where, String value_where, String optional) throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select "+select+" from "+this.get_table()+" where "+where+" = '"+value_where+"' " + optional;
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
    public CachedRowSet select_like(String select, String like) throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select "+select+" from "+this.get_table()+" where " + like;
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
    public CachedRowSet select_join_all(String select, String join) throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select "+select+" from "+this.get_table()+" "+join;
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
    public CachedRowSet select_join_where(String select, String join, String where, String value_where, String optional) throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select "+select+" from "+this.get_table()+" "+join+" where "+where+" = '"+value_where+"' " + optional;
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
    public CachedRowSet select_join_like(String select, String join, String like) throws SQLException
    {
        this.connect();
        
        CachedRowSet crs = RowSetProvider.newFactory().createCachedRowSet();
        
        try
        {            
            this.sql_builder = "select "+select+" from "+this.get_table()+" "+join+" where "+like;
            
            // Create statement       
            this.st = this.conn.createStatement();
            // Execute statement            
            this.rs = this.st.executeQuery(this.sql_builder);

            // Create Result
            crs.populate(this.rs);
            
            return crs;
        }
        catch(SQLException e)
        {
            return crs;
        }
    }
    
}
