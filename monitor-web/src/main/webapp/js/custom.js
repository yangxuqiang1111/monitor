$(window).load(function () {
   $('#preloader').delay(350).fadeOut(function () {
      $('body').delay(350).css({'overflow': 'visible'});
   });
});

$(document).ready(function () {
   $('.page-wrapper').css('min-height', $(window).height());
});

$('.nav li').click(function () {
   $(this).addClass('active').siblings().removeClass('active');
});