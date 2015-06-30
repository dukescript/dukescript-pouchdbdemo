package com.dukescript.pouchdbdemo.js;

import net.java.html.js.JavaScriptBody;
import net.java.html.js.JavaScriptResource;

@JavaScriptResource(value = "pouchdb-3.6.0.min.js")
public class PouchDB {

    private final Object pouch;

    private PouchDB(Object wrapped) {
        pouch = wrapped;
    }

    public static PouchDB create(String name) {
        PouchDB.init();
        LocalStorage.init();
        return new PouchDB(createImpl(name));
    }
    @JavaScriptBody(args = {  },body = "")
    public static native void init();
    public void addTodo(String todo) {
        
        addTodoImpl(pouch, todo);
    }

    @JavaScriptBody(args = {"pouch", "text"}, body = "console.log('Posting a todo '+text);\n"
            + "console.log(pouch.adapter);\n"
            + "var todo = {\n"
            + "    _id: new Date().toISOString(),\n"
            + "    title: text,\n"
            + "    completed: false\n"
            + "  };\n"
            + "  pouch.put(todo, function callback(err, result) {\n"
            + "    if (!err) {\n"
            + "      console.log('Successfully posted a todo!');\n"
            + "    }\n"
            + "    if (err) {\n"
            + "      console.log('Error '+err);\n"
            + "    }\n"
         
            + "  });")
    public static native void addTodoImpl(Object pouch, String text);

    @JavaScriptBody(args = {"name"}, body = "return new PouchDB(name)")
    private static native Object createImpl(String name);
}
