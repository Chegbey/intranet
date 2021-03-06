$(document).ready(function() {
  $(".search").keyup(function() {
    var searchTerm = $(".search").val();
    var listItem = $('.results tbody').children('tr');
    var searchSplit = searchTerm.replace(/ /g, "'):containsi('")

    $.extend($.expr[':'], {
      'containsi': function(elem, i, match, array) {
        return (elem.textContent || elem.innerText || '').toLowerCase().indexOf((match[3] || "").toLowerCase()) >= 0;
      }
    });

    $(".results tbody tr").not(":containsi('" + searchSplit + "')").each(function(e) {
      $(this).attr('visible', 'false');
    });

    $(".results tbody tr:containsi('" + searchSplit + "')").each(function(e) {
      $(this).attr('visible', 'true');
    });

    var jobCount = $('.results tbody tr[visible="true"]').length;
    if ( jobCount == 1 || jobCount == 0)
    	{
    	 $('.counter').text(jobCount + ' Projet');
    	}
    else 
    	{
    	$('.counter').text(jobCount + ' Projets');
    	}
    

    if (jobCount == '0') {
      $('.no-result').show();
    } else {
      $('.no-result').hide();
    }
  });
});