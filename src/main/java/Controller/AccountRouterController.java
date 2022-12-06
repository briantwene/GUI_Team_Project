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
 *         original idea:
 *
 *
 */

// controller for navigating nested pages in the account page
// very built the same way as the main RouterController
public class AccountRouterController {

    // string constants for the different pages that are there
    public static final String DETAILS = "details";
    public static final String HISTORY = "history";
    public static final String CURRENT = "current";

    // variable for holding the update page function

    // variable for current page
    private UpdateInterface currentPage = null;

    // variable for panel that will hold the container and cardLayout object
    private Container parent;
    private CardLayout cardLayout;

    // variables that would a reference to the nested views on the accounts view
    private ArrayList<UpdateInterface> views;

    // a map for accessing the components by name
    private HashMap<String, UpdateInterface> pageNames;

    // constructor
    public AccountRouterController(Container parent, CardLayout cardLayout) {
        this.parent = parent;
        this.cardLayout = cardLayout;
        this.views = new ArrayList<>(25);
        pageNames = new HashMap<>(25);

    }

    // adding a view to the navigator
    public void addView(UpdateInterface comp, String name) {
        // if (!DETAILS.equals(name)) {
        // views.add(comp);
        // }
        pageNames.put(name, comp);
        getParent().add((Component) comp, name);
    }

    // for removing the views just in case ??
    public void removeView(JPanel comp, String name) {
        // views.remove(comp);
        pageNames.remove(name);
        getParent().remove(comp);
    }

    // functions for moving between views
    public void goDetail() {

        currentPage = pageNames.get(DETAILS);
        currentPage.updatePage();
        getCardLayout().show(getParent(), DETAILS);
    }

    public void goHistory() {

        currentPage = pageNames.get(HISTORY);
        currentPage.updatePage();
        getCardLayout().show(getParent(), HISTORY);
    }

    public void goCurrent() {
        currentPage = pageNames.get(CURRENT);
        currentPage.updatePage();
        getCardLayout().show(getParent(), CURRENT);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public Container getParent() {
        return parent;
    }

}
