/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author twene
 *
 *
 *
 */
public class RouterController {

    //string for homepage
    public static final String HOME = "home";
    public static final String RENT = "rent";
    public static final String PURCHASE = "purchase";
    public static final String ACCOUNT = "Account";
    public static final String INFO = "info";

    //variable for current page
    private Component currentPage = null;

    //variable for panel that will hold the container and cardLayout object
    private Container parent;
    private CardLayout cardLayout;
    private ArrayList<Component> views;
    private HashMap<Component, String> pageNames;

    //constructor
    public RouterController(Container parent, CardLayout cardLayout) {
        this.parent = parent;
        this.cardLayout = cardLayout;
        views = new ArrayList<>(25);
        pageNames = new HashMap<>(25);

    }

    //adding a view
    public void addView(Component comp, String name) {
        if (!HOME.equals(name)) {
            views.add(comp);
        }
        pageNames.put(comp, name);
        getParent().add(comp, name);
    }

    public void removeView(Component comp, String name) {
        views.remove(comp);
        pageNames.remove(comp);
        getParent().remove(comp);
    }

    //go home
    public void goHome() {
        currentPage = null;
        getCardLayout().show(getParent(), HOME);
    }

    public void goRentals() {
        currentPage = null;
        getCardLayout().show(getParent(), RENT);
    }

    public void goPurchases() {
        currentPage = null;
        getCardLayout().show(getParent(), PURCHASE);
    }

    public void goAccountPage() {
        currentPage = null;
        getCardLayout().show(getParent(), ACCOUNT);
    }

    public void goInfoPage() {
        currentPage = null;
        getCardLayout().show(getParent(), INFO);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public Container getParent() {
        return parent;
    }

}
