package controller;

import view.StartWindow;

public class Main {
    public static void main(String[] args) {
        SysData s = SysData.getInstance();
        s.readJSON();
        //new StartWindow();
    }
}
