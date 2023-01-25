/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tpfinal.conexion;


import java.sql.*;
//import java.util.*;

public class ConnectionManager   implements java.io.Serializable
{
   private static Connection con;
   private String imprime="";
   
   
   
   /************************************************************************************/
   String ANSI_BLACK = "\u001B[30m";
   String ANSI_RED = "\u001B[31m";
   String ANSI_GREEN = "\u001B[32m";
   String ANSI_YELLOW = "\u001B[33m";
   String ANSI_BLUE = "\u001B[34m";
   String ANSI_PURPLE = "\u001B[35m";
   String ANSI_CYAN = "\u001B[36m";
   String ANSI_WHITE = "\u001B[37m";
  //Podremos utilizarlas para controlar el color que queremos mostrar con System.out.println.

  //Además podemos definir esta constante:

  String ANSI_RESET = "\u001B[0m";
  //que nos permitirá dejarlo todo como estaba y volver a los colores por defecto.

 

  /*
  dejando además la consola en su estado predeterminado, justo a continuación.
  Del mismo modo podemos definir una serie de constantes para establecer el color de fondo que queremos usar con el texto, así:
  */
  String ANSI_BLACK_BACKGROUND = "\u001B[40m";
  String ANSI_RED_BACKGROUND = "\u001B[41m";
  String ANSI_GREEN_BACKGROUND = "\u001B[42m";
  String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
  String ANSI_BLUE_BACKGROUND = "\u001B[44m";
  String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
  String ANSI_CYAN_BACKGROUND = "\u001B[46m";
  String ANSI_WHITE_BACKGROUND = "\u001B[47m";
  
  
  
  
  String user="root";//"scott";
  String pass="";// "tiger";
  String url = "jdbc:mysql://10.0.0.66:3306/codoacodo?useUnicode=true&characterEncoding=utf8";
	
  
  
  protected void cerrar() {

      if (con != null) {
          try {
              con.close();
          } catch (Exception ignored) {
              // aqui solo ignoramos, ya que no nos importa si da error al momento de cerrar la conexion
          }
      }
  }
  
  
  /*****************************  12-1-22   *************************************************/
  public Connection getConnection(String base, String server) throws Exception
  {
   
        newCon( base, server); 
        //else
      // System.out.println("Vieja Coneccion");  
    return con;
  }
  private void  newCon(String base, String server)  throws Exception
  {
  	try{ 
  		int loca=0; /// 0 mi server 
  		if(server.equals("Local"))
  		   loca=1;	
  		
  		String user="root";//"scott";
          String pass="";// "tiger";
          String url = "jdbc:mysql://10.0.0.66:3306/"+ base +"?useUnicode=true&characterEncoding=utf8";
  		
  		if(loca==1)
  		{    		
  		user="root";//"scott";
          pass="";// "tiger";
           url = "jdbc:mysql://127.0.0.1:3306/"+ base +"?useUnicode=true&characterEncoding=utf8";
  		}
  		
         // Class.forName("com.mysql.jdbc.Driver");
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection(url, user, pass);
          
          //System.out.println(ANSI_BLUE +"Hay: "+ ANSI_RESET + ANSI_RED + base + ANSI_RESET +ANSI_BLUE + " Palacbras en "+ base  +ANSI_RESET);
          if(loca==0)
          { 	
           System.out.println(ANSI_BLUE_BACKGROUND +ANSI_CYAN + "****************************************************");
           System.out.println(ANSI_CYAN + "*  conectando a la base" + ANSI_RED + " Server:  "+ ANSI_RESET + ANSI_BLUE_BACKGROUND +ANSI_CYAN + base + "              *");
           System.out.println("*        Inicio de "  + ANSI_RED + " 语言 "+ ANSI_RESET + ANSI_BLUE_BACKGROUND +ANSI_CYAN + "                           *");
           System.out.println(ANSI_CYAN + "****************************************************" + ANSI_RESET);
          }else {
          	System.out.println(ANSI_BLACK_BACKGROUND +ANSI_CYAN + "****************************************************");
              System.out.println(ANSI_CYAN + "*  conectando a la base" + ANSI_RED + " Local:  "+ ANSI_RESET + ANSI_BLACK_BACKGROUND +ANSI_CYAN + base + "              *");
              System.out.println("*        Inicio de "  + ANSI_RED + " 语言 "+ ANSI_RESET + ANSI_BLACK_BACKGROUND +ANSI_CYAN + "                           *");
              System.out.println(ANSI_CYAN + "****************************************************" + ANSI_RESET);
          	
              }
        
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
  /***********************************************************************************************/
   public String getImprime()
   { 
      return imprime;
   }
   public void setImprime(String cad)
   {
      imprime=cad;
   }
   
    public ConnectionManager() throws Exception
    {
        newCon(); 
    }
    
    public ConnectionManager(String base) throws Exception
    {
        newCon(base); 
    }
    public Connection getConnection() throws Exception
    {
      if( con==null )
          newCon(); 
          //else
        // System.out.println("Vieja Coneccion");  
      return con;
    }
    public void  ConnectionJDBCExterno () {
    /*	try {
    	Class . forName ( "com.mysql.jdbc.Driver " ) ;
    	connection_ = DriverManager . getConnection ( url_ ,login_ , password_ ) ;
    	if ( connection_ != null ) {
    	st_ = connection_ . createStatement () ;
    	System . out . println ( " Conexion a base de 	datos " + db_ + " correcta . " ) ;
    	}
    	else
    	System . out . println ( " Conexion fallida . " ) ;
    	} catch ( SQLException e ) { e . printStackTrace () ;}
    	catch ( ClassNotFoundException e ) { e . printStackTrace () ;}
    	catch ( Exception e ) { e . printStackTrace () ;}
    	*/
    	}
    
    private void  newCon(String base)  throws Exception
    {
    	try{ 
    		int loca=1; /// 0 mi server 
    		String user="root";//"scott";
            String pass="";// "tiger";
            String url = "jdbc:mysql://10.0.0.66:3306/"+ base +"?useUnicode=true&characterEncoding=utf8";
    		
    		if(loca==1)
    		{    		
    		user="root";//"scott";
            pass="";// "tiger";
             url = "jdbc:mysql://127.0.0.1:3306/"+ base +"?useUnicode=true&characterEncoding=utf8";
    		}
    		
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            //System.out.println(ANSI_BLUE +"Hay: "+ ANSI_RESET + ANSI_RED + base + ANSI_RESET +ANSI_BLUE + " Palacbras en "+ base  +ANSI_RESET);
            if(loca==0)
            { 	
             System.out.println(ANSI_BLUE_BACKGROUND +ANSI_CYAN + "****************************************************");
             System.out.println(ANSI_CYAN + "*  conectando a la base" + ANSI_RED + " Server:  "+ ANSI_RESET + ANSI_BLUE_BACKGROUND +ANSI_CYAN + base + "              *");
             System.out.println("*        Inicio de "  + ANSI_RED + " 语言 "+ ANSI_RESET + ANSI_BLUE_BACKGROUND +ANSI_CYAN + "                           *");
             System.out.println(ANSI_CYAN + "****************************************************" + ANSI_RESET);
            }else {
            	System.out.println(ANSI_BLACK_BACKGROUND +ANSI_CYAN + "****************************************************");
                System.out.println(ANSI_CYAN + "*  conectando a la base" + ANSI_RED + " Local:  "+ ANSI_RESET + ANSI_BLACK_BACKGROUND +ANSI_CYAN + base + "              *");
                System.out.println("*        Inicio de "  + ANSI_RED + " 语言 "+ ANSI_RESET + ANSI_BLACK_BACKGROUND +ANSI_CYAN + "                           *");
                System.out.println(ANSI_CYAN + "****************************************************" + ANSI_RESET);
            	
                }
          
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
    private void  newCon()  throws Exception
    {
    	try{ 
    		
    		//String base = "Defecto aleman ";
    		String base = "codoacodo";//10/2/22 para que use solo esta base yuyan
    		
    		int loca=1;
    		String user="root";//"scott";
            String pass="";// "tiger";
            String url = "jdbc:mysql://10.0.0.66:3306/DemoImagenes?useUnicode=true&characterEncoding=utf8";
    		
    		if(loca==1)
    		{    		
    		user="root";//"scott";
            pass="";// "tiger";
             url = "jdbc:mysql://127.0.0.1:3306/codoacodo?useUnicode=true&characterEncoding=utf8";
    		}
    		
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, pass);
            if(loca==0)
            { 	
             System.out.println(ANSI_BLUE_BACKGROUND +ANSI_CYAN + "****************************************************");
             System.out.println(ANSI_CYAN + "*  conectando a la base" + ANSI_RED + " Server:  "+ ANSI_RESET + ANSI_BLUE_BACKGROUND +ANSI_CYAN + base + "              *");
             System.out.println("*        Inicio de "  + ANSI_RED + " 语言 "+ ANSI_RESET + ANSI_BLUE_BACKGROUND +ANSI_CYAN + "                           *");
             System.out.println(ANSI_CYAN + "****************************************************" + ANSI_RESET);
            }else {
            	System.out.println(ANSI_BLACK_BACKGROUND +ANSI_CYAN + "****************************************************");
                System.out.println(ANSI_CYAN + "*  conectando a la base" + ANSI_RED + " Local:  "+ ANSI_RESET + ANSI_BLACK_BACKGROUND +ANSI_CYAN + base + "              *");
                System.out.println("*        Inicio de "  + ANSI_RED + " 语言 "+ ANSI_RESET + ANSI_BLACK_BACKGROUND +ANSI_CYAN + "                           *");
                System.out.println(ANSI_CYAN + "****************************************************" + ANSI_RESET);
            	
                }
          
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
    	
    	
   /*  try{
         String user="root";//"scott";
         String pass="";// "tiger";
         String driver="com.mysql.jdbc.Driver"; 
     // ok    String url="jdbc:mysql://10.0.0.66/Coreano"; //"jdbc:odbc:THWeb";//"jdbc:oracle:thin:@10.18.4.11:1521:orcl817";
              String url = "jdbc:mysql://10.0.0.66:3306/Coreano?useUnicode=true&characterEncoding=utf8";
        
         
         Class.forName(driver);
	     con=DriverManager.getConnection(url,user,pass);
         System.out.println("Me conecte al servidor MYSQL");
         }catch (SQLException e) 
			{
        	 System.out.println("Error:-> " + e.getMessage());
			}
      */
    
    }
    
    
    
    public void close() throws Exception
    {
      con.close();
      System.out.println("Cerre La coneccion a la base");
     
    }
    public void finalize()
    {
	try
	{
         close();
          System.out.println("Finalize La coneccion con la base");  
	}catch(Exception ex)
	    {
	     ex.printStackTrace();
	    }
    }
}