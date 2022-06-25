


// 에러박스 문구
var blank = "필수 입력 사항입니다.";


$('#btnLogin').click(function(){

	var userId = $.trim($("#userId").val());
	var userPassword = $.trim($("#userPassword").val());


	/* 이메일 */
	if(userId == ''){
		$('label[for="userId"] .error_box').html(blank);
		$('#userId').focus();
    		return;
		}else{
		$('label[for="userId"] .error_box').html("");
		}	
	
	/* 비밀번호 */
	if(userPassword == ''){
		$('label[for="userPassword"] .error_box').html(blank);
		$('#userPassword').focus();
    		return;
		}else{
		$('label[for="userPassword"] .error_box').html("");
		}
	

  $.ajax({
	type : 'get',
	url : '/loginMove',
	data : { id : $("#userId").val(),
		password : $("#userPassword").val()
	 		},
	contentType : 'application/x-www-form-urlencoded;charset=utf-8',
	success : function(result){
		alert(result)
		// 중복 검사 후 나오는 결과 에러박스에 출력
		if(result == "N"){
        		$('.error_box.login').html("존재하는 회원이 아니거나 비밀번호가 일치하지 않습니다.");
			
			}else{
			// 결과가 result = "Y"이면 로그인 성공 -> loginMove.do로 이동

			document.loginForm.submit();
			}
	},
	error : function(err){
		alert(err);
		console.log(err);
	}
	});//end of ajax
	
}); //end of #btnLogin 
