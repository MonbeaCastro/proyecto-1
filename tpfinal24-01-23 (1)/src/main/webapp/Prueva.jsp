<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="com.tpfinal.conexion.*,java.util.ArrayList,java.util.Iterator,com.tpfinal.entidad.Categoria"%>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head> 
<body>
<select onChange="" id="bases">
 <%

	 Categoria  cate = new Categoria();
 	  cate.getAll();
       
      ArrayList aL = cate.getArlCategoria(); 
      Iterator ii = aL.iterator();	
      String elegido="";          // El que elegí en la lista 
      int i=1;
      while(ii.hasNext())
       {
    	 Categoria c2 =  (Categoria) ii.next();
         out.println("<OPTION VALUE='"+ c2.getId_categoria()+"' "+ elegido + " >"+ c2.getDescripcion()+"</OPTION>");
        i++; 
       }
       %>

    </select>
    <a href="index.html"> como a la pagina html</a>
    
</body>
</html>