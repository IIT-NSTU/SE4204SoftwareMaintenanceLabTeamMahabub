package ChemistryCalculator.frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Sidebar extends JPanel {
    private final JLabel developer_sign_label = new JLabel();
    private final JLabel logoPanel = new JLabel();
    private final JSeparator logoSeparator = new JSeparator();
    private final JScrollPane menuHolderScrollPane = new JScrollPane();
    private final JPanel menuHolder = new JPanel();

    ArrayList<MenuItem> menuItems = new ArrayList<>();
    ArrayList<ContentPanel> containerPanels = new ArrayList<>();

    Color active_menu_color = new Color(255, 255, 153);
    Font active_menu_font = new Font("Segoe UI", Font.BOLD, 15);
    Color normal_menu_color = new Color(221, 221, 221);
    Font normal_menu_font = new Font("Segoe UI", Font.BOLD, 14);
    Cursor pointer = new Cursor(Cursor.HAND_CURSOR);

    public void addMenuFromContentPanels(ArrayList<ContentPanel> containerPanels) {
        this.containerPanels = containerPanels;
        for (ContentPanel panel : containerPanels) {
            this.menuItems.add(new MenuItem(panel));
        }
        build();
    }

    //after adding all menus, this method must be called to create a sidebar.
    private void build() {
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {
        this.setBackground(new Color(54, 33, 89));
        menuHolderScrollPane.setBorder(null);
        menuHolderScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        menuHolder.setBackground(new Color(54, 33, 89));
        menuHolderScrollPane.setViewportView(menuHolder);

        logoPanel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        logoPanel.setForeground(new Color(221, 221, 221));
        logoPanel.setHorizontalAlignment(SwingConstants.CENTER);
        logoPanel.setText("ChemCal");

        developer_sign_label.setFont(new Font("Segoe UI", Font.BOLD, 12));
        developer_sign_label.setForeground(new Color(221, 221, 221));
        developer_sign_label.setHorizontalAlignment(SwingConstants.CENTER);
        developer_sign_label.setText("Developed by - HumbleFooL");
    }

    private LayoutManager getMenuItemHolderLayout(Container container) {
        GroupLayout menuHolderLayout = new GroupLayout(container);

        GroupLayout.ParallelGroup parallelGroup = menuHolderLayout.createParallelGroup(GroupLayout.Alignment.LEADING);
        menuItems.forEach(menuItem -> parallelGroup.addComponent(menuItem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        menuHolderLayout.setHorizontalGroup(parallelGroup);

        GroupLayout.SequentialGroup sequentialGroup = menuHolderLayout.createSequentialGroup();
        menuItems.forEach(menuItem -> sequentialGroup.addComponent(menuItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0));
        menuHolderLayout.setVerticalGroup(
                menuHolderLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sequentialGroup)
        );

        return menuHolderLayout;
    }

    private LayoutManager getSidebarLayout(Container container) {
        GroupLayout sidebarLayout = new GroupLayout(container);

        sidebarLayout.setHorizontalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(developer_sign_label, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(menuHolderScrollPane)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(logoPanel, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(logoSeparator, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 8, Short.MAX_VALUE))
        );
        sidebarLayout.setVerticalGroup(
                sidebarLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(sidebarLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(logoPanel)
                                .addGap(18, 18, 18)
                                .addComponent(logoSeparator, GroupLayout.PREFERRED_SIZE, 10, GroupLayout.PREFERRED_SIZE)
                                .addGap(50, 50, 50)
                                .addComponent(menuHolderScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(developer_sign_label, GroupLayout.PREFERRED_SIZE, 26, GroupLayout.PREFERRED_SIZE))
        );
        return sidebarLayout;
    }

    private void setComponentLayout() {
        menuHolder.setLayout(getMenuItemHolderLayout(menuHolder));
        this.setLayout(getSidebarLayout(this));
    }

    private class MenuItem extends JPanel {
        public static final Color MENU_ITEM_BACKGROUND_COLOR = new Color(64, 43, 100);

        private final JLabel label = new JLabel();
        private final JLabel icon = new JLabel();
        private JPanel targetPanel;

        public MenuItem(ContentPanel targetPanel) {
            this(targetPanel.getTitle(), targetPanel.getIconName(), targetPanel);
        }

        public MenuItem(String name, String iconName, JPanel targetPanel) {
            setBackground(MENU_ITEM_BACKGROUND_COLOR);
            addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent evt) {
                    menuMouseClicked(evt);
                }

                public void mouseEntered(MouseEvent evt) {
                    menuMouseEntered(evt);
                }

                public void mouseExited(MouseEvent evt) {
                    menuMouseExited(evt);
                }
            });

            icon.setHorizontalAlignment(SwingConstants.CENTER);
            icon.setIcon(new ImageIcon(getClass().getResource("/ChemistryCalculator/icons/" + iconName)));

            label.setFont(normal_menu_font);
            label.setForeground(new Color(221, 221, 221));
            label.setText(name);

            setLayout(getMenuItemLayout(this));
        }

        private GroupLayout getMenuItemLayout(Container container) {
            GroupLayout menuPanelLayout = new GroupLayout(container);
            menuPanelLayout.setHorizontalGroup(
                    menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(menuPanelLayout.createSequentialGroup()
                                    .addGap(22, 22, 22)
                                    .addComponent(icon, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(label)
                                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            );
            menuPanelLayout.setVerticalGroup(
                    menuPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(icon, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
                            .addComponent(label, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            );
            return menuPanelLayout;
        }

        private void menuMouseClicked(MouseEvent evt) {
            //when a certain menu is clicked , corresponding bodyPanel will be visible.
            for (MenuItem panel : menuItems) {
                if (panel.equals(evt.getSource())) {
                    panel.targetPanel.setVisible(true);
                    panel.setForeground(active_menu_color);
                    panel.setFont(active_menu_font);
                } else {
                    panel.targetPanel.setVisible(false);
                    panel.setForeground(normal_menu_color);
                    panel.setFont(normal_menu_font);
                }
            }
        }

        private void menuMouseEntered(MouseEvent evt) {
            this.setBackground(new Color(85, 65, 118));
            this.setCursor(pointer);
        }

        private void menuMouseExited(MouseEvent evt) {
            this.setBackground(new Color(64, 43, 100));
        }
    }

}
