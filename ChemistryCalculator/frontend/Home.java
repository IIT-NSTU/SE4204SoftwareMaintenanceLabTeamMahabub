package ChemistryCalculator.frontend;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Home extends JFrame {

    private final JPanel backgroundPanel = new JPanel();
    private final JPanel bodyPanel = new JPanel();
    private final Sidebar sidebarPanel = new Sidebar();


    // Available body panels
    private final ContentPanel equationBalancePanel = new EquationBalancePanel();
    private final ContentPanel concentrationPanel = new ConcentrationPanel();
    private final ContentPanel molarMassPanel = new MolarMassPanel();
    private final ContentPanel electronConfigPanel = new ElectronConfigPanel();
    private final ContentPanel needHelpPanel = new NeedHelpPanel();
    private final ContentPanel percentOfCompletionPanel = new PercentOfCompletionPanel();
    private final ContentPanel titrationPanel = new TitrationPanel();

    public Home() {
        ArrayList<ContentPanel> bodyPanels = new ArrayList<>(
                List.of(equationBalancePanel, concentrationPanel, electronConfigPanel, molarMassPanel, percentOfCompletionPanel, titrationPanel, needHelpPanel)
        );

        initializeSidebar(bodyPanels);
        initializeBodyPanelLayout(bodyPanels);
        backgroundPanel.setLayout(getBackgroundPanelLayout(backgroundPanel));
        getContentPane().setLayout(getMainPanelLayout(getContentPane()));
        setupFrameProperties();
    }

    private void initializeBodyPanelLayout(ArrayList<ContentPanel> bodyPanels) {
        bodyPanel.setLayout(new CardLayout());
        for (ContentPanel panel : bodyPanels) {
            bodyPanel.add(panel);
        }
    }

    private void initializeSidebar(ArrayList<ContentPanel> bodyPanels) {
        sidebarPanel.addMenuFromContentPanels(bodyPanels);
    }

    /**
     * Group sidebarPanel and bodyPanel into the given container using GroupLayout
     * @param container In which container to add the sidebarPanel and bodyPanel
     * @return GroupLayout with sidebarPanel and bodyPanel
     */
    private GroupLayout getBackgroundPanelLayout(Container container) {
        GroupLayout backgroundPanelLayout = new GroupLayout(container);
        backgroundPanelLayout.setHorizontalGroup(
                backgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(backgroundPanelLayout.createSequentialGroup()
                                .addComponent(sidebarPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundPanelLayout.setVerticalGroup(
                backgroundPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(sidebarPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bodyPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        return backgroundPanelLayout;
    }

    /**
     * Group backgroundPanel into the given container using GroupLayout
     * @param container In which container to add backgroundPanel
     * @return GroupLayout with backgroundPanel
     */
    private GroupLayout getMainPanelLayout(Container container) {
        GroupLayout mainPanelLayout = new GroupLayout(container);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(backgroundPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        return mainPanelLayout;
    }

    private void setupFrameProperties() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Chemistry Calculator");
        setAlwaysOnTop(true);
        setIconImage(ResourceManager.getInstance().getIconResource("icons8_biohazard_120px.png").getImage());
        setLocationByPlatform(true);
        setResizable(false);
        setAlwaysOnTop(false);
        pack();
        setLocationRelativeTo(null);
    }

    public static void setLookAndFeel(String lookAndFeelName) {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if (lookAndFeelName.equalsIgnoreCase(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException |
                 UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        setLookAndFeel("Nimbus");
        EventQueue.invokeLater(() -> new Home().setVisible(true));
    }

}
