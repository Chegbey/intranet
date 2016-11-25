/// <reference path="jquery.js" />
/// <reference path="jquery-resizable.js" />
/*
jquery-resizable-table-columns
Version 0.17 - 1/4/2015
� 2015-2016 Rick Strahl, West Wind Technologies
www.west-wind.com
Licensed under MIT License
*/


(function() {
  $("td")
  .css({
    /* required to allow resizer embedding */
    position: "relative"
  })
  /* check .resizer CSS */
  .prepend("<div class='resizer'></div>")
  .resizable({
    resizeHeight: false,
    // we use the column as handle and filter
    // by the contained .resizer element
    handleSelector: "",
    onDragStart: function(e, $el, opt) {
      e.stopPropagation();
      e.preventDefault();
      // only drag resizer
      if (!$(e.target).hasClass("resizer"))
        return false;
      return true;
    }
  });
})();
