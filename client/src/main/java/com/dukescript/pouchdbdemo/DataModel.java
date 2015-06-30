package com.dukescript.pouchdbdemo;

import com.dukescript.pouchdbdemo.js.PouchDB;
import net.java.html.json.Model;

@Model(className = "Data", targetId="", properties = {
})
final class DataModel {
    private static Data ui;
    /**
     * Called when the page is ready.
     */
    static void onPageLoad() throws Exception {
        ui = new Data();
        ui.applyBindings();
        PouchDB pouchDB = PouchDB.create("todos");
        pouchDB.addTodo("Hallo");
    }
}
