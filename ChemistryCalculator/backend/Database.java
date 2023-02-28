package ChemistryCalculator.backend;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;

public class Database {
    public static final String DATABASE_FILE_PATH = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() +
            File.separator + "Chemistry Calculator" + File.separator + "database.ser";
    private static HashMap<String, Atom> allAtoms;
    private static Database database = null;

    private Database() {
        // Get database from resource
        allAtoms = DatabaseSerializer.deserialize(getClass().getResourceAsStream("/ChemistryCalculator/database/database.ser"));

        // If resource is empty get from local file path
        if (allAtoms.isEmpty()) {
            allAtoms = DatabaseSerializer.deserialize(DATABASE_FILE_PATH);
        }

        // If local file path not contains database. Create the database
        if (allAtoms.isEmpty()) {
            allAtoms = new DatabaseSerializer().serialize(DATABASE_FILE_PATH);
        }
    }

    public HashMap<String, Atom> getAllAtoms() {
        return allAtoms;
    }

    public static boolean isValidAtom(String symbol) {
        return allAtoms.containsKey(symbol);
    }

    public static boolean isValidAtom(int atomicNumber) {
        return atomicNumber >= 1 && atomicNumber <= 118;
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }
}
