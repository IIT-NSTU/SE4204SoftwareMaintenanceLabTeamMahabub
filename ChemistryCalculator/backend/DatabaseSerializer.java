package ChemistryCalculator.backend;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.util.HashMap;


//execute this class if database/database.ser is corrupted or want to change/add new atoms. this will create a new one.
public class DatabaseSerializer {
    private final HashMap<String, Atom> hashMap = new HashMap<>();
    public DatabaseSerializer() {
        hashMap.put("H", new Atom(1, "H", "Hydrogen",1.00794));
        hashMap.put("He", new Atom(2, "He", "Helium",4.002602));
        hashMap.put("Li", new Atom(3, "Li", "Lithium",6.941));
        hashMap.put("Be", new Atom(4, "Be", "Beryllium",9.012182));
        hashMap.put("B", new Atom(5, "B", "Boron",10.811));
        hashMap.put("C", new Atom(6, "C", "Carbon",12.0107));
        hashMap.put("N", new Atom(7, "N", "Nitrogen",14.0067));
        hashMap.put("O", new Atom(8, "O", "Oxygen",15.9994));
        hashMap.put("F", new Atom(9, "F", "Fluorine",18.9984032));
        hashMap.put("Ne", new Atom(10, "Ne", "Neon",20.1797));
        hashMap.put("Na", new Atom(11, "Na", "Sodium",22.989769));

        hashMap.put("Mg", new Atom(12, "Mg", "Magnesium",24.305));
        hashMap.put("Al", new Atom(13, "Al", "Aluminium",26.981538));
        hashMap.put("Si", new Atom(14, "Si", "Silicon",28.0855));
        hashMap.put("P", new Atom(15, "P", "Phosphorus",30.973762));
        hashMap.put("S", new Atom(16, "S", "Sulphur",32.065));
        hashMap.put("Cl", new Atom(17, "Cl", "Chlorine",35.453));
        hashMap.put("Ar", new Atom(18, "Ar", "Argon",39.948));
        hashMap.put("K", new Atom(19, "K", "Potassium",39.0983));
        hashMap.put("Ca", new Atom(20, "Ca", "Calcium",40.078));
        hashMap.put("Sc", new Atom(21, "Sc", "Scandium",44.955912));

        hashMap.put("Ti", new Atom(22, "Ti", "Titanium",47.867));
        hashMap.put("V", new Atom(23, "V", "Vanadium",50.9415));
        hashMap.put("Cr", new Atom(24, "Cr", "Chromium",51.9961));
        hashMap.put("Mn", new Atom(25, "Mn", "Manganese",54.938049));
        hashMap.put("Fe", new Atom(26, "Fe", "Iron",55.845));
        hashMap.put("Co", new Atom(27, "Co", "Cobalt",58.9332));
        hashMap.put("Ni", new Atom(28, "Ni", "Nickel",58.6934));
        hashMap.put("Cu", new Atom(29, "Cu", "Copper",63.546));
        hashMap.put("Zn", new Atom(30, "Zn", "Zinc",65.409));
        hashMap.put("Ga", new Atom(31, "Ga", "Gallium",69.723));

        hashMap.put("Ge", new Atom(32, "Ge", "Germanium",72.64));
        hashMap.put("As", new Atom(33, "As", "Arsenic",74.9216));
        hashMap.put("Se", new Atom(34, "Se", "Selenium",78.96));
        hashMap.put("Br", new Atom(35, "Br", "Bromine",79.904));
        hashMap.put("Kr", new Atom(36, "Kr", "Krypton",83.798));
        hashMap.put("Rb", new Atom(37, "Rb", "Rubidium",85.4678));
        hashMap.put("Sr", new Atom(38, "Sr", "Strontium",87.62));
        hashMap.put("Y", new Atom(39, "Y", "Yttrium",88.90585));
        hashMap.put("Zr", new Atom(40, "Zr", "Zirconium",91.224));
        hashMap.put("Nb", new Atom(41, "Nb", "Niobium",92.90638));

        hashMap.put("Mo", new Atom(42, "Mo", "Molybdenum",95.94));
        hashMap.put("Tc", new Atom(43, "Tc", "Technetium",97.9072));
        hashMap.put("Ru", new Atom(44, "Ru", "Ruthenium",101.07));
        hashMap.put("Rh", new Atom(45, "Rh", "Rhodium",102.9055));
        hashMap.put("Pd", new Atom(46, "Pd", "Palladium",106.42));
        hashMap.put("Ag", new Atom(47, "Ag", "Silver",107.8682));
        hashMap.put("Cd", new Atom(48, "Cd", "Cadmium",112.411));
        hashMap.put("In", new Atom(49, "In", "Indium",114.818));
        hashMap.put("Sn", new Atom(50, "Sn", "Tin",118.71));
        hashMap.put("Sb", new Atom(51, "Sb", "Antimony",121.76));

        hashMap.put("Te", new Atom(52, "Te", "Tellurium",127.6));
        hashMap.put("I", new Atom(53, "I", "Iodine",126.90447));
        hashMap.put("Xe", new Atom(54, "5Xe", "Xenon",131.293));
        hashMap.put("Cs", new Atom(55, "Cs", "Caesium",132.90545));
        hashMap.put("Ba", new Atom(56, "Ba", "Barium",137.327));
        hashMap.put("La", new Atom(57, "La", "Lanthanum",138.9055));
        hashMap.put("Ce", new Atom(58, "Ce", "Cerium",140.116));
        hashMap.put("Pr", new Atom(59, "Pr", "Praseodymium",140.90765));
        hashMap.put("Nd", new Atom(60, "Nd", "Neodymium",144.24));
        hashMap.put("Pm", new Atom(61, "Pm", "Promethium",144.9127));

        hashMap.put("Sm", new Atom(62, "Sm", "Samarium",150.36));
        hashMap.put("Eu", new Atom(63, "Eu", "Europium",151.964));
        hashMap.put("Gd", new Atom(64, "Gd", "Gadolinium",157.25));
        hashMap.put("Tb", new Atom(65, "Tb", "Terbium",158.92534));
        hashMap.put("Dy", new Atom(66, "Dy", "Dysprosium",162.5));
        hashMap.put("Ho", new Atom(67, "Ho", "Holmium",164.93032));
        hashMap.put("Er", new Atom(68, "Er", "Erbium",167.259));
        hashMap.put("Tm", new Atom(69, "Tm", "Thulium",168.93421));
        hashMap.put("Yb", new Atom(70, "Yb", "Ytterbium",173.04));
        hashMap.put("Lu", new Atom(71, "Lu", "Lutetium",174.967));

        hashMap.put("Hf", new Atom(72, "Hf", "Hafnium",178.49));
        hashMap.put("Ta", new Atom(73, "Ta", "Tantalum",180.9479));
        hashMap.put("W", new Atom(74, "W", "Tungsten",183.84));
        hashMap.put("Re", new Atom(75, "Re", "Rhenium",186.207));
        hashMap.put("Os", new Atom(76, "Os", "Osmium",190.23));
        hashMap.put("Ir", new Atom(77, "Ir", "Iridium",192.217));
        hashMap.put("Pt", new Atom(78, "Pt", "Platinum",195.078));
        hashMap.put("Au", new Atom(79, "Au", "Gold",196.96655));
        hashMap.put("Hg", new Atom(80, "Hg", "Mercury",200.59));
        hashMap.put("Tl", new Atom(81, "Tl", "Thallium",204.3833));

        hashMap.put("Pb", new Atom(82, "Pb", "Lead",207.2));
        hashMap.put("Bi", new Atom(83, "Bi", "Bismuth",208.98038));
        hashMap.put("Po", new Atom(84, "Po", "Polonium",208.9824));
        hashMap.put("At", new Atom(85, "At", "Astatine",209.9871));
        hashMap.put("Rn", new Atom(86, "Rn", "Radon",222.0176));
        hashMap.put("Fr", new Atom(87, "Fr", "Francium",223.0197));
        hashMap.put("Ra", new Atom(88, "Ra", "Radium",226.0254));
        hashMap.put("Ac", new Atom(89, "Ac", "Actinium",227.0277));
        hashMap.put("Th", new Atom(90, "Th", "Thorium",232.03806));
        hashMap.put("Pa", new Atom(91, "Pa", "Protactinium",231.03588));

        hashMap.put("U", new Atom(92, "U", "Uranium",238.02891));
        hashMap.put("Np", new Atom(93, "Np", "Neptunium",237.0482));
        hashMap.put("Pu", new Atom(94, "Pu", "Plutonium",244.0642));
        hashMap.put("Am", new Atom(95, "Am", "Americium",243.0614));
        hashMap.put("Cm", new Atom(96, "Cm", "Curium",247.0704));
        hashMap.put("Bk", new Atom(97, "Bk", "Berkelium",247.0703));
        hashMap.put("Cf", new Atom(98, "Cf", "Californium",251.0796));
        hashMap.put("Es", new Atom(99, "Es", "Einsteinium",252.0830));
        hashMap.put("Fm", new Atom(100, "Fm", "Fermium",257.0951));
        hashMap.put("Md", new Atom(101, "Md", "Mendelevium",258.0984));

        hashMap.put("No", new Atom(102, "No", "Nobelium",259.1010));
        hashMap.put("Lr", new Atom(103, "Lr", "Lawrencium",262.1097));
        hashMap.put("Rf", new Atom(104, "Rf", "Rutherfordium",261.1088));
        hashMap.put("Db", new Atom(105, "Db", "Dubnium",262.1141));
        hashMap.put("Sg", new Atom(106, "Sg", "Seaborgium",266.1219));
        hashMap.put("Bh", new Atom(107, "Bh", "Bohrium",264.12));
        hashMap.put("Hs", new Atom(108, "Hs", "Hassium",277.0));
        hashMap.put("Mt", new Atom(109, "Mt", "Meitnerium",268.1388));
        hashMap.put("Ds", new Atom(110, "Ds", "Darmstadtium",271.0));
        hashMap.put("Rg", new Atom(111, "Rg", "Roentgenium",272.0));

        hashMap.put("Cn", new Atom(112, "Cn", "Copernicium",285.0));
        hashMap.put("Nh", new Atom(113, "Nh", "Nihonium",284.0));
        hashMap.put("Fi", new Atom(114, "Fi", "Flerovium",285.0));
        hashMap.put("Mc", new Atom(115, "Mc", "Moscovium",288.0));
        hashMap.put("Lv", new Atom(116, "Lv", "Livermorium",292.0));
        hashMap.put("Ts", new Atom(117, "Ts", "Tennessine",294.211));
        hashMap.put("Og", new Atom(118, "Og", "Oganesson",294.0));
    }

    public HashMap<String, Atom> serialize(String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                if (!file.createNewFile()) {
                    throw new IOException("Can not create file " + filePath);
                }
            }
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(hashMap);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return hashMap;
    }

    public static HashMap<String, Atom> deserialize(String filePath) {
        try {
            InputStream inputStream = new FileInputStream(filePath);
            ObjectInputStream objectinputStream = new ObjectInputStream(inputStream);
            return (HashMap<String, Atom>) objectinputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Database Error! %s\nUsing Temporary Database.\n", e.getMessage());
        }
        return new HashMap<>();
    }

    public static HashMap<String, Atom> deserialize(InputStream inputStream) {
        try {
            ObjectInputStream objectinputStream = new ObjectInputStream(inputStream);
            return (HashMap<String, Atom>) objectinputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.printf("Database Error! %s\nUsing Temporary Database.\n", e.getMessage());
        }
        return new HashMap<>();
    }

    public static void main(String[] args) throws IOException {
//        DatabaseSerializer databaseSerializer = new DatabaseSerializer();
//        databaseSerializer.serialize(Database.DATABASE_FILE_PATH);
//        HashMap<String, Atom> atomMap = DatabaseSerializer.deserialize(new FileInputStream(Database.DATABASE_FILE_PATH));
//        atomMap.forEach((k, v) -> System.out.println(k + " " + v));

//########## printing all element from database.ser##############
//        FileInputStream fileInputStream = new FileInputStream("atom.ser");
//        ObjectInputStream objectinputStream = new ObjectInputStream(fileInputStream);
//        HashMap<String, String[]> out = (HashMap<String, String[]>) objectinputStream.readObject();
//
//        out.forEach((k, v)-> System.out.println(k + Arrays.toString(v)));
    }

}
