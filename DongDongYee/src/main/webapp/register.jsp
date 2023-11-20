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
	<div class="form-wrapper">
		<form class="register-form" action="/Test" method="post">
			<h2 class="register-title">회원가입</h2>
			<p>아래 내용을 모두 적어주세요 <br> 인증 절차까지 완료해야 가입이 완료됩니다</p>
			<label class="register-form__label" for="id">아이디</label>
			<div class="register-form__input-with-button">
				<input class="register-form__input" type="text" id="id" name="id" placeholder="아이디를 입력해주세요" required>
				<button class="register-form__button" id="checkIdButton" type="button">중복확인</button>
			</div>
			<div class="register-form__id-message">메세지</div>
			<label class="register-form__label" for="password">비밀번호</label>
			<div class="register-form__input-with-button">
				<input class="register-form__input" type="password" id="password" name="password" placeholder="비밀번호 입력해주세요" required>
			</div>
			<div class="register-form__message-placeholder">메세지</div>
			<label class="register-form__label" for="confirm-password">비밀번호 확인</label>
			<div class="register-form__input-with-button">
				<input class="register-form__input" type="password" id="confirm-password" name="confirm-password" placeholder="비밀번호를 다시 입력해주세요" required>
			</div>
			<div class="register-form__password-message">메세지</div>
			<label class="register-form__label" for="email">이메일</label>
			<div class="register-form__input-with-button">
				<input class="register-form__input" type="email" id="email" name="email" placeholder="이메일을 입력해주세요" required>
				<button class="register-form__button" id="checkEmailButton" type="button">중복확인</button>
			</div>
			<div class="register-form__email-message">메세지</div>
			<label class="register-form__label" for="nickname">닉네임</label>
			<div class="register-form__input-with-button">
				<input class="register-form__input" type="text" id="nickname" name="nickname" placeholder="닉네임을 입력해주세요" required>
				<button class="register-form__button" id="checkNicknameButton" type="button">중복확인</button>
			</div>
			<div class="register-form__nickname-message">메세지</div>
			<div class="register-form__submit-message">메세지</div>
			<div class="register-form__submit">
				<input class="register-form__button" type="submit" id="submitButton" value="가입하기">
			</div>
		</form>
	</div>
	<%--Todo: include footer--%>
</body>
</html>