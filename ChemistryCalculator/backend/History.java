package ChemistryCalculator.backend;

import javax.swing.filechooser.FileSystemView;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {

    private File historyFile = null;

    public History() {
        checkForHistoryFile();
    }

    private void checkForHistoryFile() {
        String historyFilePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + File.separator;
        String directoryName = historyFilePath.concat("Chemistry Calculator");
        String txtFile = "history.txt";

        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (!directory.mkdir()) {
                System.err.println("Can not create directory '" + directoryName + "' at '" + historyFilePath);
                return;
            }
        }

        this.historyFile = new File(directoryName, txtFile);
    }

    public void addHistory(String line) throws FileNotFoundException {
        if (historyFile == null) {
            System.err.println("History file can not be created");
            return;
        }

        PrintWriter writer;
        if (historyFile.exists() && !historyFile.isDirectory()) {
            writer = new PrintWriter(new FileOutputStream(historyFile, true));
        } else {
            writer = new PrintWriter(historyFile);
        }

        writer.println(line.concat("    [" + DateTimeFormatter.ofPattern("HH:mm:ss, dd/MM/yyyy").format(LocalDateTime.now()) + "]"));
        writer.flush();
        writer.close();
    }
}
