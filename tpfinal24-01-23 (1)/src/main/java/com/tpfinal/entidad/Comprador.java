package com.tpfinal.entidad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.tpfinal.conexion.*;

public class Comprador {
	private int id_comprador;
	private String nombre;
	private String apellido; 
	private String fecha_compra;
	private int categoria;
	private int pago_total;
	private int cant_ticket;
	private int descuento;
	private String email;
	private Connection con;
	private ArrayList <Comprador> arlComprador =new ArrayList<Comprador>();
	
	/*-------------------------------------------------------------------------*/
	/*----------------  Alta en la base de datos a los compradores-------------*/
	/*-------------------------------------------------------------------------*/	
	/*Forma más compleja de hacer insert */ 
	
	public void altaComprador()
    {
    	try {
    		
    		if(con==null) 	
            { 	
              	ConnectionManager con1 = new ConnectionManager(); 
            	con=con1.getConnection();
            	
            }
    		Statement stmt=con.createStatement();
    		String query="insert into codoacodo.comprador ";  //Se inserta en la base
            query=query + " (nombre, apellido, fecha_compra, id_categoria, pago_total, ";
            query=query + " cant_ticket, descuento, email)";
            query=query + " Values('"  + this.getNombre() + "','" + this.getApellido() + "'," ;
            query=query + "'" + this.getFecha_compra()+ "'," +  this.getCategoria() + "," +this.getPago_total()+ ",";
            query=query + " " +this.getCant_ticket()+"," +  this.getDescuento()+"','"+ this.getEmail()+"')";
           
            
            PreparedStatement pst = con.prepareStatement(query);
            stmt.execute(query);
            con.commit(); 
            
            
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
  	
    }
	
    
	
	/*-----------------------------------------------------------*/
	/***************Nueva Metodo para hacer Alta******************/
	/*-----------------------------------------------------------*/
	
	/*Forma más sencilla de hacer insert en Comprador */ 
	public void altaCompradorNuevo()
	   {
	   	try {
	   		
	   		if(con==null) 	
	           { 	
	             	ConnectionManager con1 = new ConnectionManager(); 
	           	con=con1.getConnection();
	           	
	           }
	   	
	   		Statement stmt=con.createStatement();
	   		//PreparedStatement pst = con.prepareStatement("INSERT INTO PALABRAS(id,fonetica,significado,caracter,Libro,Unidad) VALUES (?,?,?,?)");
	   		String sqlQuery = "insert into codoacodo.comprador(nombre, apellido, fecha_compra, id_categoria, pago_total, cant_ticket, descuento, email) ";
	   		       sqlQuery = sqlQuery+ " values (?,?,?,?,?,?,?,?)";
		   
		   //   con.setAutoCommit(false);
		     
		      PreparedStatement ps = con.prepareStatement(sqlQuery);
		   
		      ps.setString(1, this.getNombre());
		      ps.setString(2, this.getApellido());
		      ps.setString(3, this.getFecha_compra());
		      ps.setInt(4, this.getCategoria());
		      ps.setInt(5, this.getPago_total());
		      ps.setInt(6, this.getCant_ticket());
		      ps.setInt(7, this.getDescuento());
		      ps.setString(8,this.getEmail());
		    
		    
		      ps.executeUpdate();
	//	      con.commit();
	    } catch (Exception e) {
	        System.out.print("Error en el ingreso Alta 2: "+ e.getMessage());
	    }
	   	
	   }
	
	
	
	
	
	
	
	
	/*-----------------------------------------------------------------------*/
	/*---------Va a traer todos compradores de la Base de Datos ----------*/
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
        	 String sql="SELECT * FROM codoacodo.comprador order by id_comprador";
             pstmt = con.prepareStatement(sql);
             rs = pstmt.executeQuery();
            System.out.println("trajo los compradores de la base de codoacodo ");
            
          while( rs.next() )
          {
              Comprador c=new Comprador(con);
              
              c.setId_comprador(rs.getInt("id_comprador"));
              c.setNombre(rs.getString("nombre"));
              c.setApellido(rs.getString("apellido"));
              c.setFecha_compra(rs.getString("fecha_compra"));
              c.setCategoria(rs.getInt("id_categoria"));
              c.setPago_total(rs.getInt("pago_total"));
              c.setCant_ticket(rs.getInt("cant_ticket"));
              c.setDescuento(rs.getInt("descuento"));
              c.setEmail(rs.getString("email"));
                   
              arlComprador.add(c);
              
          }
           }catch (SQLException ex)
             {
             System.out.println("Error select de los Comprador getall -> " + ex.getMessage());
             }    
    	
    }
	
	
	/* Se generan los getter y Seter de la Clase Comprador*/
	public int getId_comprador() {
		return id_comprador;
	}
	public void setId_comprador(int id_comprador) {
		this.id_comprador = id_comprador;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	public int getPago_total() {
		return pago_total;
	}
	public void setPago_total(int pago_total) {
		this.pago_total = pago_total;
	}
	public int getCant_ticket() {
		return cant_ticket;
	}
	public void setCant_ticket(int cant_ticket) {
		this.cant_ticket = cant_ticket;
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
	public ArrayList<Comprador> getArlComprador() {
		return arlComprador;
	}
	public void setArlComprador(ArrayList<Comprador> arlComprador) {
		this.arlComprador = arlComprador;
	}
	
/* Constructores de la Clase Comprador*/ 
	
	/********* Constructores***********/
    public Comprador() throws Exception 
     {
       
    	if(con==null ) 	
          { 	
           try{
        	   ConnectionManager con1 = new ConnectionManager(); 
        	   con=con1.getConnection();
               }catch (SQLException ex)
                      {
                         System.out.println("Error en el Constructor de Comprador-> " + ex.getMessage());
                      }
               }
    }
    
    public Comprador(Connection conN) {
       
    con=conN;
    }



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
}
