$(document).ready(function () {
  // let timer = setTimeout(function () {
  // $(document).ready(function () {
  $('.status').each(function () {
    if ($(this).text() === 'OK') {
      $(this).css({'background-color': 'green'});
      console.log("green worked"); //logging
      // clearTimeout(timer);
    }
    if ($(this).text() === 'NOT WORKING') {
      $(this).css({'background-color': 'gray'});
      console.log("gray worked"); //logging
      // clearTimeout(timer);
    }
    if ($(this).text() === 'DETECTED') {
      $(this).css({'background-color': 'red'});
      console.log("red worked"); //logging
      // clearTimeout(timer);
    }
  });
  // }, 5000);
  // });
});


// autoRefresh();
//
// function autoRefresh() {
//   "use strict";
//   let timer = setTimeout(function () {
//     $(document).ready(function () {
//       $('.status').each(function (index) {
//         if ($(this).text() === 'OK') {
//           $(this).css({'background-color': 'green'});
//           console.log("green worked");
//           clearTimeout(timer);
//           autoRefresh();
//         }
//         if ($(this).text() === 'NOT WORKING') {
//           $(this).css({'background-color': 'gray'});
//           console.log("gray worked");
//           clearTimeout(timer);
//           autoRefresh();
//         }
//         if ($(this).text() === 'DETECTED') {
//           $(this).css({'background-color': 'red'});
//           console.log("red worked");
//           clearTimeout(timer);
//           autoRefresh();
//         }
//       });
//     });
//   }, 5000);
// }