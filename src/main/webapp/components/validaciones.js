function isNumber(value) {
	return value == +value
}

function isAlphabetic(value) {
	const regExp = /^[a-z]+$/i
	return regExp.test(value)
}

const alphabetics = document.querySelectorAll(".validation-alphabetic")
alphabetics.forEach(alphabetic => {
	alphabetic.addEventListener("keypress", (event) => {		
		const { key } = event
								
		if(key === " ") {
			return
		}
								
		if(!isAlphabetic(key)) {
			event.preventDefault()
			return
		}	
	})
	
	alphabetic.addEventListener("blur", (event) => {
		const { target: { value } } = event
				
		alphabetic.value = value.trim()
	})
})

const numbers = document.querySelectorAll(".validation-number")
numbers.forEach(number => {
	number.addEventListener("keypress", (event) => {		
		const { key } = event
																
		if(!isNumber(key)) {
			event.preventDefault()
			return
		}	
	})
})