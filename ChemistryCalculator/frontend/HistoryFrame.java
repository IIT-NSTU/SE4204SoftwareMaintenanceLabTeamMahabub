package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.HistoryManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;


public class HistoryFrame extends JFrame {
    private final JPanel mainPanel = new JPanel();
    private final JScrollPane mainScrollPane = new JScrollPane();
    private final JTextArea HistoryTextArea = new JTextArea();
    private final JButton clearButton = new JButton();

    private final HistoryManager historyManager = new HistoryManager();
    public HistoryFrame() throws IOException {
        initComponents();
        setComponentLayout();
        setFrameProperties();
        collectHistory();
    }

    private void setComponentLayout() {
        mainPanel.setLayout(getMainPanelLayout(mainPanel));
        getContentPane().setLayout(getMainLayout(getContentPane()));
    }

    private LayoutManager getMainPanelLayout(Container container) {
        GroupLayout mainPanelLayout = new GroupLayout(container);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addComponent(mainScrollPane, GroupLayout.PREFERRED_SIZE, 670, GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 96, Short.MAX_VALUE)
                                .addGap(20, 20, 20))

        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainScrollPane, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE)
                        .addGap(20, 20, 20)
                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
        );
        return mainPanelLayout;
    }
    
    private LayoutManager getMainLayout(Container container) {
        GroupLayout mainPanelLayout = new GroupLayout(container);
        mainPanelLayout.setHorizontalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
                mainPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(mainPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        return mainPanelLayout;
    }

    private void initComponents() {
        setupClearButtonComponent();
        setHistoryTextArea();
    }

    private void setHistoryTextArea() {
        HistoryTextArea.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        HistoryTextArea.setLineWrap(true);
        HistoryTextArea.setWrapStyleWord(true);
        HistoryTextArea.setBorder(null);
        HistoryTextArea.setMargin(new Insets(3, 5, 3, 3));
        mainScrollPane.setBorder(null);
        mainScrollPane.setViewportView(HistoryTextArea);
    }

    private void setupClearButtonComponent() {
        clearButton.setBackground(new Color(64, 43, 100));
        clearButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
        clearButton.setForeground(new Color(204, 204, 204));
        clearButton.setText("Clear HistoryManager");
        clearButton.setAutoscrolls(true);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this::clearButtonActionPerformed);
    }

    private void setFrameProperties() {
        mainPanel.setBackground(Color.white);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setBounds(100, 100, 900, 500);
        setIconImage(ResourceManager.getInstance().getIconResource("icons8_biohazard_120px.png").getImage());
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Equation Balance - HistoryManager");
    }

    private void clearButtonActionPerformed(ActionEvent actionEvent) {
        historyManager.clearHistory();
        HistoryTextArea.setText("");
    }

    public void collectHistory() {
        ArrayList<String> historyList = historyManager.getHistory();
        if (historyList.isEmpty()) {
            clearButton.setVisible(false);
            return;
        }
        for (int i = historyList.size() - 1; i >= 0; i--) {
            HistoryTextArea.append(historyList.get(i) + "\n");
        }
    }

}
