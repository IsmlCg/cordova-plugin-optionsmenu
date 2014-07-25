// Copyright (c) 2014 cranberrygame
// Email: cranberrygame@yahoo.com
// Phonegap plugin: http://www.github.com/cranberrygame
// Construct2 phonegap plugin: https://www.scirra.com/forum/viewtopic.php?f=153&t=109586
//                             https://dl.dropboxusercontent.com/u/186681453/index.html
//                             https://www.scirra.com/users/cranberrygame
// Facebook: https://www.facebook.com/profile.php?id=100006204729846
// License: MIT (http://opensource.org/licenses/MIT)
package com.cranberrygame.phonegap.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import android.app.Activity;
import android.util.Log;
//cranberrygame start
import android.view.Menu;
import android.view.MenuItem;
//cranberrygame end

public class OptionsMenu extends CordovaPlugin {
	private String menus; 
	
	@Override
	public boolean execute(String action, JSONArray args,CallbackContext callbackContext) {
		PluginResult result = null;
		
		try {		
			//args.length()
			//args.getString(0)
			//args.getString(1)
			//args.Int(0)
			//args.Int(1)
			//args.getBoolean(0)
			//args.getBoolean(1)

			if (action.equals("setMenus")) {
				//Activity activity=cordova.getActivity();
				//webView			
				String menus = args.getString(0);								
				Log.d("Menu", menus);
				
				this.menus = menus;
				
				result = new PluginResult(PluginResult.Status.OK);	
			}		
			else if (action.equals("showMenus")) {
				//Activity activity=cordova.getActivity();
				//webView			

				cordova.getActivity().openOptionsMenu();
				
				result = new PluginResult(PluginResult.Status.OK);	
			}
			else {
				result = new PluginResult(PluginResult.Status.INVALID_ACTION);
			}				
		}
		catch (JSONException e) {
		  result = new PluginResult(PluginResult.Status.JSON_EXCEPTION);
		}
		
		callbackContext.sendPluginResult(result);
		return true;		
	}
	  
    @Override
    public Object onMessage(String id, Object data)
    {     
		//https://github.com/dpogue/cordova-plugin-cambie/blob/master/src/android/Cambie.java
		//http://stackoverflow.com/questions/22403984/get-oncreateoptionsmenu-in-cordova-plugin
		//https://github.com/apache/cordova-android/blob/master/framework/src/org/apache/cordova/CordovaPlugin.java#L140
		if (id.equals("onCreateOptionsMenu") || id.equals("onPrepareOptionsMenu"))
        {
            Menu menu = (Menu)data;
			
			if (this.menus != null) {
				menu.clear();

				String[] _menus = this.menus.split(",");
				for (int i=0 ; i<_menus.length ; i++) {
					menu.add(0, i, 0, _menus[i]);
				}      
			}
        }
        else if (id.equals("onOptionsItemSelected"))
        {
			MenuItem item = (MenuItem)data;
					
			webView.loadUrl(String.format("javascript:cordova.fireDocumentEvent('onMenuSelected', {'menu': '%s'});", item.getTitle()));
        }

        return null;
    }	
}