package com.nabin.onlinespareparts.controller;

import com.nabin.onlinespareparts.model.UserData;

public class ControllerClass {
    public boolean CheckUser(UserData sd) {
        if ((sd.getName().equals("nabin")) && (sd.getPassword().equals("nabin"))) {
            return true;

        } else {
            return false;
        }
    }

}
