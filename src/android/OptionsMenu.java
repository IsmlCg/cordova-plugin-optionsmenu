//Copyright (c) 2014 Sang Ki Kwon (Cranberrygame)
//Email: cranberrygame@yahoo.com
//Homepage: http://cranberrygame.github.io
//License: MIT (http://opensource.org/licenses/MIT)
package com.cranberrygame.cordova.plugin.optionsmenu;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.PluginResult;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;
import android.annotation.TargetApi;
import android.app.Activity;
import android.util.Log;
//
import android.view.Menu;
import android.view.MenuItem;

public class OptionsMenu extends CordovaPlugin {
	private static final String LOG_TAG = "OptionsMenu";
	protected CallbackContext callbackContextKeepCallback;
	private String menus; 
	
	@Override
	public boolean execute(String action, JSONArray args,CallbackContext callbackContext) throws JSONException {
		//args.length()
		//args.getString(0)
		//args.getString(1)
		//args.Int(0)
		//args.Int(1)
		//args.getBoolean(0)
		//args.getBoolean(1)

		if (action.equals("setUp")) {
			callbackContextKeepCallback = callbackContext;
		}			
		else if (action.equals("setMenus")) {
			//Activity activity=cordova.getActivity();
			//webView			
			String menus = args.getString(0);								
			Log.d("Menu", menus);
			
			this.menus = menus;
		}		
		else if (action.equals("showMenus")) {
			//Activity activity=cordova.getActivity();
			//webView			

			cordova.getActivity().openOptionsMenu();
		}

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
					
			//webView.loadUrl(String.format("javascript:cordova.fireDocumentEvent('onMenuSelected', {'menu': '%s'});", item.getTitle()));

			Log.d(LOG_TAG, "onOptionsItemSelected: "+ item.getTitle());
			
			JSONObject result = new JSONObject();
			try {
				result.put("event", "onMenuSelected");
				result.put("message", item.getTitle());
			}
			catch(JSONException ex){
			}			
			//PluginResult pr = new PluginResult(PluginResult.Status.OK, "onMenuSelected");
			PluginResult pr = new PluginResult(PluginResult.Status.OK, result);
			pr.setKeepCallback(true);
			callbackContextKeepCallback.sendPluginResult(pr);
			//PluginResult pr = new PluginResult(PluginResult.Status.ERROR);
			//pr.setKeepCallback(true);
			//callbackContextKeepCallback.sendPluginResult(pr);				
        }

        return null;
    }	
}