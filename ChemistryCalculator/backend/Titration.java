package ChemistryCalculator.backend;

import java.util.Arrays;

public class Titration {
    private TitrationProperties acidProperties = new TitrationProperties();
    private TitrationProperties baseProperties = new TitrationProperties();
    private boolean hasUnknownValueInAcid = false;

    //Here one and only one property can be empty, which is the unknown value
    public Titration(TitrationProperties acidProperties, TitrationProperties baseProperties) {
        this.acidProperties = acidProperties;
        this.baseProperties = baseProperties;
    }

    public double getUnknownValue() {
        if (this.isValid()) {
            double numerator;
            double denominator = 1;
            if (hasUnknownValueInAcid) {
                return baseProperties.getConcentration() / acidProperties.getConcentration();
            } else {
                return acidProperties.getConcentration() / baseProperties.getConcentration();
            }
        } else {
            throw new InsufficientDataException("\"Fill up any 5 fields to get unknown value\"");
        }
    }

    private boolean isValid() {
        return acidProperties.countInvalid() + baseProperties.countInvalid() < 2;
    }

}
