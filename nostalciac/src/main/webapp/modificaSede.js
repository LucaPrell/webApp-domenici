/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var jsonSedi;

function caricaSedi() {
    
    
    fetch('http://localhost:8080/nostalciac/resources/sedi')
            .then(response => {
                console.log("response...", response);
                return response.json();
            })
            .then(json => {
                document.querySelector("#contenitore").innerHTML = "";
                creaTabellaDaJson(json, "id,nome,indirizzo,tel,citta,mail,note", "tab1", "pure-table", "#contenitore");
                jsonSedi = json;
            })
            .then(e => caricaSelect())
            .catch(x => {
                alert("err" + x);
                console.log("err", x);
            });

}

caricaSedi();

function caricaSelect() {
    // cancella contenuto della select
    document.querySelector("#sel_sedi").innerHTML = "";
    
    let opt = document.createElement("option");
    opt.innerHTML = "Scegli il record da modificare";
    opt.value = -1;
    document.querySelector("#sel_sedi").append(opt);

    jsonSedi.forEach((sedi, j) => {
        let opt = document.createElement("option");
        opt.innerHTML = sedi.id + " --> " + sedi.nome ;
        opt.value = j;
        opt.setAttribute("idSedi", sedi.id); //meglio che id
        document.querySelector("#sel_sedi").append(opt);

    });


}



//window.onload = function () {


document.querySelector("#sel_sedi").onchange = function (e) {

    let indiceOpzione = document.querySelector("#sel_sedi").selectedIndex;
    let opzioneSelezionata = document.querySelector("#sel_sedi").options[indiceOpzione];

    let value = opzioneSelezionata.value;
    let idSede = jsonSedi[value].id;
    let nome = jsonSedi[value].nome;
    let indirizzo = jsonSedi[value].indirizzo;
    let tel = jsonSedi[value].tel;
    let citta = jsonSedi[value].citta;
    let mail = jsonSedi[value].mail;
    let note = jsonSedi[value].note;

    //alternativa      
    //let idTag = opzioneSelezionata.getAttribute("idTag")
    //let tipo = opzioneSelezionata.getAttribute("tipo")
    //let tag = opzioneSelezionata.getAttribute("tag")

    document.querySelector("#nome").value = nome;
    document.querySelector("#indirizzo").value = indirizzo;
    document.querySelector("#tel").value = tel;
    document.querySelector("#citta").value = citta;
    document.querySelector("#mail").value = mail;
    document.querySelector("#note").value = note;
    console.log(idSede, nome, indirizzo,tel,citta,mail,note);
};

//}


document.querySelector("#b_modTag").onclick = function () {
    console.log("click su modifica tag")

    let indiceOpzione = document.querySelector("#sel_tags").selectedIndex
    let opzioneSelezionata = document.querySelector("#sel_tags").options[indiceOpzione]

    let value = opzioneSelezionata.value

    let idTag = jsonTags[value].id

    let obj = {}

    obj.tipo = document.querySelector("#tipo").value
    obj.tag = document.querySelector("#tag").value

    console.log("invio", obj)

    fetch('http://localhost:8080/nostalciac/resources/tags/' + idTag, {
        method: 'put',

        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },

        body: JSON.stringify(obj)

    }).then(function (response) {
        console.log("response:", response)
        console.log("response.text():", response.text())
        
        caricaSedi()
        caricaSelect()
        return;
    }).catch(res => console.error("ERRORE:", res))


}