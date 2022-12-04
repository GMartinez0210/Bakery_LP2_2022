let rep = document.getElementById("repetir")
rep.addEventListener("change", (e) => {
  	let contra = $("#contrasenna").val()
  	let repetir = e.target.value
  
	let button = $(".register__group button")
 	if(contra === repetir) {
		button.removeClass("outline")
		button.addClass("solid")
		button.removeAttr("disabled")
	} else {
		button.removeClass("solid")
		button.addClass("outline")
		button.attr("disabled", "true")
	}
 	console.log(e.target.value);
})

// $("#repetir").keypress(function (e) {
//   let contra = $("#contrasenna").val()
//   let repetir = e.target.value
  
//   console.log(repetir);
//   console.log(contra);
// })