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
<title>Retorno de entradas</title>
</head>
<body>
	<h:graphicImage url="/header.jpg"/>
	<br>
	<h:outputText value="Fecha actual: "/>
	<h:outputText value="#{festivalesBB.fechaDeHoy}">
		<f:convertDateTime type="date" pattern="dd/MM/yyyy"/>
	</h:outputText>
	<h1>Ingrese los datos de la entrada a retornar:</h1>
	<h:form>
		<h:outputLabel for="inputIdEntrada" value="Codigo de entrada:"/>
		<h:inputText id="inputIdEntrada" converterMessage="Ingrese codigo NUMERICO de entrada.">
			<f:convertNumber pattern="#0" />
		</h:inputText>
		<h:message for="inputIdEntrada"/>
	</h:form>
</body>
</f:view>
</html>