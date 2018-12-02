/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function pegarVariaveisDaUrl()
{
    var erro = [];
    var msg = window.location.href.slice(window.location.href.indexOf('?') + 1);
    erro = msg.split('=');
    console.log(erro[1]);
    if (erro[1] === 'true') {
        document.getElementById("erro").innerHTML = "Nome de Usuario ou/e Senha incorreto(s)";

    }
}
window.onload = function () {
    pegarVariaveisDaUrl();
};
//