/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.Menu;
import Common.Algorithm;

/**
 *
 * @author hieu
 */
public class ManagerMenu extends Menu<String> {

    static String[] options = {"Count Word In File", "Find File By Word", "Exit"};
    Algorithm ar;

    public ManagerMenu() {
        super("========== Word Program ==========", options);
        ar = new Algorithm();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                ar.countWordInFile();
                break;
            case 2:
                ar.findFileByWord();
                break;
            case 3:
                System.exit(0);

        }
    }

}
