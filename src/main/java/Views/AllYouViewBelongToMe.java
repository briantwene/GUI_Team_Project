import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class AllYouViewBelongToMe {

    public static void main(String[] args) {
        new AllYouViewBelongToMe();
    }

    public AllYouViewBelongToMe() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface ViewContoller {

        public void goHome();

        public void nextView();

        public void previousView();

    }

    public static class DefaultViewController implements ViewContoller {

        public static final String HOME = "home";

        private Component currentView = null;
        private List<Component> views;
        private Map<Component, String> mapNames;

        private Container parent;
        private CardLayout cardLayout;

        public DefaultViewController(Container parent, CardLayout cardLayout) {
            this.parent = parent;
            this.cardLayout = cardLayout;
            views = new ArrayList<>(25);
            mapNames = new HashMap<>(25);
        }

        public CardLayout getCardLayout() {
            return cardLayout;
        }

        public Container getParent() {
            return parent;
        }

        public void addView(Component comp, String name) {
            if (!HOME.equals(name)) {
                views.add(comp);
            }
            mapNames.put(comp, name);
            getParent().add(comp, name);
        }

        public void removeView(Component comp, String name) {
            views.remove(comp);
            mapNames.remove(comp);
            getParent().remove(comp);
        }

        @Override
        public void goHome() {
            currentView = null;
            getCardLayout().show(getParent(), HOME);
        }

        @Override
        public void nextView() {
            if (views.size() > 0) {
                String name = null;
                if (currentView == null) {
                    currentView = views.get(0);
                    name = mapNames.get(currentView);
                } else {
                    int index = views.indexOf(currentView);
                    index++;
                    if (index >= views.size()) {
                        index = 0;
                    }
                    currentView = views.get(index);
                    name = mapNames.get(currentView);
                }
                getCardLayout().show(getParent(), name);
            }
        }

        @Override
        public void previousView() {
            if (views.size() > 0) {
                String name = null;
                if (currentView == null) {
                    currentView = views.get(views.size() - 1);
                    name = mapNames.get(currentView);
                } else {
                    int index = views.indexOf(currentView);
                    index--;
                    if (index < 0) {
                        index = views.size() - 1;
                    }
                    currentView = views.get(index);
                    name = mapNames.get(currentView);
                }
                getCardLayout().show(getParent(), name);
            }
        }

    }

    public class TestPane extends JPanel {

        public TestPane() {
            setLayout(new BorderLayout());

            CardLayout cardLayout = new CardLayout();
            JPanel view = new JPanel(cardLayout);

            final DefaultViewController controller = new DefaultViewController(view, cardLayout);
            controller.addView(createPane("home"), DefaultViewController.HOME);
            controller.addView(createPane("Page #1"), "View1");
            controller.addView(createPane("Page #2"), "View2");
            controller.addView(createPane("Page #3"), "View3");
            controller.addView(createPane("Page #4"), "View4");

            controller.goHome();

            JPanel controls = new JPanel();
            JButton btnPrev = new JButton("<");
            JButton btnHome = new JButton("Home");
            JButton btnNext = new JButton(">");

            controls.add(btnPrev);
            controls.add(btnHome);
            controls.add(btnNext);

            btnNext.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.nextView();
                }
            });
            btnPrev.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.previousView();
                }
            });
            btnHome.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    controller.goHome();
                }
            });

            add(view);
            add(controls, BorderLayout.SOUTH);

        }

        protected JPanel createPane(String name) {

            JPanel panel = new JPanel(new GridBagLayout());
            panel.add(new JLabel(name));

            return panel;

        }
    }

}