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
	<h:form>
		<h:dataTable value="#{festivalesBB.festivales}" var="festi">
			<h:column>
				<h:outputText value="#{festi.idFestival}"/>
			</h:column>
			<h:column>
				<h:outputText value="#{festi.nombre}"/>
			</h:column>
		</h:dataTable>
	</h:form>
</body>
</f:view>
</html>