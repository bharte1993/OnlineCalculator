<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calculator</title>
</head>
<body>
<h>${errormessage}</h>

<form action="Calculation" method="post">
<table>
            <tr>
            <input type="text"  id="display" name="displayValue" value=${calculateValue}><br>
            </tr>
            <tr>
                <input type="button" value="7" onclick="display.value=display.value+value" >
                <input type="button" value="8" onclick="display.value=display.value+value" >
                <input type="button" value="9" onclick="display.value=display.value+value">
                <input type="button" value="+" onclick="display.value=display.value+value"><br>
            </tr>
            <tr>
                <input type="button"  value="4" onclick="display.value=display.value+value">
                <input type="button"  value="5" onclick="display.value=display.value+value">
                <input type="button"  value="6" onclick="display.value=display.value+value">
                <input type="button"  value="-" onclick="display.value=display.value+value"><br>
            </tr>
            <tr>
                <input type="button"  value="1" onclick="display.value=display.value+value">
                <input type="button"  value="2" onclick="display.value=display.value+value">
                <input type="button"  value="3" onclick="display.value=display.value+value">
                <input type="button"  value="*" onclick="display.value=display.value+value"><br>
            </tr>
            <tr>
                <input type="button" value="0" onclick="display.value=display.value+value">
                <input type="button" value="." onclick="display.value=display.value+value">
                <input type="button"  value="C" name="" onclick="display.value=name"/>
                <input type="button" value="/" onclick="display.value=display.value+value"><br>
            </tr>
            <tr>
                <input type="submit" value="=" " >
            </tr>
           </table>
      
</form>

</body>
</html>