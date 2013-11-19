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
	<h:form>
		<h2>Listado de bandas por noche:</h2>
		<h:dataTable value="#{festivalesBB.festivalSeleccionado.noches }" var="noche" border="1">
			<h:column>
				<h:outputText value="Noche #{noche.numero}"/>
			</h:column>
			<h:column>
				<h:dataTable value="#{noche.listaBandas}" var="banda">
					<h:column>
						<h:outputText value="#{banda.nombre}"/>
					</h:column>
				</h:dataTable>
			</h:column>
		</h:dataTable>
		<h2>Seleccione la noche:</h2>
		<h:selectOneMenu id="seleccionNoche" value="#{festivalesBB.nocheSeleccionadaItem}">
			<f:selectItems value="#{festivalesBB.nochesItems}"/>
		</h:selectOneMenu>
		<br>
		<h:commandButton value="<-- Volver" action="#{festivalesBB.volverSeleccionFestival}"/>
	</h:form>
</body>
</f:view>
</html>