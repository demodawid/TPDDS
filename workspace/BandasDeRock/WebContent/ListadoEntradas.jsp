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
<title>Listado de entradas</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<h:form>
		<h2>Seleccione la entrada que desea comprar:</h2>
		<h:dataTable value="#{festivalesBB.nocheSeleccionada.butacas}" var="butaca" border="1">
			<h:column>
				<f:facet name="header"><h:outputText value="Numero"/></f:facet>
				<h:outputText value="#{butaca.numero}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Sector"/></f:facet>
				<h:outputText value="#{butaca.sector}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Disponible?"/></f:facet>
				<h:outputText value="#{butaca.disponible}"/>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Precio"/></f:facet>
				<c:if test="${festivalesBB.esEntradaAnticipada}">
					<h:outputText value="#{butaca.precioConDescuento}"/>
				</c:if>
				<c:if test="${!festivalesBB.esEntradaAnticipada}">
					<h:outputText value="#{butaca.precioBase}"/>
				</c:if>
			</h:column>
			<h:column>
				<f:facet name="header"><h:outputText value="Comprar"/></f:facet>
				<h:commandButton value="Comprar" rendered="#{butaca.disponible eq 'Si'}" action="#{festivalesBB.armarCompraEntrada}">
					<f:setPropertyActionListener value="#{butaca.idButaca}" target="#{festivalesBB.idButacaSeleccionada}"/>
				</h:commandButton>
			</h:column>
		</h:dataTable>
		<h:commandButton value="<-- Anterior" action="volverAListaNoches"/>
		<h:commandButton value="Volver al comienzo" action="volverPrincipal"/>
	</h:form>
</body>
</f:view>
</html>