// Contants
const modal = $(".delete__wrapper");

function showPassword(id, classField) {
  const input = $(id);
  const type = input.attr("type") === "password" ? "text" : "password";
  const circle = $(`.perfil__show-${classField} circle`);

  if(input.attr("type") === "password") {
    circle.css("fill", "#fff");
    circle.css("stroke", "#7D2A0C");
  } else {
    circle.css("fill", "#7D2A0C");
  }

  input.attr("type", type);
}

// Handle the "click" event for show value of the password field
$(".perfil__show-pass").click(() => showPassword("#password", "pass"));
$(".perfil__show-rep").click(() => showPassword("#repeat", "rep"));


// handle edit mode
$(".edit_perfil").click(() => {
  $(".perfil input").each((index, input) => {
    $(input).removeAttr("disabled");
  });

  $(".perfil__field").each((index, field) => {
    $(field).css("display", "none");
  });
  
  $(".edit").each((index, field) => {
    $(field).css("display", "inherit");  
  });

  
  $(".perfil__input-group").each((index, input) => {
    if(index === 1)  $(input).css("margin-top", "3rem");
  });
})

$(".show-normal").click(() => {
  $(".perfil__field").each((index, field) => {
    $(field).css("display", "inherit");
  });
  
  $(".edit").each((index, field) => {
    $(field).css("display", "none");  
  });

  $(".perfil input").each((index, input) => {
    $(input).attr("disabled", "disabled");
  });

  $(".perfil__input-group").each((index, input) => {
    if(index === 1)  $(input).css("margin-top", "1rem");
  });
})


// * handle the "click" event for show the modal
$(".close_modal").click(() => {
  modal.css("display", "none");
})

$(".open_modal").click(() => {
  modal.css("display", "block");
})

$("#avatar").change(function() {
  let filename = this.files[0].name;
  console.log(filename);
})

const cart = document.querySelector(".cart__icon");
cart.addEventListener("click", () => {
  console.log("elo")
})