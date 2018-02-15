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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String calculateString=request.getParameter("displayValue");
        ScriptEngineManager manager= new ScriptEngineManager();
        ScriptEngine engine=manager.getEngineByName("js");
        try {
        	Object result = engine.eval(calculateString);
        	request.setAttribute("calculateValue",result );
        	request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
            System.out.println(result);
        }
        catch(Exception e){
        	
        	System.out.println("Syntex error");
        	request.setAttribute("errormessage", "Syntex error");
        	request.getRequestDispatcher("/getCalculator.jsp").forward(request, response);
        }
        
        System.out.println(calculateString);
        
    }

}
