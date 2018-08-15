autoRefresh();

var timer;

function autoRefresh() {
  "use strict";
  timer = setTimeout(function () {
    $(document).ready(function () {
      $('.status').each(function (index) {
        if ($(this).text() === 'OK') {
          $(this).css({'background-color': 'green'});
          console.log("green worked");
          clearTimeout(timer);
          autoRefresh();
        }
        if ($(this).text() === 'NOT WORKING') {
          $(this).css({'background-color': 'gray'});
          console.log("gray worked");
          clearTimeout(timer);
          autoRefresh();
        }
        if ($(this).text() === 'DETECTED') {
          $(this).css({'background-color': 'red'});
          console.log("red worked");
          clearTimeout(timer);
          autoRefresh();
        }
      });
    });
  }, 5000);
}
// function autoRefresh() {
//   "use strict";
//   let timer = setTimeout(function () {
//     alert("works");
//     autoRefresh();
//     console.log("worked");
//   }, 1000);
// }