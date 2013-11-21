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
<title>Error en el retorno</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<br>
	<h:outputText value="Fecha actual: "/>
	<h:outputText value="#{festivalesBB.fechaDeHoy}">
		<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
	</h:outputText>
	<h:form>
		<h2> <h:outputText value="Error en la aplicacion: #{retornoEntradasBB.mensajeDeError}"/> </h2>
		<br>
		<h:commandButton value="Volver al comienzo" action="volverPrincipal"/>
	</h:form>
</body>
</f:view>
</html>