/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Sesion extends HttpServlet {   
     public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

         String nombre;
         String apellido;
        
      //recuperamos los datos del formulario
          nombre = request.getParameter("NOMBRE");
          apellido = request.getParameter("APELLIDO");
         
      HttpSession sesion = request.getSession();
      sesion.setAttribute("resultado", nombre + apellido);

       response.setContentType("text/html");
      //Mostramos los  valores en el cliente
      String claveSesion = (String) sesion.getAttribute("resultado");
      String titulo="";
      PrintWriter out = response.getWriter();
      
        
      if(claveSesion.equals("mar123")){
        titulo = "Sesión correcta";
        out.println("<h2>Bienvenido "+titulo+", "+claveSesion+"</h2>");
        out.println("<img src=\"perrito.jpg\" alt=\"Hola\">");
      }
      else
      {
          
        titulo = "Sesión incorrecta";
        out.println("<h2>Error, usuario y password incorrectos: <br><br>"+titulo+"<br>"+claveSesion+"</h2>");
      }
    }
}
