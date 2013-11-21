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
<title>Desea retornar la entrada?</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<br>
	<h:outputText value="Fecha actual: "/>
	<h:outputText value="#{festivalesBB.fechaDeHoy}">
		<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
	</h:outputText>
	<h:form>
		<h2>Esta seguro de que desea retornar la siguiente entrada?</h2>
		<h:panelGrid columns="2" border="2">
				<h:outputText value="Festival:"/>
				<h:outputText value="#{retornoEntradasBB.festivalDeLaEntradaARetornar.nombre}"/>
	
				<h:outputText value="Noche:"/>
				<h:outputText value="Noche #{retornoEntradasBB.nocheDeLaEntradaARetornar.numero}"/>
				<h:outputText value="Bandas:"/>
				<h:dataTable value="#{retornoEntradasBB.nocheDeLaEntradaARetornar.listaBandas}" var="banda">
					<h:column>
						<h:outputText value="#{banda.nombre}"/>
					</h:column>
				</h:dataTable>
	
				<h:outputText value="Fecha:"/>
				<h:outputText value="#{retornoEntradasBB.nocheDeLaEntradaARetornar.fecha}">
					<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
				</h:outputText>
	
				<h:outputText value="Hora de Inicio:"/>
				<h:outputText value="#{retornoEntradasBB.nocheDeLaEntradaARetornar.horaInicio}"/>
	
				<h:outputText value="Sector:"/>
				<h:outputText value="#{retornoEntradasBB.entradaARetornar.butaca.sector}"/>
	
				<h:outputText value="Precio:"/>
				<h:outputText value="#{retornoEntradasBB.entradaARetornar.precioFinal}"/>
	
		</h:panelGrid>
		
	</h:form>
</body>
</f:view>
</html>