package ChemistryCalculator.frontend;

import ChemistryCalculator.backend.EquationBalancer;
import ChemistryCalculator.backend.HistoryManager;
import ChemistryCalculator.backend.InvalidAtomException;
import ChemistryCalculator.backend.InvalidEquationException;

import javax.swing.*;
import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EquationBalancePanel extends ContentPanel {
    private static final Font SEGOE_UI = new Font("Segoe UI", Font.BOLD, 14);
    private static final Color MAIN_COLOR = new Color(64, 43, 100);
    private static final Color MAIN_COLOR_LITE = new Color(85, 65, 118);
    private static final Color GRAY = new Color(204, 204, 204);

    private final JLabel labelForReactantsTextfield = new JLabel();
    private final JTextField reactantsTextfield = new JTextField();
    private final JLabel labelForProductsTextfield = new JLabel();
    private final JTextField productsTextfield = new JTextField();

    private final JButton balanceButton = new JButton();
    private final JButton historyButton = new JButton();
    private final JButton clearButton = new JButton();

    private final JPanel errorMessagePanel = new JPanel();
    private final JLabel errorMessageLabel = new JLabel();

    private final JPanel ansPanel = new JPanel();
    private final JLabel labelForBalancedEquation = new JLabel();
    private final JLabel balancedEquationLabel = new JLabel();
    private final JScrollPane balancedEquationScrollPane = new JScrollPane();
    private final JLabel labelForGivenEquation = new JLabel();
    private final JLabel givenEquationLabel = new JLabel();
    private final JScrollPane givenEquationScrollPane = new JScrollPane();

    private final HistoryManager historyManager = new HistoryManager();

    public EquationBalancePanel() {
        super("Equation Balance", "icons8_scales_25px_1.png");
        initComponent();
        setComponentLayout();
    }

    private void initComponent() {
        labelForReactantsTextfield.setFont(SEGOE_UI);
        labelForReactantsTextfield.setForeground(MAIN_COLOR);
        labelForReactantsTextfield.setText("Reactants : ");

        labelForProductsTextfield.setFont(SEGOE_UI);
        labelForProductsTextfield.setForeground(MAIN_COLOR);
        labelForProductsTextfield.setText("Products  :");

        setupErrorMessagePanel();

        setupButtonFor(balanceButton, "Balance");
        balanceButton.addActionListener(this::balanceButtonActionPerformed);

        setupButtonFor(historyButton, "History");
        historyButton.addActionListener(this::historyButtonActionPerformed);

        setupButtonFor(clearButton, "Clear");
        clearButton.addActionListener(this::clearButtonActionPerformed);

        ansPanel.setBackground(MAIN_COLOR_LITE);
        ansPanel.setVisible(false);

        setupEquationBox(labelForBalancedEquation, "Balanced Equation :", balancedEquationScrollPane, balancedEquationLabel);
        setupEquationBox(labelForGivenEquation, "Given Equation :", givenEquationScrollPane, givenEquationLabel);
    }

    private void setupButtonFor(JButton button, String buttonText) {
        button.setBackground(MAIN_COLOR);
        button.setFont(SEGOE_UI); // NOI18N
        button.setForeground(GRAY);
        button.setText(buttonText);
        button.setAutoscrolls(true);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private void setupEquationBox(JLabel label, String text, JScrollPane scrollPane, JLabel equationLabel) {
        label.setFont(SEGOE_UI); // NOI18N
        label.setForeground(GRAY);
        label.setText(text);

        scrollPane.setBackground(MAIN_COLOR_LITE);
        scrollPane.setBorder(null);
        scrollPane.setForeground(MAIN_COLOR_LITE);
        scrollPane.setAutoscrolls(true);

        equationLabel.setBackground(MAIN_COLOR_LITE);
        equationLabel.setFont(SEGOE_UI); // NOI18N
        equationLabel.setForeground(Color.white);
        equationLabel.setOpaque(true);
        scrollPane.setViewportView(equationLabel);
    }

    private void setupErrorMessagePanel() {
        errorMessagePanel.setBackground(Color.red);
        errorMessagePanel.setVisible(false);
        errorMessageLabel.setFont(SEGOE_UI);
        errorMessageLabel.setForeground(Color.white);
        errorMessageLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void setComponentLayout() {
        errorMessagePanel.setLayout(getErrorMessagePanelLayout());


        //Layout for ans Panel.
        GroupLayout ansPanelLayout = new GroupLayout(ansPanel);
        ansPanel.setLayout(ansPanelLayout);
        ansPanelLayout.setHorizontalGroup(
                ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ansPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(ansPanelLayout.createSequentialGroup()
                                                .addComponent(labelForBalancedEquation)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(balancedEquationScrollPane))
                                        .addGroup(ansPanelLayout.createSequentialGroup()
                                                .addComponent(labelForGivenEquation)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(givenEquationScrollPane, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGap(20, 20, 20))
        );
        ansPanelLayout.setVerticalGroup(
                ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(ansPanelLayout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelForGivenEquation, GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                        .addComponent(givenEquationScrollPane))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(ansPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(labelForBalancedEquation, GroupLayout.DEFAULT_SIZE, 75, Short.MAX_VALUE)
                                        .addComponent(balancedEquationScrollPane))
                                .addContainerGap())
        );


        //Main panel layout
        GroupLayout Layout = new GroupLayout(this);
        this.setLayout(Layout);
        Layout.setHorizontalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(ansPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGroup(Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                .addGroup(Layout.createSequentialGroup()
                                                                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(labelForReactantsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(labelForProductsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addGap(18, 18, 18)
                                                                        .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(reactantsTextfield, GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                                                                                .addComponent(productsTextfield))))
                                                        .addGroup(Layout.createSequentialGroup()
                                                                .addComponent(balanceButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)))
                                                .addGap(0, 134, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        Layout.setVerticalGroup(
                Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(errorMessagePanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(reactantsTextfield, GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                                        .addComponent(labelForReactantsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                        .addComponent(productsTextfield, GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                                        .addComponent(labelForProductsTextfield, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(35, 35, 35)
                                .addGroup(Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(balanceButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(clearButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(historyButton, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 175, Short.MAX_VALUE)
                                .addComponent(ansPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
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

    private void balanceButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String reactants = reactantsTextfield.getText();
        String products = productsTextfield.getText();
        if (!reactants.isEmpty() || !products.isEmpty()) {
            String balancedEquation;
            EquationBalancer balancer = new EquationBalancer(reactants, products);

            try {
                balancedEquation = balancer.balance();
                errorMessagePanel.setVisible(false);
                givenEquationLabel.setText(Formater.formatEquation(reactants) + " = " + Formater.formatEquation(products));
                balancedEquationLabel.setText(Formater.formatEquation(balancedEquation));
                ansPanel.setVisible(true);

                historyManager.addHistory(balancedEquation);
            } catch (InvalidAtomException | InvalidEquationException | FileNotFoundException e) {
                errorMessageLabel.setText(e.getMessage());
                errorMessagePanel.setVisible(true);
                ansPanel.setVisible(false);
            }
        } else {
            errorMessageLabel.setText("Both fields are required !");
            errorMessagePanel.setVisible(true);
            ansPanel.setVisible(false);
        }
    }

    private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {
        HistoryFrame history = new HistoryFrame();
        history.toFront();
        history.requestFocus();
    }

    private void clearButtonActionPerformed(java.awt.event.ActionEvent evt) {
        reactantsTextfield.setText(null);
        productsTextfield.setText(null);
        errorMessagePanel.setVisible(false);
        ansPanel.setVisible(false);
    }
}
