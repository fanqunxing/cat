;(function(){

var login = new Login();
login.subimt();
login.rememberPazzword();

function Login()
{
	var $username = $("#form-username");
	var $pazzword = $("#form-pazzword");
	var $loginBtn = $("#login-button");
	var $rememberPazzword = $("#remember-pazzword-selected");
	var isRemember = false;
	
	
	(function Login(){
		var username = localStorage.getItem("username");
		var pazzword = localStorage.getItem("pazzword");
		if(username && pazzword)
		{
			isRemember = true;
			$rememberPazzword.text("√");
			$username.val(username);
			$pazzword.val(pazzword);
		}
		$username.off("focus").on("focus",initInput);
		$pazzword.off("focus").on("focus",initInput);
		
	})();
	
	this.subimt = function()
	{
		$loginBtn.off("click").on("click",subimt);
	}
	
	this.rememberPazzword = function()
	{
		$rememberPazzword.off("click").on("click",rememberPazzword);
	}
	
	
	function initInput()
	{
		$username.removeClass("border-red");
		$pazzword.removeClass("border-red");
	}
	
	function rememberPazzword()
	{
		if(isRemember == false)
		{
			$rememberPazzword.text("√");
			isRemember = true;
		}
		else
		{
			$rememberPazzword.text("");
			isRemember = false;
		}
		
	}
	
	
	function rememberPazzwordTolocalStorage(username,pazzword)
	{
		localStorage.setItem("username",username);
		localStorage.setItem("pazzword",pazzword);
	}
	
	function clearPazzwordTolocalStorage()
	{
		localStorage.removeItem("username");
		localStorage.removeItem("pazzword");
	}
	
	
	function checkPazzwordAndUsername(username,pazzword)
	{
		var bFlag = true;
		do
		{
			if(!username)
			{
				$username.addClass("border-red");
				bFlag = false;
				break;
			}
			if(!pazzword)
			{
				$username.addClass("border-red");
				bFlag = false;
				break;
			}
		}
		while(false)
		return bFlag;
	}
	
	
	
	
	function subimt()
	{
		var username = $username.val();
		var pazzword = $pazzword.val();
		//校验密码和用户名是否为空
		if(!checkPazzwordAndUsername(username,pazzword))
		{
			return;
		}
		//判断密码是否记住
		if(isRemember == true)
		{
			rememberPazzwordTolocalStorage(username,pazzword);
		}
		else
		{
			clearPazzwordTolocalStorage();
		}
		
		$loginBtn.addClass("wait");
		
		$.ajax({
			type:'post',
			url:'/cat/login/login.do',
			data:{
				username:encodeURIComponent(encodeURIComponent(username)),
				pazzword:encodeURIComponent(encodeURIComponent(pazzword))
			},
			success:function(data){
				alert(data);
				$loginBtn.removeClass("wait");
				console.log(data);
			}
		});
	}
	
}
	
	
	
	
})();