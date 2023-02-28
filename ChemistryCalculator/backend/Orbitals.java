package ChemistryCalculator.backend;

import java.util.ArrayList;
import java.util.List;

public class Orbitals {
    private static final ArrayList<Orbital> atomicOrbitals;
    static {
        atomicOrbitals = new ArrayList<>(
                List.of(
                        new Orbital(1, "s", 2),
                        new Orbital(2, "s", 2),
                        new Orbital(2, "p", 6),
                        new Orbital(3, "s", 2),
                        new Orbital(3, "p", 6),
                        new Orbital(3, "d", 10),
                        new Orbital(4, "s", 2),
                        new Orbital(4, "p", 6),
                        new Orbital(4, "d", 10),
                        new Orbital(4, "f", 14),
                        new Orbital(5, "s", 2),
                        new Orbital(5, "p", 6),
                        new Orbital(5, "d", 10),
                        new Orbital(5, "f", 14),
                        new Orbital(6, "s", 2),
                        new Orbital(6, "p", 6),
                        new Orbital(6, "d", 10),
                        new Orbital(7, "s", 2),
                        new Orbital(7, "p", 6),
                        new Orbital(8, "s", 2)
                )
        );
    }

    public static String electronConfigForAtom(int atomicNumber) {
        StringBuilder sb = new StringBuilder();
        if (AtomDatabase.isValidAtom(atomicNumber)) {
            int counter;
            int tempAtomicNumber = atomicNumber;

            for (Orbital orbital : atomicOrbitals) {
                counter = Math.min(orbital.getNumberOfElectron(), tempAtomicNumber);
                sb.append(orbital.getEnergyLevel()).append(orbital.getOrbitalType()).append(counter).append(" ");

                tempAtomicNumber -= counter;
                if (tempAtomicNumber <= 0) {
                    break;
                }
            }
        }
        return sb.toString();
    }

    private static class Orbital {
        private final String orbitalType;
        private final int energyLevel;
        private final int numberOfElectron;

        public Orbital(int energyLevel, String orbitalType, int numberOfElectron) {
            this.orbitalType = orbitalType;
            this.energyLevel = energyLevel;
            this.numberOfElectron = numberOfElectron;
        }

        public String getOrbitalType() {
            return orbitalType;
        }

        public int getEnergyLevel() {
            return energyLevel;
        }

        public int getNumberOfElectron() {
            return numberOfElectron;
        }
    }
}
