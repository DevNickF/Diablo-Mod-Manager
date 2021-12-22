package myD2RmmFolder;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class myD2RbarControl extends a1D2Rmm
{
    @FXML public void myFileOpen() throws IOException
    {
        setMyModsPath();
        FileChooser myBarFChooser = new FileChooser();
        myBarFChooser.setInitialDirectory(new File(getMyModsPath()));
        myBarFChooser.setTitle("Open File");
        File selectedBarFile = myBarFChooser.showOpenDialog(new Stage());
        if (selectedBarFile != null)
            Desktop.getDesktop().open(selectedBarFile);
    }

    @FXML public void myFileImport() throws IOException
    {
        setMyModsPath();
        DirectoryChooser myBarDChooser = new DirectoryChooser();
        if (getMyModsPath() != null)
            myBarDChooser.setInitialDirectory(new File(getMyModsPath()));
        myBarDChooser.setTitle("Import Folder");
        File selectedBarFolder = myBarDChooser.showDialog(new Stage());
        if (selectedBarFolder != null)
            Files.move(selectedBarFolder.toPath(), new File(getMyModsPath() + "\\" + selectedBarFolder.getName()).toPath(), REPLACE_EXISTING);
        myMainRefresh();
    }

    @FXML public void theGreatEscapeHaha() { Platform.exit(); }

    @FXML public void myPrefsOpen() throws IOException
    {
        setMyPrefsFile();
        Desktop.getDesktop().open(getMyPrefsFile());
    }

    @FXML public void myArgsOpen() throws IOException
    {
        setMyArgsFile();
        Desktop.getDesktop().open(getMyArgsFile());
    }

    @FXML public void myBlueTheme() throws IOException
    {
        myFullSetup();
        myD2writer = new FileWriter(getMyPrefsFile());
        myD2writer.write("Prefs Path: " + getMyPrefsFile().getAbsolutePath() + "\n\nArgs Path: " + getMyArgsFile().getAbsolutePath() + "\n\nMain Path:" + getMyMainPath() + "\n\nMods Path:" + getMyModsPath() + "\n\nTheme:-fx-background-color: #96C8FA");
        myD2writer.close();
        myMainRefresh();
    }

    @FXML public void myRedTheme() throws IOException
    {
        myFullSetup();
        myD2writer = new FileWriter(getMyPrefsFile());
        myD2writer.write("Prefs Path: " + getMyPrefsFile().getAbsolutePath() + "\n\nArgs Path: " + getMyArgsFile().getAbsolutePath() + "\n\nMain Path:" + getMyMainPath() + "\n\nMods Path:" + getMyModsPath() + "\n\nTheme:-fx-background-color: #FF6666");
        myD2writer.close();
        myMainRefresh();
    }

    @FXML public void myDarkTheme() throws IOException
    {
        myFullSetup();
        myD2writer = new FileWriter(getMyPrefsFile());
        myD2writer.write("Prefs Path: " + getMyPrefsFile().getAbsolutePath() + "\n\nArgs Path: " + getMyArgsFile().getAbsolutePath() + "\n\nMain Path:" + getMyMainPath() + "\n\nMods Path:" + getMyModsPath() + "\n\nTheme:-fx-background-color: #696969");
        myD2writer.close();
        myMainRefresh();
    }

    @FXML public void myOpenModDb() throws IOException, URISyntaxException
    { Desktop.getDesktop().browse(new URL("https://www.moddb.com/mods?filter=t&kw=&released=&genre=&theme=&players=&timeframe=&game=77513").toURI()); }

    @FXML public void myOpenNexus() throws IOException, URISyntaxException
    { Desktop.getDesktop().browse(new URL("https://www.nexusmods.com/diablo2resurrected").toURI()); }

    @FXML public void myOpenHome() throws IOException, URISyntaxException
    { Desktop.getDesktop().browse(new URL("https://www.nexusmods.com/diablo2resurrected/mods/139").toURI()); }
}

