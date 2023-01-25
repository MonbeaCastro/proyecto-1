<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
     <%@ page import="com.tpfinal.conexion.*,java.util.ArrayList,java.util.Iterator,com.tpfinal.entidad.*"%> 
<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>TP Integrador Monica Castro de CODO A CODO</title>

    <!-- Link CSS local styles -->
    <link rel="stylesheet" href="./CSS/style.css">

    <!-- Link CSS Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <!-- Link Fontawesome -->
    <script src="https://kit.fontawesome.com/628afeffd4.js" crossorigin="anonymous"></script>
    
     <!-- Link VUE -->
    <script src="https://unpkg.com/vue@3"></script>
    <style>
       
        .sinborde{
          border: 0px ;
          outline: none;
        }
      </style>
</head>


<body>
    <!-- NAVBAR FROM BOOTSTAP -->
    <nav class="navbar navbar-expand-lg navbar-dark fixed-top">
        <div class="container-lg">
            <!-- <a class="navbar-brand" href="#">Conf Bs As</a> -->
            <!-- <span><img src="./images/codoacodo.png" alt="Logo CaC"></span> -->
            <span><a href="./code.html" target="_blank"><img src="./images/codoacodo.png" alt="Logo CaC"></a></span>
            <h1 class="navbar-brand-h1 me-auto">Conf Bs As</h1>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"
                aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav ms-auto">
                    <a class="nav-link active" href="#" aria-current="page" href="#">La conferencia</a>
                    <a class="nav-link" href="#speakers">Los oradores</a>
                    <a class="nav-link" href="#">El lugar y la fecha</a>
                    <a class="nav-link" href="#orador">Conviertete en orador</a>
                    <a class="nav-link" href="#tickets">Comprar tickets</a>
                </div>
            </div>
        </div>
    </nav>

    <!-- SHOWCASE-->

    <section class="showcase">
        <div class="shadow">
            <div class="container-flex">
                <div class="content">
                    <h1>Conf Bs As</h1>
                    <p>Bs As llega por primera vez a Argentina. Un evento para compartir con nuestra comunidad el
                        conocimiento y experiencia de los expertos que estan creando el futuro de Internet. Ven a
                        conocer a
                        miembros del evento, a otros estudiantes de Codo a Codo y los oradores de primer nivel que
                        tenemos
                        para ti. Te esperamos!</p>
                    <div class="buttonarea">
                        <a class="btn btn-transparent" href="#orador">Quiero ser orador</a>
                        <a class="btn btn-solid" href="#tickets">Comprar tickets</a>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <!-- SPEAKERS -->
    <section class="speakers" id="speakers">
        <div class="title">
            <h6>CONOCE A LOS</h6>
            <h2>ORADORES</h2>
        </div>
        <div class="container-speakers">
            <div class="card">
                <img src="./images/steve.jpg" alt="Steve Jobs">
                <div class="skills">
                    <h6 class="yellow">JavaScript</h6>
                    <h6 class="cyan">React</h6>
                </div>
                <h3>Steve Jobs</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum, expedita pariatur officiis dicta
                    tempore repellat!</p>
            </div>
            <div class="card">
                <img src="./images/bill.jpg" alt="Bill Gates">
                <div class="skills">
                    <h6 class="yellow">JavaScript</h6>
                    <h6 class="cyan">React</h6>
                </div>
                <h3>Bill Gates</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum, expedita pariatur officiis dicta
                    tempore repellat!</p>
            </div>
            <div class="card">
                <img src="./images/ada.jpeg" alt="Ada Lovelace">
                <div class="skills">
                    <h6 class="grey">Negocios</h6>
                    <h6 class="magenta">Startups</h6>
                </div>
                <h3>Ada Lovelace</h3>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Ipsum, expedita pariatur officiis dicta
                    tempore repellat!</p>
            </div>
        </div>
    </section>

    <!-- CALL TO ACTION -->

    <section class="call-to-action">
        <div class="container-cta">
            <img src="./images/honolulu.jpg" alt="Honolulu">
            <div class="cta-content">
                <h2>Bs As - Octubre</h2>
                <p>Buenos Aires es la provincia y localidad más grande del estado de Argentina, en los Estados Unidos.
                    Honolulu es la mas sureña de entre las principales ciudades estadounidenses. Aunque el nombre de
                    Honolulu se refiere al área urbana en la costa sureste de la isla de Oahu, la ciudad y el condado de
                    Honolulu han formado una ciudad-condado consolidada que cubre toda la ciudad (aproximadamente 600
                    km2 de superficie.</p>
                <a href="#" class="btn btn-transparent">Conocé más</a>
            </div>
        </div>
    </section>


    <!-- FORM -->
    <!-- Acá comienza la magia para El form puro back end  -->
    
    <% 
  
		String nombre        =request.getParameter("txt_Nombre");
        String apellido      =request.getParameter("txt_Apellido");
        String fecha_compra  =request.getParameter("txt_fecha_compra");
        String categoria     =request.getParameter("hiddenCategoria");
        String pago_total    =request.getParameter("totalapagar");
        String cantidad      =request.getParameter("txt_Cantidad");
        String descuento     =request.getParameter("txtDescuento");
        String email         =request.getParameter("txt_Email");
        String action        =request.getParameter("action");
        
      /*Me aseguro que no haya Nulos*/
        if(action==null || action.equalsIgnoreCase(""))
        		action="esperoDatos";
        
        if (categoria==null || categoria.equalsIgnoreCase(""))
        		categoria="1";
        
        if (cantidad==null || cantidad.equalsIgnoreCase(""))
    		cantidad="1";  
        
        if (pago_total==null || pago_total.equalsIgnoreCase(""))
    		pago_total="1";
        
        if (descuento==null || descuento.equalsIgnoreCase(""))
    		descuento="10";
        
     	/* Hago conversión de datos String a Integer */
	 	
		int categoriaInt=Integer.parseInt(categoria);
		int cantidadInt=Integer.parseInt(cantidad);
		int pago_totalInt=Integer.parseInt(pago_total);
		int descuentoInt=Integer.parseInt(descuento);
		//fecha_compra="23/01/2023";
        
        if (action.equalsIgnoreCase("Guardar")) 
           {
      	   

			
			Comprador comp=new Comprador();
			
			comp.setNombre(nombre);
			comp.setApellido(apellido);
			comp.setFecha_compra(fecha_compra);
			comp.setCant_ticket(cantidadInt);
			comp.setCategoria(categoriaInt);
			comp.setPago_total(pago_totalInt);
			comp.setDescuento(descuentoInt);
			comp.setEmail(email);
			comp.altaCompradorNuevo();
			
      	  }
	    
   %>
    
    <section class="form" id="orador">
        <div class="title">
            <h6>CONVIERTETE EN UN</h6>
            <h2>ORADOR</h2>
            <h3>Anótate como orador para dar una <span class="underline">charla ignite.</span> Cuéntanos de qué quieres
                hablar!</h3>
        </div>
        <div class="container-form">
            <form action="" id="form_orador" name="form_orador">
                <div class="first-last-name">
                    <input type="text" class="input-name" name="input-firtname" placeholder="Nombre" required>
                    <input type="text" class="input-name" name="input-lastname" placeholder="Apellido" required>
                </div>
                <textarea class="input-about" name="input-about" id="" cols="30" rows="6"
                    placeholder="Sobre qué quieres hablar?" required></textarea>
                <h6>Recuerda incluir un título para tu charla</h6>
                <input class="btn-submit" type="submit" value="Enviar">
            </form>
        </div>
    </section>

    <!-- TICKETS -->
    
    <div id="tickets" class="tickets">
        <div class="container-tickets">
            <div class="tickets-category">
                <div class="estudiante">
                    <h3>Estudiante</h3>
                    <h5>Tiene un descuento</h5>
                    <h2>80%</h2>
                    <h6>* presentar documentación</h6>
                </div>
                <div class="trainee">
                    <h3>Trainee</h3>
                    <h5>Tiene un descuento</h5>
                    <h2>50%</h2>
                    <h6>* presentar documentación</h6>
                </div>
                <div class="junior">
                    <h3>Junior</h3>
                    <h5>Tiene un descuento</h5>
                    <h2>15%</h2>
                    <h6>* presentar documentación</h6>
                </div>
            </div>
            <div class="tickets-text">
                <h6>VENTA</h6>
                <h1>VALOR DE TICKET $200</h1>
            </div>
 
 
            <form name="ticketsForm" id="ticketsForm" action="">
        
      			<input type="hidden" name="action" id="action">       
               
                <input type="hidden" name="txt_Pago_total" id="txt_Pago_total"> 
             
                <input type="hidden" name="txtDescuento" id="txtDescuento"> 
                
                <input type="hidden" name="hiddenCategoria" id="hiddenCategoria"> 
                 <input type="hidden" name="txt_fecha_compra" id="txt_fecha_compra"> 
           
            
            
            
                <div class="tickets-form">
                    <input type="text" class="ticketsFirstName" id="txt_Nombre"   name="txt_Nombre"   placeholder="Nombre">
                    <input type="text" class="ticketsLastName"  id="txt_Apellido" name="txt_Apellido" placeholder="Apellido">
                    <input type="email" class="ticketsEmail"    id="txt_Email"    name="txt_Email"    placeholder="E-mail">
                    
                    <div class="labelTicketsQuantity">
                        <label for="txt_Cantidad">Cantidad</label>
                        <input onChange="calculaPrecio()" type="text"  id="txt_Cantidad" value="1" class="ticketsQuantity" name="txt_Cantidad"   placeholder="Cantidad">
                    </div>
                    <div class="labelTicketsCategory">
                        <label for="Categoria">Categoria</label>
                         <select name="Categoria" id="Categoria" class="ticketsCategory" onChange="calculaPrecio()">
                         
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
                    </div>
                    <!-- <output class="ticketsOutput"><span class="ticketsValue">Total a pagar: </span><span class="ticketsBuy"><i class="fa-solid fa-cart-shopping"></i> Comprar</span></output> -->
                    <output class="ticketsOutput">
                    <span class="ticketsValue">Total a pagar: &nbsp;&nbsp;</span>
                    
                  
               
                    <input type="Text" class="ticketsValue" id="totalapagar" name="totalapagar">   
                    <span class="ticketsBuy">Comprar</span></output>
                    <button id="ticketsBorrar" type="reset" class="btnTickets" name="Borrar">Borrar</button>
                    <button id="guard" class="btnTickets"  onclick="Comprar_Ticket()" name="guard">Comprar</button> 
                   
                    
                </div>
            </form>

        </div>
    </div>
    <script type="text/javascript">
		 function Comprar_Ticket()// este procedimieto guarda la nueva unidad
		 {
 	//	  alert("Gracias por Comprar ticket");
 	  	 var x = document.getElementById("Categoria").selectedIndex;
 	     var y = document.getElementById("Categoria").options;
 		  document.ticketsForm.hiddenCategoria.value=y[x].value;
 		  
 		  
  			 document.ticketsForm.action.value="Guardar";
  	 		 document.ticketsForm.submit();
		 }
		 
         /* Se realiza el calculo según la categoría que se eligio de la base y el */
         /* Descuento que se le aplica según sea la categoría asociada*/
		 function calculaPrecio()
		 {
		 var x = document.getElementById("Categoria").selectedIndex;
		 var y = document.getElementById("Categoria").options;
	     var categoria = y[x].value;
	     var porcentaje = 1;
	     var precio = 200;
	    
	     var cantidad = Number(document.getElementById("txt_Cantidad").value);
	     var totaltickets = 0;
	     var total = 0;
	     var totalapagar = 0;
	     
	     switch (categoria)
	       { 
		    case '1': 
    	            porcentaje = 80;
    	            break 
 	        case '2':
 	        		porcentaje = 50;
 	        		break
 	       default: 
		        	porcentaje= 15; 
	       }
	     
	     //calculo de la fecha del dia de la compra
	     const tiempoTranscurrido = Date.now();
	     const hoy = new Date(tiempoTranscurrido);
	     document.ticketsForm.txt_fecha_compra.value =hoy.toLocaleDateString(); // "dd/mm/aaaa" 
	     
	   //  alert("precio:200" + " categoria:" + categoria + " porcentaje:" + porcentaje+ " Fecha:"+ hoy.toLocaleDateString());
	     totaltickets = (cantidad * precio);
	     totalapagar = totaltickets - ((totaltickets * porcentaje)/100);
	    
	     document.getElementById("totalapagar").value = totalapagar;
		   
		  	
		  	
		 }
		 </script>
 
    <!-- FOOTER -->
    <footer class="footer">
        <div class="container-footer">
            <a class="footer-item" href="#">Preguntas frecuentes</a>
            <a class="footer-item" href="#">Contáctanos</a>
            <a class="footer-item" href="#">Prensa</a>
            <a class="footer-item" href="#">Conferencias</a>
            <a class="footer-item" href="#">Términos y condiciones</a>
            <a class="footer-item" href="#">Privacidad</a>
            <a class="footer-item" href="#">Esdudiantes</a>
        </div>
    </footer>


<script>
      calculaPrecio();
</script>

    <script src="main.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>

</html>