
module.exports = {
   
	setUp: function() {
		var self = this;	
        cordova.exec(
            function (result) {
				if (typeof result == "string") {
/*				
					if (result == "onMenuSelected") {					
						if (self.onMenuSelected)
							self.onMenuSelected();
					}					
*/					
				}
				else {
					var event = result["event"];
					var menu = result["message"];				
					if (event == "onMenuSelected") {
						if (self.onMenuSelected)
							self.onMenuSelected(menu);
					}
				}			
			}, 
			function (error) {
			},
            'OptionsMenu',
            'setUp',			
            []
        ); 
    },   
	setMenus: function(menus) {
		cordova.exec(
		function (result) {
		}, 
		function (error) {
		}, "OptionsMenu", "setMenus", [menus]);		
    },
	showMenus: function() {
		cordova.exec(
		function (result) {
		}, 
		function (error) {
		}, "OptionsMenu", "showMenus", []);			
    },
	onMenuSelected: null	
};
