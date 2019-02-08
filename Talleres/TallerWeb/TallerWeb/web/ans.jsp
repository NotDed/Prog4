<%-- 
    Document   : ans
    Created on : 8/02/2019, 04:25:24 PM
    Author     : Alejandro Serna Olarte <daniel.serna.olarte at gmail.com>
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Objeto.Opes" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%!
            boolean isInt(String i){
                try{  
                    
                  double d = Integer.parseInt(i); 

                }catch(NumberFormatException nfe){
                    
                  return false; 
                  
                }  
                
                return true; 
            }
            
            String accion(String i, String k){
            int j, n;
                if(isInt(i)&&isInt(k)){
                    j=Integer.parseInt(i);
                    n=Integer.parseInt(k);
                    return j+" + "+n+" = "+Opes.suma(j, n)+"<br/>"+
                           j+" - "+n+" = "+Opes.resta(j, n)+"<br/>"+
                           j+" * "+n+" = "+Opes.multi(j, n)+"<br/>"+
                           j+" / "+n+" = "+Opes.div(j, n)+"<br/>"+
                           j+" % "+n+" = "+Opes.mod(j, n)+"<br/>";
                }
                return "Campos invalidos";
            }
        %>
        <p>Nombre: ${param.Name}</p>
        <p><%= accion(request.getParameter("NumeroU"),request.getParameter("NumeroD"))%></p>
    </body>
</html>
