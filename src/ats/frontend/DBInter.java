/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ats.frontend;

/**
 *
 * @author armor
 */
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Base64;

public class DBInter
{
    public byte[] decoded;
    String ip;
    String databaseUrl = "jdbc:mysql://"+ip+":3306/ats_sysdb";
    String userName = "ATS";
    String password = "220396";

    Vector connectionPool = new Vector();

    public DBInter()
    {
        
        try {
            BufferedReader in = new BufferedReader(new FileReader("ipconfig.txt"));
            ip=in.readLine();
            decoded= Base64.getDecoder().decode(ip);
            String d2 = new String(decoded, StandardCharsets.UTF_8);
            databaseUrl="jdbc:mysql://"+d2+":3306/ats_sysdb";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DBInter.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DBInter.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        initialize();
        
    }

    public DBInter(
        //String databaseName,
        String databaseUrl,
        String userName,
        String password
        )
    {
        this.databaseUrl = databaseUrl;
        this.userName = userName;
        this.password = password;
        initialize();
    }

    private void initialize()
    {
        //Here we can initialize all the information that we need
        initializeConnectionPool();
    }

    private void initializeConnectionPool()
    {
        while(!checkIfConnectionPoolIsFull())
        {
            System.out.println("Connection Pool is NOT full. Proceeding with adding new connections");
            //Adding new connection instance until the pool is full
            connectionPool.addElement(createNewConnectionForPool());
        }
        System.out.println("Connection Pool is full.");
    }

    private synchronized boolean checkIfConnectionPoolIsFull()
    {
        final int MAX_POOL_SIZE = 10;

        //Check if the pool size
        if(connectionPool.size() < MAX_POOL_SIZE)
        {
            return false;
        }

        return true;
    }

    //Creating a connection
    private Connection createNewConnectionForPool()
    {
        Connection connection = null;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(databaseUrl, userName, password);
            System.out.println("Connection: "+connection);
        }
        catch(SQLException sqle)
        {
            System.err.println("SQLException: "+sqle);
            return null;
        }
        catch(ClassNotFoundException cnfe)
        {
            System.err.println("ClassNotFoundException: "+cnfe);
            return null;
        }

        return connection;
    }

    public synchronized Connection getConnectionFromPool()
    {
        Connection connection = null;

        //Check if there is a connection available. There are times when all the connections in the pool may be used up
        if(connectionPool.size() > 0)
        {
            connection = (Connection) connectionPool.firstElement();
            connectionPool.removeElementAt(0);
            System.out.println("Connection"+connection+" Removed from Pool.");
        }
        //Giving away the connection from the connection pool
        return connection;
    }

    public synchronized void returnConnectionToPool(Connection connection)
    {
        System.out.println("Connection"+connection+" Added to Pool.");
        //Adding the connection from the client back to the connection pool
        connectionPool.addElement(connection);
    }

    
    
    public int[] get1INT(String param) throws SQLException {
    int[] arr= new int[10000];
    String p = param;
    try {
        Connection conn=getConnectionFromPool();
        PreparedStatement ps = conn.prepareStatement(p);
        
        try (ResultSet rs = ps.executeQuery()) {
            int i=0;
            while(rs.next())
            { 
                arr[i] = rs.getInt(1);
                i++;
            }
            
        }
        returnConnectionToPool(conn);
        return arr;
    }
    catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
           arr= new int[100];
        return arr; 
        }
        

    
}

public long[] get1LONG(String param) throws SQLException {
    long[] arr= new long[10000];
    String p = param;
    try {
        Connection conn=getConnectionFromPool();
        PreparedStatement ps = conn.prepareStatement(p);
        
        try (ResultSet rs = ps.executeQuery()) {
            int i=0;
            while(rs.next())
            { 
                arr[i] = rs.getLong(1);
                i++;
            }
            
        }
        returnConnectionToPool(conn);
        return arr;
    }
    catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            arr= new long[100];
        return arr;
        }
        

    
}

public String[] get1String(String param) throws SQLException {
    String[] arr= new String[10000];
    String p = param;
    try {
        Connection conn=getConnectionFromPool();
        PreparedStatement ps = conn.prepareStatement(p);
        
        try (ResultSet rs = ps.executeQuery()) {
            int i=0;
            while(rs.next())
            { 
                arr[i] = rs.getString(1);
                i++;
            }
            
        }
        returnConnectionToPool(conn);
        return arr;
    }
    catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            arr= new String[100];
        return arr;
        }
        

    
}

public float[] get1FLOAT(String param) throws SQLException {
    float[] arr= new float[10000];
    String p = param;
    try {
        Connection conn=getConnectionFromPool();
        PreparedStatement ps = conn.prepareStatement(p);
        
        try (ResultSet rs = ps.executeQuery()) {
            int i=0;
            while(rs.next())
            { 
                arr[i] = rs.getFloat(1);
                i++;
            }
            
        }
        returnConnectionToPool(conn);
        return arr;
    }
    catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            arr= new float[100];
        return arr;
        }
        

    
}

public void statement(String param) throws SQLException {
    Statement sta = null;
    Connection conn=getConnectionFromPool();
  try

  {
      
      sta = conn.createStatement();
  }
  
  finally
  {
      int changedRowsCount = sta.executeUpdate(param);
  }
        ResultSet rs = sta.executeQuery("SELECT * FROM Customer");
{
if (sta != null) { sta.close(); }
}
        
    returnConnectionToPool(conn);
}

}