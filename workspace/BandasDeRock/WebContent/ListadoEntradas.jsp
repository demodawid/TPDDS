<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Listado de entradas</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<h:form>
		<h2>Seleccione la entrada que desea comprar:</h2>
		<h:dataTable>
			<h:commandButton value="#{festivalesBB.nocheSeleccionada.}"/>
		</h:dataTable>
	</h:form>
</body>
</html>