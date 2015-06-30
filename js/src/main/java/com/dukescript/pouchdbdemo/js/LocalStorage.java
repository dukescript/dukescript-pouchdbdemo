package com.dukescript.pouchdbdemo.js;

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

@JavaScriptResource(value = "pouchdb.localstorage.min.js")
public class LocalStorage {

    @JavaScriptBody(args = {  },body = "")
    public static native void init();
}
