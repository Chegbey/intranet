(function() {
    
  var hamburger = document.getElementById('hamburger')
  var menu = document.getElementById('menu')
  var nav = document.getElementById('nav')
  var table = document.getElementById('table')
  
  hamburger.addEventListener('click', (ev) => {
      hamburger.classList.toggle('is-active')
      menu.classList.toggle('header-left')
      nav.classList.toggle('nav-cach')
      table.classList.toggle('container-table')
      table.classList.toggle('container-fluid')
      
  }, false)
  
 
})()