package ui;

/**
 *
 * @author LAPR2-2020-G038
 */
public class FileChooser {

    private javafx.stage.FileChooser fileChooser;

    private FileChooser(String extension) {
        fileChooser = new javafx.stage.FileChooser();
        String textToShow="File to Import: "+extension;
        associarFiltro(textToShow, extension);
    }

    public static javafx.stage.FileChooser createFileChooser(String extension) {
        FileChooser fcFile = new FileChooser(extension);
        return fcFile.fileChooser;
    }

    private void associarFiltro(String description, String extension) {
        javafx.stage.FileChooser.ExtensionFilter filtro = new javafx.stage.FileChooser.ExtensionFilter(description, extension);
        fileChooser.getExtensionFilters().add(filtro);
    }
}
