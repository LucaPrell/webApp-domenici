<%-- 
    Document   : customerSearch
    Created on : 15-mar-2019, 14.59.29
    Author     : tss
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cerca Clienti con JSP</title>
    </head>
    <body>
        <h1>Cerca Clienti con JSP</h1>
        <form method="POST" >
            <label for="search">Cerca</label>
            <input id="search" type="text" name="search" value="${param.search}" placeholder="inserisci iniziali"  />
            <input type="submit" name="invia" value="Invia" />
        </form>
        <br/><hr/>

        <c:if test="${not empty param.invia}">
            <c:set var="customers" value="${db.searchCustomer(param.search)}" />
            <c:choose>

                <c:when test="${not empty customers}">
                    <table><c:set var="customers" value="${db.searchCustomer(param.search)}" />
                        <thead>
                            <tr>
                                <th>id</th>
                                <th>nome</th><c:set var="customers" value="${db.searchCustomer(param.search)}" />
                            </tr>
                        </thead><c:set var="customers" value="${db.searchCustomer(param.search)}" />
                        <tbody>
                            <!--richiamo il @Named del DbManager.il metodo e tra parentesi i parametri param.search (name della input)-->
                            <c:forEach items="${db.searchCustomer(param.search)}" var="cust">
                                <tr>
                                    <td>${cust.id}</td>
                                    <td>${cust.name}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <h3>Nessun cliente trovato</h3>
                </c:otherwise>
            </c:choose>    
        </c:if>
    </body>
</html>
