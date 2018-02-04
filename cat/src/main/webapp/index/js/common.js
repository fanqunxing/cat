;(function(win) {
	var pageWidth = 9.00; /////设计图宽度900/100
	var html = document.documentElement;
	var setHtmlFontSize = function() {
		html.style.fontSize = 
			html.getBoundingClientRect().width/pageWidth +'px';
	}
	setHtmlFontSize();
	window.onresize = setHtmlFontSize;
})(window);