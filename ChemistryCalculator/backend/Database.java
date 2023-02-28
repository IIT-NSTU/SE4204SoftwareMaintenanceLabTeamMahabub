package ChemistryCalculator.backend;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.util.HashMap;

public class Database {
    private static final HashMap<String, Atom> allAtoms = new HashMap<>();
    private static Database database = null;

    static {
        allAtoms.put("H", new Atom(1, "H", "Hydrogen",1.00794));
        allAtoms.put("He", new Atom(2, "He", "Helium",4.002602));
        allAtoms.put("Li", new Atom(3, "Li", "Lithium",6.941));
        allAtoms.put("Be", new Atom(4, "Be", "Beryllium",9.012182));
        allAtoms.put("B", new Atom(5, "B", "Boron",10.811));
        allAtoms.put("C", new Atom(6, "C", "Carbon",12.0107));
        allAtoms.put("N", new Atom(7, "N", "Nitrogen",14.0067));
        allAtoms.put("O", new Atom(8, "O", "Oxygen",15.9994));
        allAtoms.put("F", new Atom(9, "F", "Fluorine",18.9984032));
        allAtoms.put("Ne", new Atom(10, "Ne", "Neon",20.1797));
        allAtoms.put("Na", new Atom(11, "Na", "Sodium",22.989769));

        allAtoms.put("Mg", new Atom(12, "Mg", "Magnesium",24.305));
        allAtoms.put("Al", new Atom(13, "Al", "Aluminium",26.981538));
        allAtoms.put("Si", new Atom(14, "Si", "Silicon",28.0855));
        allAtoms.put("P", new Atom(15, "P", "Phosphorus",30.973762));
        allAtoms.put("S", new Atom(16, "S", "Sulphur",32.065));
        allAtoms.put("Cl", new Atom(17, "Cl", "Chlorine",35.453));
        allAtoms.put("Ar", new Atom(18, "Ar", "Argon",39.948));
        allAtoms.put("K", new Atom(19, "K", "Potassium",39.0983));
        allAtoms.put("Ca", new Atom(20, "Ca", "Calcium",40.078));
        allAtoms.put("Sc", new Atom(21, "Sc", "Scandium",44.955912));

        allAtoms.put("Ti", new Atom(22, "Ti", "Titanium",47.867));
        allAtoms.put("V", new Atom(23, "V", "Vanadium",50.9415));
        allAtoms.put("Cr", new Atom(24, "Cr", "Chromium",51.9961));
        allAtoms.put("Mn", new Atom(25, "Mn", "Manganese",54.938049));
        allAtoms.put("Fe", new Atom(26, "Fe", "Iron",55.845));
        allAtoms.put("Co", new Atom(27, "Co", "Cobalt",58.9332));
        allAtoms.put("Ni", new Atom(28, "Ni", "Nickel",58.6934));
        allAtoms.put("Cu", new Atom(29, "Cu", "Copper",63.546));
        allAtoms.put("Zn", new Atom(30, "Zn", "Zinc",65.409));
        allAtoms.put("Ga", new Atom(31, "Ga", "Gallium",69.723));

        allAtoms.put("Ge", new Atom(32, "Ge", "Germanium",72.64));
        allAtoms.put("As", new Atom(33, "As", "Arsenic",74.9216));
        allAtoms.put("Se", new Atom(34, "Se", "Selenium",78.96));
        allAtoms.put("Br", new Atom(35, "Br", "Bromine",79.904));
        allAtoms.put("Kr", new Atom(36, "Kr", "Krypton",83.798));
        allAtoms.put("Rb", new Atom(37, "Rb", "Rubidium",85.4678));
        allAtoms.put("Sr", new Atom(38, "Sr", "Strontium",87.62));
        allAtoms.put("Y", new Atom(39, "Y", "Yttrium",88.90585));
        allAtoms.put("Zr", new Atom(40, "Zr", "Zirconium",91.224));
        allAtoms.put("Nb", new Atom(41, "Nb", "Niobium",92.90638));

        allAtoms.put("Mo", new Atom(42, "Mo", "Molybdenum",95.94));
        allAtoms.put("Tc", new Atom(43, "Tc", "Technetium",97.9072));
        allAtoms.put("Ru", new Atom(44, "Ru", "Ruthenium",101.07));
        allAtoms.put("Rh", new Atom(45, "Rh", "Rhodium",102.9055));
        allAtoms.put("Pd", new Atom(46, "Pd", "Palladium",106.42));
        allAtoms.put("Ag", new Atom(47, "Ag", "Silver",107.8682));
        allAtoms.put("Cd", new Atom(48, "Cd", "Cadmium",112.411));
        allAtoms.put("In", new Atom(49, "In", "Indium",114.818));
        allAtoms.put("Sn", new Atom(50, "Sn", "Tin",118.71));
        allAtoms.put("Sb", new Atom(51, "Sb", "Antimony",121.76));

        allAtoms.put("Te", new Atom(52, "Te", "Tellurium",127.6));
        allAtoms.put("I", new Atom(53, "I", "Iodine",126.90447));
        allAtoms.put("Xe", new Atom(54, "5Xe", "Xenon",131.293));
        allAtoms.put("Cs", new Atom(55, "Cs", "Caesium",132.90545));
        allAtoms.put("Ba", new Atom(56, "Ba", "Barium",137.327));
        allAtoms.put("La", new Atom(57, "La", "Lanthanum",138.9055));
        allAtoms.put("Ce", new Atom(58, "Ce", "Cerium",140.116));
        allAtoms.put("Pr", new Atom(59, "Pr", "Praseodymium",140.90765));
        allAtoms.put("Nd", new Atom(60, "Nd", "Neodymium",144.24));
        allAtoms.put("Pm", new Atom(61, "Pm", "Promethium",144.9127));

        allAtoms.put("Sm", new Atom(62, "Sm", "Samarium",150.36));
        allAtoms.put("Eu", new Atom(63, "Eu", "Europium",151.964));
        allAtoms.put("Gd", new Atom(64, "Gd", "Gadolinium",157.25));
        allAtoms.put("Tb", new Atom(65, "Tb", "Terbium",158.92534));
        allAtoms.put("Dy", new Atom(66, "Dy", "Dysprosium",162.5));
        allAtoms.put("Ho", new Atom(67, "Ho", "Holmium",164.93032));
        allAtoms.put("Er", new Atom(68, "Er", "Erbium",167.259));
        allAtoms.put("Tm", new Atom(69, "Tm", "Thulium",168.93421));
        allAtoms.put("Yb", new Atom(70, "Yb", "Ytterbium",173.04));
        allAtoms.put("Lu", new Atom(71, "Lu", "Lutetium",174.967));

        allAtoms.put("Hf", new Atom(72, "Hf", "Hafnium",178.49));
        allAtoms.put("Ta", new Atom(73, "Ta", "Tantalum",180.9479));
        allAtoms.put("W", new Atom(74, "W", "Tungsten",183.84));
        allAtoms.put("Re", new Atom(75, "Re", "Rhenium",186.207));
        allAtoms.put("Os", new Atom(76, "Os", "Osmium",190.23));
        allAtoms.put("Ir", new Atom(77, "Ir", "Iridium",192.217));
        allAtoms.put("Pt", new Atom(78, "Pt", "Platinum",195.078));
        allAtoms.put("Au", new Atom(79, "Au", "Gold",196.96655));
        allAtoms.put("Hg", new Atom(80, "Hg", "Mercury",200.59));
        allAtoms.put("Tl", new Atom(81, "Tl", "Thallium",204.3833));

        allAtoms.put("Pb", new Atom(82, "Pb", "Lead",207.2));
        allAtoms.put("Bi", new Atom(83, "Bi", "Bismuth",208.98038));
        allAtoms.put("Po", new Atom(84, "Po", "Polonium",208.9824));
        allAtoms.put("At", new Atom(85, "At", "Astatine",209.9871));
        allAtoms.put("Rn", new Atom(86, "Rn", "Radon",222.0176));
        allAtoms.put("Fr", new Atom(87, "Fr", "Francium",223.0197));
        allAtoms.put("Ra", new Atom(88, "Ra", "Radium",226.0254));
        allAtoms.put("Ac", new Atom(89, "Ac", "Actinium",227.0277));
        allAtoms.put("Th", new Atom(90, "Th", "Thorium",232.03806));
        allAtoms.put("Pa", new Atom(91, "Pa", "Protactinium",231.03588));

        allAtoms.put("U", new Atom(92, "U", "Uranium",238.02891));
        allAtoms.put("Np", new Atom(93, "Np", "Neptunium",237.0482));
        allAtoms.put("Pu", new Atom(94, "Pu", "Plutonium",244.0642));
        allAtoms.put("Am", new Atom(95, "Am", "Americium",243.0614));
        allAtoms.put("Cm", new Atom(96, "Cm", "Curium",247.0704));
        allAtoms.put("Bk", new Atom(97, "Bk", "Berkelium",247.0703));
        allAtoms.put("Cf", new Atom(98, "Cf", "Californium",251.0796));
        allAtoms.put("Es", new Atom(99, "Es", "Einsteinium",252.0830));
        allAtoms.put("Fm", new Atom(100, "Fm", "Fermium",257.0951));
        allAtoms.put("Md", new Atom(101, "Md", "Mendelevium",258.0984));

        allAtoms.put("No", new Atom(102, "No", "Nobelium",259.1010));
        allAtoms.put("Lr", new Atom(103, "Lr", "Lawrencium",262.1097));
        allAtoms.put("Rf", new Atom(104, "Rf", "Rutherfordium",261.1088));
        allAtoms.put("Db", new Atom(105, "Db", "Dubnium",262.1141));
        allAtoms.put("Sg", new Atom(106, "Sg", "Seaborgium",266.1219));
        allAtoms.put("Bh", new Atom(107, "Bh", "Bohrium",264.12));
        allAtoms.put("Hs", new Atom(108, "Hs", "Hassium",277.0));
        allAtoms.put("Mt", new Atom(109, "Mt", "Meitnerium",268.1388));
        allAtoms.put("Ds", new Atom(110, "Ds", "Darmstadtium",271.0));
        allAtoms.put("Rg", new Atom(111, "Rg", "Roentgenium",272.0));

        allAtoms.put("Cn", new Atom(112, "Cn", "Copernicium",285.0));
        allAtoms.put("Nh", new Atom(113, "Nh", "Nihonium",284.0));
        allAtoms.put("Fi", new Atom(114, "Fi", "Flerovium",285.0));
        allAtoms.put("Mc", new Atom(115, "Mc", "Moscovium",288.0));
        allAtoms.put("Lv", new Atom(116, "Lv", "Livermorium",292.0));
        allAtoms.put("Ts", new Atom(117, "Ts", "Tennessine",294.211));
        allAtoms.put("Og", new Atom(118, "Og", "Oganesson",294.0));
    }

    public static HashMap<String, Atom> getAllAtoms() {
        return allAtoms;
    }

    public static boolean isValidAtom(String symbol) {
        return allAtoms.containsKey(symbol);
    }

    public static boolean isValidAtom(int atomicNumber) {
        return atomicNumber >= 1 && atomicNumber <= 118;
    }

    public static Atom getAtom(String symbol) {
        if (Database.isValidAtom(symbol)) {
            return allAtoms.get(symbol);
        }
        throw new InvalidAtomException("'" + symbol + "'" + " is not a valid symbol !");
    }

    public static Atom getAtom(int atomicNumber) {
        if (Database.isValidAtom(atomicNumber)) {
            for (Atom atom : allAtoms.values()) {
                if (atom.getAtomicNumber() == atomicNumber) {
                    return atom;
                }
            }
        }
        throw new InvalidAtomException("'" + atomicNumber + "'" + " is not a valid atomic number !");
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}
