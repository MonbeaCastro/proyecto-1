package com.tpfinal.entidad;
import com.tpfinal.conexion.*;
import com.tpfinal.entidad.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;
//import java.util.Iterator;
 
public class Pruebas {
	//public static Conexion con=new Conexion();
	private static Connection con;
	
	
	public static void main (String[] args) throws Exception {
		
		Comprador comp=new Comprador() ;
		comp.getAll();
		 
		 ArrayList <Comprador> arC = comp.getArlComprador();
		 Iterator <Comprador> i = arC.iterator();	
	      
		  while(i.hasNext())
		        {
		        Comprador c2 =  (Comprador) i.next();
		       	  
		        System.out.println(c2.getId_comprador());
		        System.out.println( c2.getApellido());
		        System.out.println(c2.getNombre());
		        System.out.println(c2.getCant_ticket());
		         
		        }
		
		
	/*	comp.setNombre("Andres");
		comp.setApellido("Zhong");
		comp.setFecha_compra("21/01/2023");
		comp.setCategoria(1); 
		comp.setPago_total(180);
		comp.setCant_ticket(1);
		comp.setDescuento(10);
		
		//comp.altaComprador();
		
		comp.altaCompradorNuevo();
		  
        System.out.println(comp.getId_comprador());
        System.out.println(comp.getNombre());
        System.out.println(comp.getApellido());
        System.out.println(comp.getFecha_compra());
		
    */
		
		
		
		// TODO Auto-generated method stub
		
		//con.getConexion();
		//System.out.println("Funciona");
		/*Categoria cate=new Categoria();*/
		
        /*	cate.setId_categoria(2);
		cate.setDescripcion("Alumnito"); 
		
		cate.getAll();
		/* -------------------------------*/
		
		/*	ArrayList <Categoria> arC = cate.getArlCategoria();
		  	Iterator <Categoria> i = arC.iterator();	
	      
		  	while(i.hasNext())
		        {
		        Categoria cate2 =  (Categoria) i.next();
		       	  
		        System.out.println(cate2.getId_categoria());
		        System.out.println(cate2.getDescripcion());
		        System.out.println(cate2.getDescuento());
		       
		        }
	 */		 
  }
	
	
	public static void main_old(String[] args) throws Exception, IOException, SQLException {
		try{ 
	  		
	 /* 		String base="codoacodo";
	  		String user="general";//"scott";
	        String pass="LLeeee!2.0";// "tiger";
	        String url = "jdbc:mysql://10.0.0.66:3306/"+ base +"?useUnicode=true&characterEncoding=utf8";
	 
	  		
	  		
	          //Class.forName("com.mysql.jdbc.Driver");
	          Class.forName("com.mysql.cj.jdbc.Driver");
	          con = DriverManager.getConnection(url, user, pass);*/
	          
	    /*********************************************/
	          Categoria cate=new Categoria();
	  			ArrayList <Categoria> arC = cate.getArlCategoria();
	      		  Iterator <Categoria> i = arC.iterator();	
	      	      
	      		  while(i.hasNext())
	      		        {
	      		        Categoria cate2 =  (Categoria) i.next();
	      		       	  
	      		        System.out.println(cate2.getId_categoria());
	      		        System.out.println(cate2.getDescripcion());
	      		        System.out.println(cate2.getDescuento());
	      		       
	      		        }
	  
	          
	    /************************************************/      
	     
	      }
	      catch(ClassNotFoundException cnfe){
	          System.out.println("driver no encontrado: " + cnfe.getMessage());
	          
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
		
		
		
		System.out.println("Funciona");
		
		
	}
	
		
	}
	 
