/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.CardLayout;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import Controller.UpdateInterface;
import java.awt.Component;

/**
 *
 * @author twene
 *
 *
 *
 */
public class RouterController {

    // string for homepage
    public static final String HOME = "home";
    public static final String RENT = "rent";
    public static final String PURCHASE = "purchase";
    public static final String ACCOUNT = "Account";
    public static final String INFO = "info";
    Runnable updatePage;

    // variable for current page
    private UpdateInterface currentPage = null;

    // variable for panel that will hold the container and cardLayout object
    private Container parent;
    private CardLayout cardLayout;
    private ArrayList<UpdateInterface> views;
    private HashMap<String, UpdateInterface> pageNames;

    // constructor
    public RouterController(Container parent, CardLayout cardLayout) {
        this.parent = parent;
        this.cardLayout = cardLayout;
        this.views = new ArrayList<>(25);
        pageNames = new HashMap<>(25);

    }

    public void attachUpdateFunc(Runnable func) {
        updatePage = func;
    }

    // adding a view
    public void addView(UpdateInterface comp, String name) {
        if (!HOME.equals(name)) {
            views.add(comp);
        }
        pageNames.put(name, comp);
        getParent().add((Component) comp, name);
    }

    public void removeView(JPanel comp, String name) {
        views.remove(comp);
        pageNames.remove(name);
        getParent().remove(comp);
    }

    // go home
    public void goHome() {
        currentPage = pageNames.get(HOME);
        // currentPage.revalidate();
        getCardLayout().show(getParent(), HOME);
    }

    public void goRentals() {
        currentPage = pageNames.get(RENT);
        // currentPage.revalidate();
        getCardLayout().show(getParent(), RENT);
    }

    public void goPurchases() {
        currentPage = pageNames.get(PURCHASE);
        // currentPage.revalidate();
        getCardLayout().show(getParent(), PURCHASE);
    }

    public void goAccountPage() {
        currentPage = pageNames.get(ACCOUNT);
        currentPage.updatePage();
        getCardLayout().show(getParent(), ACCOUNT);
    }

    public void goInfoPage() {
        currentPage = pageNames.get(INFO);
        currentPage.updatePage();

        getCardLayout().show(getParent(), INFO);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public Container getParent() {
        return parent;
    }

}
