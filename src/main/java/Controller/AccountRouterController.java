/**
 *
 * @author twene
 */
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Views.CarInfoView;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;

/**
 *
 * @author twene
 *
 *
 *
 */
public class AccountRouterController {

    //string for homepage
    public static final String DETAILS = "details";
    public static final String HISTORY = "history";
    public static final String CURRENT = "current";

    Runnable updatePage;

    //variable for current page
    private JPanel currentPage = null;

    //variable for panel that will hold the container and cardLayout object
    private Container parent;
    private CardLayout cardLayout;
    private ArrayList<JPanel> views;
    private HashMap<String, JPanel> pageNames;

    //constructor
    public AccountRouterController(Container parent, CardLayout cardLayout) {
        this.parent = parent;
        this.cardLayout = cardLayout;
        this.views = new ArrayList<>(25);
        pageNames = new HashMap<>(25);

    }

    public void attachUpdateFunc(Runnable func) {
        updatePage = func;
    }

    //adding a view
    public void addView(JPanel comp, String name) {
        if (!DETAILS.equals(name)) {
            views.add(comp);
        }
        pageNames.put(name, comp);
        getParent().add(comp, name);
    }

    public void removeView(JPanel comp, String name) {
        views.remove(comp);
        pageNames.remove(name);
        getParent().remove(comp);
    }

    //go home
    public void goDetail() {

        getCardLayout().show(getParent(), DETAILS);
    }

    public void goHistory() {

        //updatePage.run();
        getCardLayout().show(getParent(), HISTORY);
    }

    public void goCurrent() {

        //updatePage.run();
        getCardLayout().show(getParent(), CURRENT);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public Container getParent() {
        return parent;
    }

}
