/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var gostei = Math.floor(Math.random() * 100);

var inc = (function () {
    var inicio = gostei;
    return function () {
        inicio += 1;
        return inicio;
    };
}());

window.onload = function ()
{   
    
    var bntInsert = document.createElement("button");
//    var em = document.createTextNode("Gostei");
//    bntInsert.appendChild(em);
    var element = document.getElementById("art02");
    element.appendChild(bntInsert);

    document.getElementById("spanGostei").innerHTML = gostei;
    

    document.getElementsByTagName("button")[0].setAttribute("id", "botao");
    btn = document.getElementById("botao");
    btn.innerHTML = "<i class='material-icons'>thumb_up</i>"
    btn.onclick = function () {
        valor = inc();
        document.getElementById('spanGostei').textContent = valor.toString();
    };
};


function pegaNovaCor() {
    var caracteres = '0123456789ABCDEF';
    var cor = '#';
    for (var i = 0; i < 6; i++) {
        cor += caracteres[Math.floor(Math.random() * 16)];
    }
    return cor;
}



function trocaCor() {
    $("#1").css("color", pegaNovaCor());
}
