package ChemistryCalculator.backend;

public class Atom {
    private final String symbol;
    private final String name;
    private final double atomicMass;
    private final int atomicNumber;

    public Atom(int atomicNumber, String symbol, String name, double atomicMass) {
        this.atomicNumber = atomicNumber;
        this.symbol = symbol;
        this.name = name;
        this.atomicMass = atomicMass;
    }

    public String getElectronConfig() {
        return Orbitals.electronConfigForAtom(this.atomicNumber);
    }

    public String getSymbol() {
        return symbol;
    }

    public String getName() {
        return name;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    @Override
    public String toString() {
        return String.format("Atom {%s %s %f %d}", name, symbol, atomicMass, atomicNumber);
    }

}

