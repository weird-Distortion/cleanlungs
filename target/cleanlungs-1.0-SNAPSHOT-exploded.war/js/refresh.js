$(document).ready(function () {
  setInterval(function () {
    $('.status').each(function (index) {
      if ($(this).text() === 'OK') {
        $(this).css({'background-color': 'green'});
        console.log("green worked");
      }
      if ($(this).text() === 'NOT WORKING') {
        $(this).css({'background-color': 'gray'});
        console.log("gray worked");
      }
      if ($(this).text() === 'DETECTED') {
        $(this).css({'background-color': 'red'});
        console.log("red worked");
      }
    });
  }, 1000);
});
