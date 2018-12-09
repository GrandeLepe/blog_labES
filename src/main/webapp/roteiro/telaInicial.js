/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
window.onload = function ()
{

};

function mouseDentro(id) {

    document.getElementById(id).style.border = '2px solid coral';
    document.getElementById(id).style.padding = '18px';

}

function mouseFora(id) {
    document.getElementById(id).style.border = 'none';
    document.getElementById(id).style.padding = '20px';
}

function trocaFonte(id) {

    $("#alteraFonte").change(function () {
        $('.h1Titulo').css("font-family", 'MyWebFont');
    }());
}

