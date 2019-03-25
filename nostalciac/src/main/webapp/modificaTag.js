/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var jsonTags;

function caricaTag() {
    fetch('http://localhost:8080/nostalciac/resources/tags')
            .then(response => {
                console.log("response...", response);
                return response.json();
            })
            .then(json => {
                creaTabellaDaJson(json, "id,tag,tipo", "tab1", "tabella", "#contenitore");
                jsonTags = json;

            })
            .then(e => caricaSelect())
            .catch(x => {
                alert("err" + x);
                console.log("err", x);
            });

}

caricaTag();

function caricaSelect() {
    jsonTags.forEach((tag, j) => {
        let opt = document.createElement("option");
        opt.innerHTML = tag.id + "--> " + tag.tag + " - " + tag.tipo;
        opt.setAttribute("tag", tag.tag);
        opt.setAttribute("tipo", tag.tipo);
        opt.setAttribute("idTag", tag.id);
        document.querySelector("#sel_tags").append(opt);
    });
}

document.querySelector("#sel_tags").onchange = function (e) {

};


document.querySelector("#sel_tags").onchange = function (e) {

    let indiceOpzione = document.querySelector("#sel_tags").selectedIndex;
    let opzioneSelezionata = document.querySelector("#sel_tags").options[indiceOpzione];

    let idTag = opzioneSelezionata.getAttribute("idTag");
    let tipo = opzioneSelezionata.getAttribute("tipo");
    let tag = opzioneSelezionata.getAttribute("tag");
    document.querySelector("#tag").value = tag;
    document.querySelector("#tipo").value = tipo;
    console.log(idTag, tipo, tag);
};

//}            