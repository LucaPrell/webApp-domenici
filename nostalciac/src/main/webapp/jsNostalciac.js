/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


document.querySelector("#callDB").onclick = function () {
    fetch('http://localhost:8080/nostalciac/resources/tags')
            .then(response => {
                console.log("response...", response);
                return response.json()
            })
            .then(json => creaTabellaDaJson(json, "tag,tipo", "tab1", "tabella", "#contenitore"))
            .catch (x => {alert("err" +x); console.log("err", x)}) 

}

document.querySelector("#b_post").onclick = function () {


    fetch('http://localhost:8080/nostalciac/resources/tags', {
        method: 'post',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            "tag": "pnl32dd",
            "tipo": "comunicazione"

        })
    }).then(function (response) {
        console.log("response:", response)
        return response.json();
    }).catch (res => console.error(  res)  )

}



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


console.log("pagina jsNostalciac")