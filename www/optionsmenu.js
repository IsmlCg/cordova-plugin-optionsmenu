
module.exports = {
   
	setMenus: function(successCallback, errorCallback, menus) {
        cordova.exec(
            successCallback,
            errorCallback,
            'OptionsMenu',
            'setMenus',
            [menus]
        ); 
    },
   showMenus: function(successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            'OptionsMenu',
            'showMenus',
            []
        ); 
    }
};
