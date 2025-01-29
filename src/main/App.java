/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import service.MasterService;
import service.impl.MasterServiceImpl;
import view.MenuView;

/**392
 * 
 *-*
 * @author deirn*
 */
public class App {

    public static MenuView menuView;
    
    public static MasterService masterService;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        masterService = new MasterServiceImpl();
        menuView = new MenuView();
        menuView.setVisible(true);
    }

}
