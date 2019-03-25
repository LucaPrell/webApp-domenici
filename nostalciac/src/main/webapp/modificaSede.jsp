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
        <!--<link href="cssNostalciac.css" rel="stylesheet" type="text/css"/>-->
        <link href="pure.css" rel="stylesheet" type="text/css"/>
        <link rel="shortcut icon" href="">
        <script src="libreria.js" type="text/javascript"></script>
        <title>modifica SEDI</title>
    </head>
    <body>
        <h1>Modifica SEDI</h1>
        <div id="contenitore"></div>
        <br><br>
        <form class="pure-form pure-form-stacked">
<!--                
    
    
    @Column(name = "mail_sede")
    private String mail;
    
    @Column(name = "note_sede")
    private String note;-->

            <select id="sel_sedi">
                <option value="-1">Scegli la Sede</option>
            </select>
            
            <label for="nome">Nome sede: </label>
            <input type="text" id="nome" class="pure-input-1"><br/>
            
            <label for="indirizzo">Indirizzo: </label>
            <input type="text" id="indirizzo" class="pure-input-1"><br/>
            
            <label for="tel">Tel: </label>
            <input type="text" id="tel" class="pure-input-1" ><br/>
            
            <label for="citta">Città: </label>
            <input type="text" id="citta" size="100"><br/>
            
            <label for="mail">Mail: </label>
            <input type="text" id="mail" size="100"><br/>
            
            <label for="note">Note: </label>
            <input type="text" id="note" size="1000"><br/>
            
            <input type="button" id="b_modSede" value="Conferma modifica">

            <br>

        </form>
        <script src="modificaSede.js" type="text/javascript"></script>
    </body>
</html>