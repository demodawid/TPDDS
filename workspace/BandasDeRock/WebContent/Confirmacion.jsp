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
<title>Su entrada</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<h:form>
		<h1>Felicitaciones! Su entrada fue comprada exitosamente!</h1>
		<h:outputText value="Su código de entrada es: #{festivalesBB.idEntradaComprada}" style="font-weight:bold; font-size: 30px"/>
		<br>
		<h:outputText value="Datos de la entrada:" style="font-weight:bold;font-size: 20px"/>
		<h:panelGrid columns="2" border="2">
			<h:outputText value="Festival:"/>
			<h:outputText value="#{festivalesBB.festivalSeleccionado.nombre}"/>
	
			<h:outputText value="Noche:"/>
			<h:outputText value="Noche #{festivalesBB.nocheSeleccionada.numero}"/>
	
			<h:outputText value="Bandas:"/>
			<h:dataTable value="#{festivalesBB.nocheSeleccionada.listaBandas}" var="banda">
				<h:column>
					<h:outputText value="#{banda.nombre}"/>
				</h:column>
			</h:dataTable>
	
			<h:outputText value="Fecha:"/>
			<h:outputText value="#{festivalesBB.nocheSeleccionada.fecha}">
				<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
			</h:outputText>
	
			<h:outputText value="Hora de Inicio:"/>
			<h:outputText value="#{festivalesBB.nocheSeleccionada.horaInicio}"/>
	
			<h:outputText value="Sector:"/>
			<h:outputText value="#{festivalesBB.butacaSeleccionada.sector}"/>
	
			<h:outputText value="Precio:"/>
			<c:if test="${festivalesBB.esEntradaAnticipada}">
				<h:outputText value="#{festivalesBB.butacaSeleccionada.precioConDescuento}"/>
			</c:if>
			<c:if test="${!festivalesBB.esEntradaAnticipada}">
				<h:outputText value="#{festivalesBB.butacaSeleccionada.precioBase}"/>
			</c:if>
	
		</h:panelGrid>
		<h:commandButton value="Volver al comienzo" action="volverPrincipal"/>
	</h:form>
</body>
</f:view>
</html>