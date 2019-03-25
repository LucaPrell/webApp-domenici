
<%-- 
    Document   : Index
    Created on : 25-mar-2019, 9.12.29
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="cssNostalciac.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <input type="button" id="callDB" value="collegati DB">
        <input id="in_findID" type="text" placeholder="inserisci l'id">
        <input type="button" id="findID" value="cerca ID">
        <input type="button" id="b_post" value="inserisci TAG">
        <div id="contenitore"></div>
        <script src="jsNostalciac.js" type="text/javascript"></script>
    </body>
</html>