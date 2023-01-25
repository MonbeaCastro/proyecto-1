/* clase de conexion enero 2023 */
package com.tpfinal.conexion;
import java.sql.*;

public class Conexion {
    private static Connection con;
	private void  newCon()  throws Exception
	  {
	  	try{ 

	  		String base="codoacodo";
	  		String user="general";//"scott";
	        String pass="LLeeee!2.0";// "tiger";
	        String url = "jdbc:mysql://10.0.0.66:3306/"+ base +"?useUnicode=true&characterEncoding=utf8";
	 
	  		
	  		
	          //Class.forName("com.mysql.jdbc.Driver");
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          con = DriverManager.getConnection(url, user, pass);
	          
	    
	        
	      }
	      catch(ClassNotFoundException cnfe){
	          System.out.println("driver nao encontrado: " + cnfe.getMessage());
	          
	      }
	      catch(SQLException sql){
	          System.out.println("SQLException: " + sql.getMessage());
	          System.out.println("SQLState: " + sql.getSQLState());
	          System.out.println("Erro: " + sql.getErrorCode());
	          System.out.println("StackTrace: " + sql.getStackTrace());
	          
	      }
	      catch(Exception e){
	          System.out.println(e.getMessage());
	          
	      }
	  }  
	/*Aca va el método para devolver la conexion */
	 
	public Connection getConexion()  throws Exception{ 
		newCon();
		return con;		
	}
	
	
}
