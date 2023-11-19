function checkAvailability(url, data, avMessage, avClass, naMessage, naClass, messageSelectot, inputSelector) {
	$.ajax({
		type: "POST",
		url: url,
		data: data,
		success: function(response) {
			if (response === "available") {
				$(messageSelectot).text(avMessage).removeClass(naClass).addClass(avClass);
			} else {
				$(messageSelectot).text(naMessage).removeClass(avClass).addClass(naClass);
				$(inputSelector).val("");
			}
		}
	});
}

$(document).ready(function() {
	$("#checkIdButton").click(function() {
		let id = $("#id").val();
		checkAvailability("http://localhost:8080/DongDongYee/CheckIdServlet", { id: id }, "아이디가 사용 가능합니다", "available", "해당 아이디는 이미 사용중입니다", "not-available", ".register-form__id-message", "#id");
	});

	$("#checkEmailButton").click(function() {
		let email = $("#email").val();
		checkAvailability("http://localhost:8080/DongDongYee/CheckEmailServlet", { email: email }, "이메일이 사용 가능합니다", "available", "해당 이메일은 이미 사용중입니다", "not-available", ".register-form__email-message", "#email");
	});

	$("#checkNicknameButton").click(function() {
		let nickname = $("#nickname").val();
		checkAvailability("http://localhost:8080/DongDongYee/CheckNicknameServlet", { nickname: nickname }, "닉네임이 사용 가능합니다", "available", "해당 닉네임은 이미 사용중입니다", "not-available", ".register-form__nickname-message", "#nickname");
	});

	$("#confirm-password").on("input", function() {
		let password = $("#password").val();
		let confirmPassword = $("#confirm-password").val();
		if (password === confirmPassword) {
			$(".register-form__password-message").text("비밀번호가 일치합니다").removeClass("password-unmatch").addClass("password-match");
		} else {
			$(".register-form__password-message").text("비밀번호가 일치하지 않습니다").removeClass("password-match").addClass("password-unmatch");
		}
	});

	$("#submitButton").prop("disabled", true);

	function checkInputs() {
		let idChecked = $("#id").hasClass("available");
		let emailChecked = $("#email").hasClass("available");
		let nicknameChecked = $("#nickname").hasClass("available");
		$("#submitButton").prop("disabled", !(idChecked && emailChecked && nicknameChecked));
	}
})