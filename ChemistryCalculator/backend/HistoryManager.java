package ChemistryCalculator.backend;

import javax.swing.filechooser.FileSystemView;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HistoryManager {

    private File historyFile = null;
    private String historyFilePath = null;

    public HistoryManager() {
        checkForHistoryFile();
    }

    private void checkForHistoryFile() {
        String historyFilePath = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() + File.separator;
        String directoryName = historyFilePath.concat("Chemistry Calculator");
        String txtFile = "history.txt";

        this.historyFilePath = historyFilePath + File.separator + txtFile;

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
            System.err.println("HistoryManager file can not be created");
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

    public ArrayList<String> getHistory() {
        ArrayList<String> historyList = new ArrayList<>();
        try {
            Files.lines(Paths.get(this.historyFilePath)).forEach(historyList::add);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return historyList;
    }

    public void clearHistory() {
        try {
            PrintWriter writer = new PrintWriter(historyFile);
            writer.print("");
            writer.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
