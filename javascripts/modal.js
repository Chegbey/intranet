

//When the user clicks on the button, open the modal
function addmodal(identifier) {

    // Get the button that opens the modal
    var btn = document.getElementById("myBtn"+identifier);
    var number = document.getElementById("myBtn"+identifier).value;
    var main = document.getElementById("main");

    var html = '<div id="myModal" class="modal" style="display: block;">' +
        '<div class="modal-content modal-height">' +
            '<div class="scrollbar">' +
                '<div class="container-modal">' +
                    '<div class="header-modal">' +
                        '<h4 class="top element-left">01206</h4>' +
                        '<h3 class="top element-center">Projet</h3>' +
                        '<div class="top element-right">' +
                          '<span class="close-modal close-modal-margin"></span>' +
                        '</div>' +
                    '</div>' +

                    '<div class="card-group">' +

                        '<div class="card text-xs-center">' +
                            '<div class="card-block">' +
                               '<h4 class="card-title">INFORMATIONS</h4>' +
                               '<p class="card-text">Numéro du secteur :</p>' +
                               '<p class="card-text">Macroprojet :</p>' +
                               '<p class="card-text">Demandeur :</p>' +
                               '<p class="card-text">Responsable :</p>' +
                            '</div>' +
                        '</div>' +

                        '<div class="card text-xs-center">' +
                             '<div class="card-block">' +
                               '<h4 class="card-title">DEVIS</h4>' +
                               '<p class="card-text">Auteur</p>' +
                               '<p class="card-text">Référence :</p>' +
                               '<p class="card-text">Nombre de jours annoncé :</p>' +
                               '<p class="card-text">Marge annoncée : ?%</p>' +
                               '<p class="card-text">Date d\'acceptation du devis:</p>' +
                             '</div>' +
                        '</div>' +

                    '</div>' +
                     '<div class="bottom-modal">' +
                        '<div class="bottom element-center comment">'+
                            '<h4 class="marge">Commentaire</h4>' +
                            '<p> Ceci est un commentaire !</p>'+
                        '</div>' +
                    '</div>' +
                '</div>' +
                '<div class="container-modal">' +
                    '<div class="header-modal">' +
                        '<h4 class=" top element-center text-center">Date</h4>' +
                    '</div>' +
                    '<div class="bottom-modal">' +
                        '<p class="bottom element-left">Début :</p>' +
                        '<p class="bottom element-center">Fin :</p>' +
                        '<p class="bottom element-right">Cause :</p>' +
                    '</div>' +
                '</div>' +
                    '<div class="container-bouton">' +
                        '<span class="bouton-see" id="bouton-see">' +
                        '</span>' +
                        '<h5 class="text-see" >Voir les lots</h5>' +
                    '</div>' +
            '</div>' +
        '</div>' +
    '</div>';
     main.innerHTML =html;

    // Get the modal
var modal = document.getElementById('myModal');


// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close-modal")[0];
var suite = document.getElementsByClassName("bouton-see")[0];

// When the user clicks on <span> (x), close the modal

span.onclick = function() {
    modal.style.display = "none";

}

suite.onclick = function() {

    modal.style.display = "none";


     var html = '<div id="myModal" class="modal" style="display: block;">' +

        '<div class="modal-content modal-height">' +
            '<div class="scrollbar">' +
                 '<div class="container-modal">' +
                     '<div class="header-modal header-modal-padding">' +
                         '<div class="previous top element-left">' +
                            '<span class="left"></span>' +
                         '</div>' +
                         '<h4 class="top element-center">Lots</h4>' +
                         '<div class="top element-right">' +
                            '<span class="close-modal"></span>' +
                         '</div>' +
                    '</div>' +
                 '</div>' +



                 '<div class="card-deck-wrapper">'+
                    '<div class="card-deck">'+

                      '<div class="card card-animation">'+
                        '<div class="header-card">' +
                          '<h4 class="card-title text-center"> 01</h4>' +
                        '</div>' +
                        '<div class="card-block card-block-padding">'+
                          '<h4 class="card-title text-center">Card title</h4>'+
                          '<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>'+
                        '</div>'+
                        '<div class="footer-card">'+
                            '<p class="text-center">Last updated 3 mins ago</p>'+
                        '</div>'+
                      '</div>'+

                      '<div class="card card-animation">'+
                        '<div class="header-card">' +
                          '<h4 class="card-title text-center"> 02</h4>' +
                        '</div>' +
                        '<div class="card-block card-block-padding">'+
                          '<h4 class="card-title text-center">Card title</h4>'+
                          '<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>'+
                        '</div>'+
                        '<div class="footer-card">'+
                            '<p class="text-center">Last updated 3 mins ago</p>'+
                        '</div>'+
                      '</div>'+

                      '<div class="card card-animation">'+
                        '<div class="header-card">' +
                          '<h4 class="card-title text-center"> 03</h4>' +
                        '</div>' +
                        '<div class="card-block card-block-padding">'+
                          '<h4 class="card-title text-center">Card title</h4>'+
                          '<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>'+
                        '</div>'+
                        '<div class="footer-card">'+
                            '<p class="text-center">Last updated 3 mins ago</p>'+
                        '</div>'+
                      '</div>'+

                    '</div>'+
                '</div>'+

                '<div class="card-deck-wrapper">'+
                    '<div class="card-deck">'+

                     '<div class="card card-animation">'+
                       '<div class="header-card">' +
                         '<h4 class="card-title text-center"> 04</h4>' +
                       '</div>' +
                       '<div class="card-block card-block-padding">'+
                         '<h4 class="card-title text-center">Card title</h4>'+
                         '<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>'+
                       '</div>'+
                       '<div class="footer-card">'+
                        '<p class="text-center">Last updated 3 mins ago</p>'+
                       '</div>'+
                     '</div>'+

                     '<div class="card card-animation">'+
                       '<div class="header-card">' +
                         '<h4 class="card-title text-center"> 05</h4>' +
                       '</div>' +
                       '<div class="card-block card-block-padding">'+
                         '<h4 class="card-title text-center">Card title</h4>'+
                         '<p class="card-text">This is a longer card with supporting text below as a natural lead-in to additional content. This content is a little bit longer.</p>'+
                       '</div>'+
                       '<div class="footer-card">'+
                        '<p class="text-center">Last updated 3 mins ago</p>'+
                       '</div>'+
                     '</div>'+

                    '</div>' +
                 '</div>' +

                 '<div class="container-modal-bottom">' +
                    '<span class="bouton-lot animation-lot"></span>' +
                 '</div>' +

            '</div>' +
        '</div>' +
     '</div>';


     main.innerHTML =html;

  var modal2 = document.getElementById('myModal');

  var span2 = document.getElementsByClassName("close-modal")[0];

  var previous = document.getElementsByClassName("left")[0];

   window.onclick = function(event) {
    if (event.target == modal2) {
        modal2.style.display = "none";
    }

       span2.onclick = function() {
    modal2.style.display = "none";

       }

    previous.onclick = function() {

     modal2.style.display = "none";
      addmodal(identifier);

    }

}
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
}
