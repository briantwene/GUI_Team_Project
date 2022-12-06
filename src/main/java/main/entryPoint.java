/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import com.sdev.gui_team_project.Login;
import models.AppModel;

/**
 *
 * @author twene
 */
public class entryPoint {

    private AppModel appState;
    public MainFrame brianFrame;
    public Login jasonFrame;

    public entryPoint() {
        // start both sides of the app
        this.appState = new AppModel();
        this.brianFrame = new MainFrame(appState);

        // runnable function for switching frames
        Runnable switchFrame = () -> switchToBrianFrame();

        // start and hide brianFrame so that user can login
        // this.brianFrame.setVisible(true);

        this.jasonFrame = new Login(switchFrame);
        this.jasonFrame.setAppState(appState);
        this.jasonFrame.setVisible(true);

        // start both sides of the app

    }

    // runnable function for switching sides
    public void switchToBrianFrame() {
        this.brianFrame.setAppState(appState);
        this.brianFrame.setVisible(true);
    }

    public static void main(String[] args) {

        new entryPoint();
    }

}
