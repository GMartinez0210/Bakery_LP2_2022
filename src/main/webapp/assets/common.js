$(".header__avatar").click(function() {
  $(".nav").css("display", "inherit");
})

$(".nav__close").click(function() {
  $(".nav").css("display", "none");
})

$(".nav").mouseleave(function() {
  console.log("saliendo");
  $(".nav").css("display", "none");
});