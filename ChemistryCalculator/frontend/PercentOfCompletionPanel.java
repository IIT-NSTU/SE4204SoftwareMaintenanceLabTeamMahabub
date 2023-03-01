package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.Compound;
import ChemistryCalculator.backend.InvalidAtomException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.HashMap;

public class PercentOfCompletionPanel extends ContentPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", Font.BOLD, 14);
    private static final Color MAIN_COLOR = new Color(64, 43, 100);
    private static final Color GRAY = new Color(204, 204, 204);

    private final JLabel labelforcompoundTextfield = new JLabel();
    private final JTextField compoundTextfield = new JTextField();

    private final JButton getPercentOfCompletionButton = new JButton();
    private final JButton clearButton = new JButton();

    private final JScrollPane ansTableScrollPane = new JScrollPane();
    private final JTable ansTable = new JTable();
    private final JButton pieChartButton = new JButton();

    private final JPanel errorMessagePanel = new JPanel();
    private final JLabel errorMessageLabel = new JLabel();


    private DefaultTableModel dataTableModel;

    public PercentOfCompletionPanel() {
        super("Percent of completion", "icons8_percentage_25px.png");
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {
        setupCompoundLabelComponent();
        setupPercentOfCompletionComponent();
        setDataTableComponent();
        setupChartButtonComponent();
        setupErrorMessagePanel();
        setupClearButtonComponent();
    }

    private void setupClearButtonComponent() {
        clearButton.setBackground(MAIN_COLOR);
        clearButton.setFont(SEGOE_UI);
        clearButton.setForeground(GRAY);
        clearButton.setText("Clear");
        clearButton.setAutoscrolls(true);
        clearButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clearButton.addActionListener(this::clearActionPerformed);
    }

    private void setupErrorMessagePanel() {
        errorMessagePanel.setBackground(Color.red);
        errorMessagePanel.setVisible(false);
        errorMessageLabel.setFont(SEGOE_UI);
        errorMessageLabel.setForeground(Color.white);
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setupPercentOfCompletionComponent() {
        getPercentOfCompletionButton.setBackground(MAIN_COLOR);
        getPercentOfCompletionButton.setFont(SEGOE_UI);
        getPercentOfCompletionButton.setForeground(GRAY);
        getPercentOfCompletionButton.setText("Percent of completion");
        getPercentOfCompletionButton.setAutoscrolls(true);
        getPercentOfCompletionButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        getPercentOfCompletionButton.addActionListener(this::percentageOfCompletionActionPerformed);
    }

    private void setupChartButtonComponent() {
        pieChartButton.setVisible(false);
        pieChartButton.setBackground(MAIN_COLOR);
        pieChartButton.setFont(SEGOE_UI);
        pieChartButton.setForeground(GRAY);
        pieChartButton.setText("See pie chart");
        pieChartButton.setAutoscrolls(true);
        pieChartButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        pieChartButton.addActionListener(this::showPieChartActionPerformed);
    }

    private void setDataTableComponent() {
        dataTableModel = getCustomDataTableModel();
        ansTable.setBackground(MAIN_COLOR);
        ansTable.setBorder(BorderFactory.createEtchedBorder());
        ansTable.setFont(SEGOE_UI);
        ansTable.setForeground(GRAY);
        ansTable.setModel(dataTableModel);
        ansTable.setCursor(new Cursor(Cursor.TEXT_CURSOR));
        ansTable.setRowHeight(50);
        ansTable.setShowVerticalLines(false);
        ansTableScrollPane.setVisible(false);
        ansTableScrollPane.setViewportView(ansTable);
    }

    private DefaultTableModel getCustomDataTableModel() {
        return new DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ) {
            final Class[] types = new Class[]{
                    String.class, String.class, String.class, String.class, String.class
            };
            final boolean[] canEdit = new boolean[]{
                    false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
    }

    private void setupCompoundLabelComponent() {
        labelforcompoundTextfield.setFont(SEGOE_UI);
        labelforcompoundTextfield.setForeground(MAIN_COLOR);
        labelforcompoundTextfield.setText("Enter Compound :");
    }

    private void setComponentLayout() {
        errorMessagePanel.setLayout(getErrorMessagePanelLayout());
        this.setLayout(getMainLayout(this));
    }

    private LayoutManager getMainLayout(Container container) {
        GroupLayout mainLayout = new GroupLayout(container);
        mainLayout.setHorizontalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(pieChartButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(mainLayout.createSequentialGroup()
                                .addComponent(ansTableScrollPane, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addComponent(getPercentOfCompletionButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(clearButton))
                                        .addGroup(mainLayout.createSequentialGroup()
                                                .addComponent(labelforcompoundTextfield)
                                                .addGap(18, 18, 18)
                                                .addComponent(compoundTextfield, GroupLayout.PREFERRED_SIZE, 270, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(93, Short.MAX_VALUE))
        );
        mainLayout.setVerticalGroup(
                mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(mainLayout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labelforcompoundTextfield, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(compoundTextfield, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(mainLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(getPercentOfCompletionButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addGap(64, 64, 64)
                                .addComponent(ansTableScrollPane, GroupLayout.PREFERRED_SIZE, 257, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(pieChartButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(72, Short.MAX_VALUE))
        );
        return mainLayout;
    }

    private LayoutManager getErrorMessagePanelLayout() {
        GroupLayout errorMessagePanelLayout = new GroupLayout(errorMessagePanel);
        errorMessagePanelLayout.setHorizontalGroup(
                errorMessagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(GroupLayout.Alignment.TRAILING, errorMessagePanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(errorMessageLabel, GroupLayout.PREFERRED_SIZE, 654, GroupLayout.PREFERRED_SIZE))
        );
        errorMessagePanelLayout.setVerticalGroup(
                errorMessagePanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(errorMessagePanelLayout.createSequentialGroup()
                                .addComponent(errorMessageLabel, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
        );
        return errorMessagePanelLayout;
    }

    private void percentageOfCompletionActionPerformed(ActionEvent evt) {
        String compoundText = compoundTextfield.getText();
        if (!compoundText.isEmpty()) {
            Compound compound;
            try {
                compound = new Compound(compoundText);
            } catch (InvalidAtomException e) {
                errorMessagePanel.setVisible(true);
                errorMessageLabel.setText(e.getMessage());

                pieChartButton.setVisible(false);
                ansTableScrollPane.setVisible(false);
                return;
            }

            ArrayList<HashMap<String, String>> percentageOfCompletion = compound.getPercentageOfCompletion();
            String[] table_header = new String[]{"Name", "Symbol", "Total atoms", "Atomic mass", "Percentage"};
            String[][] table_row = percentageOfCompletion.stream()
                    .map(eachElement ->
                            new String[]{eachElement.get("name"),
                                    eachElement.get("symbol"),
                                    eachElement.get("totalAtoms"),
                                    String.format("%.2f", Double.parseDouble(eachElement.get("atomicMass"))),
                                    String.format("%.2f", Double.parseDouble(eachElement.get("massPercent")))
                            }
                    ).toArray(String[][]::new);
            dataTableModel.setDataVector(table_row, table_header
            );

            pieChartButton.setVisible(true);
            ansTableScrollPane.setVisible(true);
            errorMessagePanel.setVisible(false);
        } else {
            errorMessagePanel.setVisible(true);
            errorMessageLabel.setText("Please enter a compound.");

            pieChartButton.setVisible(false);
            ansTableScrollPane.setVisible(false);
        }
    }

    private void clearActionPerformed(ActionEvent event) {
        ansTableScrollPane.setVisible(false);
        pieChartButton.setVisible(false);
        errorMessagePanel.setVisible(false);
        compoundTextfield.setText(null);
    }

    private void showPieChartActionPerformed(ActionEvent event) {
        FxPieChart pieChart = new FxPieChart(dataTableModel.getDataVector());
        pieChart.toFront();
        pieChart.requestFocus();
    }

}
