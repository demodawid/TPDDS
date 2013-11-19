<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<f:view>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>
	<div>
		<h:form>
			<h1>Bienvenido al sistema de compra de entradas</h1>
			<h2>Que desea hacer?</h2>
			<br>
			<h:commandButton value="Comprar entrada" action="#{festivalesBB.buscarFestivales}"/>			
		</h:form>
	</div>
</body>
</f:view>
</html>