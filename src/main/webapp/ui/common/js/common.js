(function($){
	//var postUrl="http://localhost:8080/cootooweb";
	var postUrl="/cootooweb";

	$.postJson = function(url,jsonData,callback) {
		
		$.ajax({
			type : "POST",
			url : postUrl+url,
			dataType : "json",
			data:jsonData,
			success : function(backdata) {
				if (typeof(eval('callback')) == "function") {
					callback(backdata);
    	        }
			},
			error : function(backdata) {
				if (typeof(eval('callback')) == "function") {
					callback(backdata);
    	        }
			}
		});
	};
	
	$.getJson = function(url,callback) {
		
		$.ajax({
			type : "GET",
			url : postUrl+url,
			dataType : "json",
			success : function(backdata) {
				if (typeof(eval('callback')) == "function") {
					callback(backdata);
    	        }
			},
			error : function(backdata) {
				if (typeof(eval('callback')) == "function") {
					callback(backdata);
    	        }
			}
		});
	};
	
	
})(jQuery);