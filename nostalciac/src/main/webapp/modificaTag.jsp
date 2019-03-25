<%-- 
    Document   : modificaTag
    Created on : 25-mar-2019, 11.11.31
    Author     : tss
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="cssNostalciac.css" rel="stylesheet" type="text/css"/>
        <script src="libreria.js" type="text/javascript"></script>
        <title>modifica TAG</title>
    </head>
    <body>
        <h1>Modifica TAGS</h1>
        <div id="contenitore"></div>
        <br><br>
        <form>

            <select id="sel_tags">
                <option value="-1">Scegli il Tag</option>
            </select>

            <label for="tipo">Tipo: </label>
            <input type="text" id="tipo">
            <label for="tag">Tag: </label>
            <input type="text" id="tag">
            <input type="button" id="b_modTag" value="Conferma modifica">

            <br>

        </form>
        <script src="modificaTag.js" type="text/javascript"></script>
    </body>
</html>