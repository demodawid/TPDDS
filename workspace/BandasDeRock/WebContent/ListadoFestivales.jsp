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
<title>Listado de festivales</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<br>
	<h:outputText value="Fecha actual: "/>
	<h:outputText value="#{festivalesBB.fechaDeHoy}">
		<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
	</h:outputText>
	<h:form>
		<h2> Seleccione el festival:</h2>
		<h:selectOneMenu id="seleccionFestival" value="#{festivalesBB.festivalSeleccionadoItem}">
			<f:selectItems value="#{festivalesBB.festivalesItems}"/>
			<h:messages/>
		</h:selectOneMenu>
		<br>
		<h:commandButton value="Ver Noches" action="#{festivalesBB.buscarNoches}"/>
		<br>
		<h:commandButton value="<-- Anterior" action="volverPrincipal"/>
		<h:commandButton value="Volver al comienzo" action="volverPrincipal"/>
	</h:form>
</body>
</f:view>
</html>