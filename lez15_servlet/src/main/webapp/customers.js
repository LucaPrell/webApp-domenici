/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

const elSearch = document.getElementById("search");
const btn = document.getElementById("invia");

btn.addEventListener("click", e => onSearch(e));

function onSearch(e) {
    document.getElementById("querySearch").innerHTML=""
    e.preventDefault();
    console.log("search...", elSearch.value);
    fetch('http://localhost:8080/lez15_servlet/api/customers/search?name=' + elSearch.value)
            .then(response => response.json())
//            .then(json => console.log(json))
            .then(json => creaTabellaDaJson(json,"id,name", "tabAnagrafica","tabella","div"));
    
    
//    creaTabellaDaJson(json(),"id, name", "tabAnagrafica","tabella"));
    
    
    //let oggJson=JSON.parse(response.json());
//    creaTabellaDaJson(response.json(),"id, name", "tabAnagrafica","tabella");
}

/***
 * 
 * @param {type} oggJson
 * @param {type} listaCampi
 * @param {type} idTabella
 * @param {type} classeTabella
 * @param {type} contenitore
 * @returns {undefined}
 */

function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore="body") {
    let tabella = document.createElement("table");
    tabella.id = idTabella;
    tabella.className = classeTabella;

    let vCampi=listaCampi.split(",");
    //    riga intestazione
    let thead= document.createElement("thead");
    let riga= document.createElement("tr");
    vCampi.forEach(function (campo, i) {
        let th=document.createElement("th");
        th.innerHTML= campo;
        riga.append(th);
    });
    
    tabella.append(thead);
    thead.append(riga);
    
    let tBody=document.createElement("tbody");
    oggJson.forEach(function (record,i){
        let rigaRecord=document.createElement("tr");
        vCampi.forEach(function (campo, j) {
            let cella= document.createElement("td");
            cella.innerHTML=oggJson[i][campo];
            rigaRecord.appendChild(cella);
            
        });
        tBody.append(rigaRecord);
    })
    
    tabella.append(tBody);
    //    append della tabella al conteni
    //    tore
    document.querySelector(contenitore).append(tabella);
    
}