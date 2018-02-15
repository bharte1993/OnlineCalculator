package com.servlet;

import java.io.IOException;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Calculation")
public class Calculation extends HttpServlet{
	
    String  lastoperation ="";
    boolean lastOperationCall=false;
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
	String calculateString=request.getParameter("displayValue");
	boolean	checkOperations=calculateString.contains("+")||calculateString.contains("-")||calculateString.contains("*")||calculateString.contains("/");
    if(checkOperations&&lastOperationCall==false) {
		lastoperation=calculateString.charAt(calculateString.length()-1)+"";
		  for (int i=calculateString.length()-2;i>0; --i){
		      lastoperation=(calculateString.charAt(i)+lastoperation);
		      if(calculateString.charAt(i) == '+'||calculateString.charAt(i) == '-'||calculateString.charAt(i) == '*'||calculateString.charAt(i) == '/'){
		            break;
		       }
		 }
	}
		  System.out.println(lastoperation);
		  ScriptEngineManager manager= new ScriptEngineManager();
	      ScriptEngine engine=manager.getEngineByName("js");
		  
		  if(checkOperations&&lastOperationCall==false){
		      try {
		        	//lastOperationCall=true;
		        	Object result = engine.eval(calculateString);
		        	request.setAttribute("calculateValue",result );
		        	request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
		            System.out.println(result);
		        }
		        catch(Exception e){
		        	
		        	System.out.println("Syntex Error");
		        	request.setAttribute("errormessage", "Syntex error");
		        	request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
		        }
            }
		  
       else{ 
    	   System.out.println("else");
    	   try {
               calculateString=calculateString+lastoperation;
               Object result = engine.eval(calculateString);
               request.setAttribute("calculateValue",result );
	           request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
	        }
	        catch(Exception e){
	        	
	        	System.out.println("Syntex Error");
	        	request.setAttribute("errormessage", "Syntex error");
	        	request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
	        }
    	       
             }      
    }

}
