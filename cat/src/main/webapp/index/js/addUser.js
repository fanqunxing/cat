
;(function(){

var addUser = new AddUser();
addUser.submit();

function AddUser()
{
	var $username = $("#username");
	var $imail = $("#imail");
	var $pazzword = $("#pazzword");
	var $pazzworded = $("#pazzworded");
	var $submitBtn = $("#submit-btn");
	
	this.submit = function()
	{
		$submitBtn.off("click").on("click",submit);
	}
	
	;(function AddUser()
	{
		$(".js-form-item").find("input").off("focus").on("focus",function(){
			$(this).closest(".js-form-item").removeClass("border-red");
		});
		
	})();
	
	function submit()
	{
		var username = $.trim($username.val());
		var imail = $.trim($imail.val());
		var pazzword = $.trim($pazzword.val());
		var pazzworded = $.trim($pazzworded.val());
		var checkresult = checkform(username, imail, pazzword, pazzworded);
		if(checkresult)
		{
			submitAjax(username, imail, pazzword);
		}
	}
	
	
	function checkform(username, imail, pazzword, pazzworded)
	{
		var bFlag = true;
		do
		{
			if(!username)
			{
				$username.closest(".js-form-item").addClass("border-red");
				bFlag = false;
				break;
			}
			if(!imail)
			{
				$imail.closest(".js-form-item").addClass("border-red");
				bFlag = false;
				break;
			}
			if(!pazzword)
			{
				$pazzword.closest(".js-form-item").addClass("border-red");
				bFlag = false;
				break;
			}
			if(pazzword != pazzworded)
			{
				$pazzworded.closest(".js-form-item").addClass("border-red");
				bFlag = false;
				break;
			}
			
		}while(false);
		
		return bFlag;
	}
	
	function submitAjax(username,imail,pazzword)
	{
		$.ajax({
			type:'post',
			url:'/cat/user/addUser.do',
			data:{
				username:encodeURIComponent(encodeURIComponent(username)),
				pazzword:encodeURIComponent(encodeURIComponent(pazzword)),
				imail:encodeURIComponent(encodeURIComponent(imail))
			},
			success:function(data){
				alert(data);
				console.log(data);
			}
		});
	}
	
}
	
	
	
	
})();