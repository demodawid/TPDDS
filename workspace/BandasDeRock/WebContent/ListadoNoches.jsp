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
<title>Listado de noches</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<br>
	<h:outputText value="Fecha actual: "/>
	<h:outputText value="#{festivalesBB.fechaDeHoy}">
		<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
	</h:outputText>
	<h:form>
		<h2>Listado de bandas por noche:</h2>
		<h:dataTable value="#{festivalesBB.festivalSeleccionado.noches }" var="noche" border="1">
			<h:column>
				<f:facet name="header"><h:outputText value="Noche"/></f:facet>
				<h:outputText value="Noche #{noche.numero}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Bandas"/></f:facet>
				<h:dataTable value="#{noche.listaBandas}" var="banda">
					<h:column>
						<h:outputText value="#{banda.nombre}"/>
					</h:column>
				</h:dataTable>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Fecha"/></f:facet>
				<h:outputText value="#{noche.fecha}">
					<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
				</h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Fecha límite para compra anticipada"/></f:facet>
				<h:outputText value="#{noche.fechaFinAnticipada}">
					<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
				</h:outputText>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Hora de inicio"/></f:facet>
				<h:outputText value="#{noche.horaInicio}"/>
			</h:column>
		</h:dataTable>
		<h2>Seleccione la noche:</h2>
		<h:selectOneMenu id="seleccionNoche" value="#{festivalesBB.nocheSeleccionadaItem}">
			<f:selectItems value="#{festivalesBB.nochesItems}"/>
		</h:selectOneMenu>
		<br>
		<h:commandButton value="Seleccionar Noche" action="#{festivalesBB.buscarEntrada}"/> 
		<h:selectBooleanCheckbox title="anticipada"	value="#{festivalesBB.esEntradaAnticipada}" />
		<h:outputText value="Es entrada anticipada?"/>
		<br>
		<h:commandButton value="<-- Anterior" action="volverSeleccionFestival"/>
		<h:commandButton value="Volver al comienzo" action="volverPrincipal"/>
	</h:form>
</body>
</f:view>
</html>