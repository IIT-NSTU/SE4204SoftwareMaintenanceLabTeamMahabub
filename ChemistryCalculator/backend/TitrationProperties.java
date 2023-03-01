package ChemistryCalculator.backend;

public class TitrationProperties {
    private double molarity;
    private double volume;
    private double numOfMoles;

    public TitrationProperties() {
        this(0, 0, 0);
    }

    public TitrationProperties(String molarity, String volume, String numOfMoles) {
        this.molarity = Double.parseDouble(molarity);
        this.volume = Double.parseDouble(volume);
        this.numOfMoles = Double.parseDouble(numOfMoles);
    }

    public TitrationProperties(double molarity, double volume, double numOfMoles) {
        this.molarity = molarity;
        this.volume = volume;
        this.numOfMoles = numOfMoles;
    }

    public double getMolarity() {
        return molarity;
    }

    public double getVolume() {
        return volume;
    }

    public double getNumOfMoles() {
        return numOfMoles;
    }

    public double getConcentration() {
        return molarity * volume * numOfMoles;
    }

    public int countInvalid() {
        int count = 0;
        if (molarity < 0) {
            count++;
        }
        if (volume < 0) {
            count++;
        }
        if (numOfMoles < 0) {
            count++;
        }
        return count;
    }
}
