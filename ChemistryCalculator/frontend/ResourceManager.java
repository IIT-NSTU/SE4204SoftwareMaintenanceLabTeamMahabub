package ChemistryCalculator.frontend;

import javax.swing.*;
import java.net.URL;

public class ResourceManager {
    private static ResourceManager resourceManagerInstance = null;

    private ResourceManager() {}

    public ImageIcon getIconResource(String iconName) {
        URL resourceURL = getClass().getResource("/ChemistryCalculator/icons/" + iconName);
        if (resourceURL != null) {
            return new ImageIcon(resourceURL);
        }
        return null;
    }

    public static ResourceManager getInstance() {
        if (resourceManagerInstance == null) {
            resourceManagerInstance = new ResourceManager();
        }
        return resourceManagerInstance;
    }
}
