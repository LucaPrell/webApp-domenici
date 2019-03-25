/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function creaTabellaDaJson(oggJson, listaCampi, idTabella, classeTabella, contenitore = "body") {
    let tabella = document.createElement("table")
    tabella.id = idTabella
    tabella.className = classeTabella  //da verif

    let vCampi = listaCampi.split(",")

    //riga intestazione
    let tHead = document.createElement("thead")
    let riga = document.createElement("tr")
    vCampi.forEach(function (campo, i) {
        let th = document.createElement("th")
        th.innerHTML = campo
        riga.append(th)
    })
    tabella.append(tHead)
    tHead.append(riga)

    let tBody = document.createElement("tBody")
    oggJson.forEach(function (record, i) {
        let rigaRecord = document.createElement("tr")
        vCampi.forEach(function (campo, j) {
            let cella = document.createElement("td")
            cella.innerHTML = oggJson[i][campo]  //record[campo]
            rigaRecord.append(cella)
        })
        tBody.append(rigaRecord)
    })

    tabella.append(tBody)

    //append della tabella al contenitore
    document.querySelector(contenitore).append(tabella)
}
