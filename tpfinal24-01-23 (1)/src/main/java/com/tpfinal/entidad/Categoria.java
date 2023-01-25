package com.tpfinal.entidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tpfinal.conexion.*;

/* Este Objeto maneja las categorias M.Castro Enero 2023 */

public class Categoria {
	private int id_categoria;
	private String descripcion;
	private int descuento; 
	private Connection con;
	private ArrayList <Categoria> arlCategoria =new ArrayList<Categoria>();
	
	
	/*-----------------------------------------------------------------------*/
	/*---------Va a traer todas las categorias de la Base de Datos ----------*/
	/*-----------------------------------------------------------------------*/
	public void getAll () throws Exception
    {
    	PreparedStatement pstmt = null;
        ResultSet rs = null;
         try{
        	 if(con==null)//si se perdio la conexion
        	 {
        		 Conexion con1 = new Conexion(); 
        	    	con=con1.getConexion();
        	 } 
        	 String sql="SELECT * FROM codoacodo.categoria order by id_categoria";
             pstmt = con.prepareStatement(sql);
             rs = pstmt.executeQuery();
            System.out.println("trajo las categorias de la base de codoacodo ");
            
          while( rs.next() )
          {
              Categoria c=new Categoria(con);
              
              c.setId_categoria(rs.getInt("id_categoria"));
              c.setDescripcion(rs.getString("descripcion"));
              c.setDescuento(rs.getInt("descuento"));
            
            
              arlCategoria.add(c);
              
          }
           }catch (SQLException ex)
             {
             System.out.println("Error select de los Categoria getall -> " + ex.getMessage());
             }    
    	
    }
	
	
	/* Seter y Geter de Categoria*/
	public int getId_categoria() {
		return id_categoria;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public Connection getCon() {
		return con;
	}
	public void setCon(Connection con) {
		this.con = con;
	}
	public ArrayList<Categoria> getArlCategoria() {
		return arlCategoria;
	}
	public void setArlCategoria(ArrayList<Categoria> arlCategoria) {
		this.arlCategoria = arlCategoria;
	}
	
	
	
	
/* Constructores de la Clase */ 
	
	/********* Constructores***********/
    public Categoria() throws Exception 
     {
       
    	if(con==null ) 	
          { 	
           try{
        	   ConnectionManager con1 = new ConnectionManager(); 
        	   con=con1.getConnection();
               }catch (SQLException ex)
                      {
                         System.out.println("Error en las Categoria inicio con boolean-> " + ex.getMessage());
                      }
               }
    }
    
    public Categoria(Connection conN) {
       
    con=conN;
    }
	
	
	
	
}
