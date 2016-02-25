Cordova Options Menu plugin
====================

# Overview #
Show android options menu.
 
[android] [crodova cli] [xdk]

This is open source cordova plugin.

You can see Cordova Plugins in one page: http://cranberrygame.github.io?referrer=github

# Change log #
```c
```
# Install plugin #

## Cordova cli ##
https://cordova.apache.org/docs/en/edge/guide_cli_index.md.html#The%20Command-Line%20Interface - npm install -g cordova@6.0.0
```c
cordova plugin add cordova-plugin-optionsmenu
```
## Xdk ##
https://software.intel.com/en-us/intel-xdk - Download XDK - XDK PORJECTS - [specific project] - CORDOVA HYBRID MOBILE APP SETTINGS - Plugin Management - Add Plugins to this Project - Third Party Plugins -
```c
Plugin Source: Cordova plugin registry
Plugin ID: cordova-plugin-optionsmenu
```

## Cocoon ##
https://cocoon.io - Create project - [specific project] - Setting - Plugins - Custom - Git Url: https://github.com/cranberrygame/cordova-plugin-optionsmenu.git - INSTALL - Save<br>

## Phonegap build service (config.xml) ##
https://build.phonegap.com/ - Apps - [specific project] - Update code - Zip file including config.xml
```c
<gap:plugin name="cordova-plugin-optionsmenu" source="npm" />
```

## Construct2 ##
Download construct2 plugin<br>
https://dl.dropboxusercontent.com/u/186681453/pluginsforcordova/index.html<br>
How to install c2 native plugins in xdk, cocoon and cordova cli<br>
https://plus.google.com/102658703990850475314/posts/XS5jjEApJYV

# Server setting #

# API #
```javascript
//
var menus = "menu1,menu2,menu3,menu4,menu5,menu6,menu7";

//
document.addEventListener("deviceready", function(){

    window.optionsmenu.setUp();
	
	//callback
	window.optionsmenu.onMenuSelected = function(menu) {
        window.alert(menu);
    };	
}, false);

//
window.optionsmenu.setMenus(menus);

window.optionsmenu.showMenus();
```
# Examples #
<a href="https://github.com/cranberrygame/com.cranberrygame.phonegap.plugin.optionsmenu/blob/master/example/basic/index.html">example/index.html</a><br>

# Test #

[![](http://img.youtube.com/vi/lOp7HNTJu44/0.jpg)](https://www.youtube.com/watch?v=lOp7HNTJu44&feature=youtu.be "Youtube")

# Useful links #

Cordova Plugins<br>
http://cranberrygame.github.io?referrer=github

# Credits #
