<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>동동이 | 회원가입</title>
<link href="./css/register.css" type="text/css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="./js/register.js"></script>
</head>
<body>
	<%--Todo: include header--%>
	<h2>회원가입</h2>
	<p>아래 내용을 모두 적어주세요 <br> 인증 절차까지 완료해야 가입이 완료됩니다</p>
	<form class="register-form" action="/Test" method="post">
		<label class="register-form__label" for="id">아이디</label>
		<div>
			<input class="register-form__input" type="text" id="id" name="id" required>
			<button class="register-form__button" id="checkIdButton" type="button">중복확인</button>
		</div>
		<div class="register-form__id-message"></div>
		<label class="register-form__label" for="password">비밀번호</label>
		<div>
			<input class="register-form__input" type="password" id="password" name="password" required>
		</div>
		<label class="register-form__label" for="confirm-password">비밀번호 확인</label>
		<div>
			<input class="register-form__input" type="password" id="confirm-password" name="confirm-password" required>
		</div>
		<div class="register-form__password-message"></div>
		<label class="register-form__label" for="email">이메일</label>
		<div>
			<input class="register-form__input" type="email" id="email" name="email" required>
			<button class="register-form__button" id="checkEmailButton" type="button">중복확인</button>
		</div>
		<div class="register-form__email-message"></div>
		<label class="register-form__label" for="nickname">닉네임</label>
		<div>
			<input class="register-form__input" type="text" id="nickname" name="nickname" required>
			<button class="register-form__button" id="checkNicknameButton" type="button">중복확인</button>
		</div>
		<div class="register-form__nickname-message"></div>
		<input type="submit" id="submitButton" value="가입하기">
		<div class="register-form__submit-message"></div>
	</form>
	<%--Todo: include footer--%>
</body>
</html>