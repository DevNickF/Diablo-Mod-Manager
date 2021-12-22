package myD2RmmFolder;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import java.io.*;

public class a1D2Rmm extends Application
{
    public File myD2prefsFile, myD2argsFile;
    public FileWriter myD2writer;
    public FileReader myD2reader;
    public BufferedReader myD2buffRead;
    public Stage myD2stage;
    public Scene myD2scene;
    public AnchorPane myD2anchor;
    private String myStrMain, myStrMods, myStrTheme;
    public String line, myArgs;
    @FXML Button myPlayButton;
    @FXML Button myModButton;
    @FXML MenuBar myMainBar;

    // Start
    @Override
    public void start(Stage myD2stage) throws Exception
    {
        myFullSetup();
        myD2anchor = new AnchorPane();
        if (getMyTheme() == null || getMyTheme().equals("Theme:"))
            myD2anchor.setStyle("-fx-background-color: #96C8FA");
        else
            myD2anchor.setStyle(getMyTheme());
        myD2anchor.getChildren().add(FXMLLoader.load(getClass().getResource("a1D2Rdisplay.fxml")));
        myD2scene = new Scene(myD2anchor, 880, 600);
        myD2stage = new Stage();
        myD2stage.setMaxWidth(893);
        myD2stage.setMaxHeight(637);
        myD2stage.setTitle("My first program!!!");
        myD2stage.setScene(myD2scene);
        myD2stage.show();
    }

    public void myMainRefresh() throws IOException
    {
        myD2anchor = new AnchorPane();
        setMyTheme();
        myD2anchor.setStyle(getMyTheme());
        myD2anchor.getChildren().add(FXMLLoader.load(getClass().getResource("a1D2Rdisplay.fxml")));
        myD2scene = new Scene(myD2anchor, 879, 599);
        myD2stage = (Stage) Window.getWindows().get(0);
        myD2stage.setTitle("My first program!!!");
        myD2stage.setScene(myD2scene);
        myD2stage.show();
    }

    // Sets
    public void myFullSetup() throws IOException
    {
        setMyArgsFile();
        setMyPrefsFile();
        setMyMainPath();
        setMyModsPath();
        setMyTheme();
    }

    public void setMyArgsFile() throws IOException
    {
        myD2argsFile = new File("myD2RmmArgs.txt");
        if(myD2argsFile.createNewFile())
        {
            myD2reader = new FileReader(myD2argsFile);
            myD2buffRead = new BufferedReader(myD2reader);
            line = myD2buffRead.readLine();
            myD2buffRead.close();

            myD2writer = new FileWriter(myD2argsFile);
            if (line == null || line.equals(""))
                myD2writer.write("-direct -txt");
            myD2writer.close();
        }
        if(myD2argsFile.exists());
        this.myD2argsFile = myD2argsFile;
    }
    public File getMyArgsFile() { return myD2argsFile; }

    public void setMyPrefsFile() throws IOException
    {
        myD2prefsFile = new File("myD2RmmPrefs.ini");
        if(myD2prefsFile.createNewFile())
        {
            myD2reader = new FileReader(myD2prefsFile);
            myD2buffRead = new BufferedReader(myD2reader);
            line = myD2buffRead.readLine();
            myD2buffRead.close();

            myD2writer = new FileWriter(myD2prefsFile);
            if (line == null || line.equals(""))
                myD2writer.write("Prefs Path:" + myD2prefsFile.getAbsolutePath() + "\n\nArgs Path:" + getMyArgsFile().getAbsolutePath() + "\n\nMain Path:\n\nMods Path:\n\nTheme:-fx-background-color: #96C8FA");
            myD2writer.close();
        }
        if(myD2prefsFile.exists());
        this.myD2prefsFile = myD2prefsFile;
    }
    public File getMyPrefsFile() { return myD2prefsFile; }

    public void setMyMainPath() throws IOException
    {
        setMyPrefsFile();
        myD2reader = new FileReader(getMyPrefsFile());
        myD2buffRead = new BufferedReader(myD2reader);

        line = null;
        while ((line = myD2buffRead.readLine()) != null)
            if (line.startsWith("Main Path:"))
                myStrMain = line;
        myD2buffRead.close();

        if(myStrMain.length() > 10)
            this.myStrMain = myStrMain.substring(10).trim();
        else
            this.myStrMain = "";
    }
    public String getMyMainPath() { return myStrMain; }

    public void setMyModsPath() throws IOException
    {
        setMyPrefsFile();
        myD2reader = new FileReader(getMyPrefsFile());
        myD2buffRead = new BufferedReader(myD2reader);

        line = null;
        while ((line = myD2buffRead.readLine()) != null)
            if (line.startsWith("Mods Path:"))
                myStrMods = line;
        myD2buffRead.close();

        if(myStrMods.length() > 10)
            this.myStrMods = myStrMods.substring(10).trim();
        else
            this.myStrMods = "";
    }
    public String getMyModsPath() { return myStrMods; }

    public void setMyTheme() throws IOException
    {
        setMyPrefsFile();
        myD2reader = new FileReader(getMyPrefsFile());
        myD2buffRead = new BufferedReader(myD2reader);

        line = null;
        while ((line = myD2buffRead.readLine()) != null)
            if (line.startsWith("Theme:"))
                myStrTheme = line;
        myD2buffRead.close();

        if(myStrTheme.length() > 6)
            this.myStrTheme = myStrTheme.substring(6).trim();
        else
            this.myStrTheme = "";
    }
    public String getMyTheme() { return myStrTheme; }

    public static void main(String[] args) { launch(); }
}