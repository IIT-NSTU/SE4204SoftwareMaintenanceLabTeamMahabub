package ChemistryCalculator.frontend;

import javax.swing.*;

public class ContentPanel extends JPanel {

    private String title;
    private String iconName;

    public ContentPanel() {
    }

    public ContentPanel(String title, String iconName) {
        this.title = title;
        this.iconName = iconName;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
