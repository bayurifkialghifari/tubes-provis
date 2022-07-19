/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package middleware;


import model.user;
import javax.sql.rowset.CachedRowSet;

/**
 *
 * @author AXIOO
 */
public class authentication {
    
    password_hash hash = new password_hash();
    user user = new user();
    CachedRowSet crs;
    
    public static boolean isLoggedIn = false;
    public static int id_user = 0;
    public static int id_role = 0;
    public String saltvalue = "GGWP";
    
    public void setLogged(boolean loged)
    {
        this.isLoggedIn = loged;
    }
    
    public void setId(int id)
    {
        this.id_user = id;
    }
    
    public void setRole(int role)
    {
        this.id_role = role;
    }
    
    public int getId()
    {
        return this.id_user;
    }
    
    public int getRole()
    {
        return this.id_role;
    }
    
    public boolean auth(String username, String password) throws Exception
    {
        crs = user.select_where("*", "user_name", username, "");
        
        int i = 0;
        
        while(crs.next())
        {
            i++;
            
            this.setId(crs.getInt("user_id"));
            this.setRole(crs.getInt("user_role_id"));
            this.setLogged(hash.verifyUserPassword(password, crs.getString("user_password"), saltvalue));
        }
        
        if(i == 0)
        {
            return false;
        }
        else
        {
            return this.isLoggedIn;
        }
        
    }
    
    public boolean register(String username, String password) throws Exception
    {
        // Check then username
        crs = user.select_where("*", "user_name", username, "");
        
        int i = 0;
        
        while(crs.next())
        {
            i++;
        }
        
        String encryptedpassword = hash.generateSecurePassword(password, saltvalue);
        String [] field = {"user_role_id", "user_name", "user_password"};
        String [] data = {"2", username, encryptedpassword};
        
        // Insert data user        
        if(i == 0)
        {
            user.insert(field, data);   
            
            return true;
        }
        else
        {
            return false;
        }
    }
}
