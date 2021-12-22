package myD2RmmFolder;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

public class myD2RrightControl extends a1D2Rmm implements Initializable
{
    @FXML TextField myMainField, myModsField;
    @FXML private TableView<myD2Rright> myRtable;
    @FXML private TableColumn<myD2Rright, String> myRargue;
    @FXML private TableColumn<myD2Rright, RadioButton> myRselect;
    private String myArgue;
    public ToggleGroup mySelectGroup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            myRselect.setCellValueFactory(new PropertyValueFactory<myD2Rright, RadioButton>("select"));
            myRargue.setCellValueFactory(new PropertyValueFactory<myD2Rright, String>("myRargue"));
            myRBuilder();
            setMyD2Rpaths();
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void myRBuilder() throws IOException
    {
        setMyArgsFile();
        File myRfile = new File(getMyArgsFile().getAbsoluteFile().toString());
        myD2reader = new FileReader(myRfile);
        myD2buffRead = new BufferedReader(myD2reader);
        if (myRfile.exists())
        {
            mySelectGroup = new ToggleGroup();
            line = null;
            while ((line = myD2buffRead.readLine()) != null)
            {
                myD2Rright myRitem = new myD2Rright(line, mySelectGroup);
                myRtable.getItems().add(myRitem);
            }
            myD2buffRead.close();
        }
    }

    public void setMyD2Rpaths() throws IOException
    {
        setMyMainPath();
        setMyModsPath();
        myMainField.setText(getMyMainPath());
        myModsField.setText(getMyModsPath());
    }

    @FXML public void myGameOn() throws IOException
    {
        setMyMainPath();
        myArgs = getMyArgue();
        Runtime.getRuntime().exec(getMyMainPath().replace("\\", "\\\\") + " " + myArgs);
        System.out.println(getMyMainPath().replace("\\", "\\\\") + " " + myArgs);
    }

    @FXML public void myRselected()
    {
        if(myRtable.getSelectionModel().getSelectedItem() != null)
        {
            setMyArgue(myRtable.getSelectionModel().getSelectedItem().getMyRargue());
            myRtable.getSelectionModel().getSelectedItem().getSelect().setSelected(true);
        }
    }

    @FXML public void myShowArgs() throws IOException
    {
        myFullSetup();
        myD2anchor = new AnchorPane();
        if (getMyTheme() == null || getMyTheme().equals("Theme:"))
            myD2anchor.setStyle("-fx-background-color: #96C8FA");
        else
            myD2anchor.setStyle(getMyTheme());
        myD2anchor.getChildren().add(FXMLLoader.load(getClass().getResource("myD2Rargue.fxml")));
        myD2scene = new Scene(myD2anchor, 400, 180);
        myD2stage = new Stage();
        myD2stage.setMaxWidth(420);
        myD2stage.setMaxHeight(217);
        myD2stage.setTitle("Add Arguments Here...");
        myD2stage.setScene(myD2scene);
        myD2stage.show();
    }

    @FXML public void myPathUpdater() throws IOException
    {
        myFullSetup();
        myD2writer = new FileWriter(getMyPrefsFile());
        myD2writer.write("Prefs Path: " + getMyPrefsFile().getAbsolutePath() + "\n\nArgs Path: " + getMyArgsFile().getAbsolutePath() + "\n\nMain Path:" + myMainField.getText() + "\n\nMods Path:" + myModsField.getText() + "\n\nTheme:" + getMyTheme());
        myD2writer.close();
        myMainRefresh();
    }

    public void setMyArgue(String myArgue) { this.myArgue = myArgue; }
    public String getMyArgue() { return myArgue; }
}

