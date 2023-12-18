function checkAvailability(url, data, successMessage, successClass, errorMessage, errorClass, messageSelectot, inputSelector) {
	$.ajax({
		type: "POST",
		url: url,
		data: data,
		success: function(response) {
			if (response === "available") {
				$(inputSelector).prop("readonly", true);
				$(messageSelectot).text(successMessage).removeClass(errorClass).addClass(successClass);
			} else {
				$(inputSelector).val("");
				$(messageSelectot).text(errorMessage).removeClass(successClass).addClass(errorClass);
			}
		}
	});
}

function isValidEmail(email) {
	const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
	return emailRegex.test(email);
}

$(document).ready(function() {
	$("#checkIdButton").click(function() {
		let id = $("#id").val();
		checkAvailability("domain.user.usercontroller.CheckIdServlet", { id: id }, "아이디가 사용 가능합니다", "available", "해당 아이디는 이미 사용중입니다", "not-available", ".register-form__id-message", "#id");
	});
	$("#checkEmailButton").click(function() {
		let email = $("#email").val();
		if (isValidEmail(email)) {
			checkAvailability("domain.user.usercontroller.CheckEmailServlet", { email: email }, "이메일이 사용 가능합니다", "available", "해당 이메일은 이미 사용중입니다", "not-available", ".register-form__email-message", "#email");
		} else {
			$(".register-form__email-message").text("유효한 이메일이어야 합니다.").removeClass("available").addClass("not-available");
		}
	});

	$("#checkNicknameButton").click(function() {
		let nickname = $("#nickname").val();
		checkAvailability("domain.user.usercontroller.CheckNicknameServlet", { nickname: nickname }, "닉네임이 사용 가능합니다", "available", "해당 닉네임은 이미 사용중입니다", "not-available", ".register-form__nickname-message", "#nickname");
	});

	$("#confirm-password").on("input", function() {
		let password = $("#password").val();
		let confirmPassword = $("#confirm-password").val();
		if (password === confirmPassword) {
			$(".register-form__password-message").text("비밀번호가 일치합니다").removeClass("not-available").addClass("available");
		} else {
			$(".register-form__password-message").text("비밀번호가 일치하지 않습니다").removeClass("available").addClass("not-available");
		}
	});
	
	$("#submitButton").click(function(event) {
		event.preventDefault();
		let registerForm = $(".register-form");
		let idChecked = $(".register-form__id-message").hasClass("available");
		let passwordChecked = $(".register-form__password-message").hasClass("available");
		let emailChecked = $(".register-form__email-message").hasClass("available");
		let nicknameChecked = $(".register-form__nickname-message").hasClass("available");
		if (idChecked && passwordChecked && emailChecked && nicknameChecked) {
			registerForm.submit();
		} else {
			$(".register-form__submit-message").text("모든 검사를 완료해주세요").addClass("not-available");
		}
	})
})