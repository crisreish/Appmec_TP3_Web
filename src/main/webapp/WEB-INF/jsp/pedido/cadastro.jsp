<%--
  Created by IntelliJ IDEA.
  User: usu�rio
  Date: 26/09/2021
  Time: 09:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>APPMEC - Cadastro!!!</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>

<c:set var="botao" value=""/>

<c:import url="/WEB-INF/jsp/menu.jsp"/>

<div class="container">
    <h2>Cadastro de Pedidos</h2>
    <form action="/pedido/incluir" method="post">

        <div class="form-group">
            <c:if test="${not empty solicitantes}">
                <label>Solicitante:</label>
                <select class="form-control" name="solicitante.id">
                    <c:forEach var="s" items="${solicitantes}">
                        <option value="${s.id}">${s.nome}</option>
                    </c:forEach>
                </select>
            </c:if>
            <c:if test="${empty solicitantes}">
                <c:set var="botao" value="disabled"/>
                <label>Solicitante: n�o existem registros cadastrados!!!</label>
            </c:if>
        </div>

        <div class="form-group">
            <label>Descri��o:</label>
            <input value="Primeiro pedido" type="text" class="form-control" placeholder="Entre com a descri��o" name="descricao">
        </div>

        <div class="form-group">
            <c:if test="${not empty equipamentos}">
                <label>Equipamentos:</label>
                <c:forEach var="p" items="${equipamentos}">
                    <div class="form-check">
                        <label class="form-check-label">
                            <input name="equipamentosId" type="checkbox" checked="checked" value="${p.id}"> ${p.descricao}
                        </label>
                    </div>
                </c:forEach>
            </c:if>
            <c:if test="${empty equipamentos}">
                <c:set var="botao" value="disabled"/>
                <label>Equipamentos: n�o existem registros cadastrados!!!</label>
            </c:if>
        </div>

        <button type="submit" ${botao} class="btn btn-default">Cadastrar</button>
    </form>
</div>

</body>
</html>

</body>
</html>
