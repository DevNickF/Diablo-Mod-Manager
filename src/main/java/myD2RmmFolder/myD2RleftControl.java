package myD2RmmFolder;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class myD2RleftControl extends a1D2Rmm implements Initializable
{
    @FXML private TableView<myD2Rleft> myMFtable;
    @FXML private TableColumn<myD2Rleft, String> myMFname;
    @FXML private TableColumn<myD2Rleft, String> myMFdate;
    @FXML private TableColumn<myD2Rleft, String> myMFmoddate;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        try
        {
            myMFname.setCellValueFactory(new PropertyValueFactory<myD2Rleft, String>("myMFname"));
            myMFdate.setCellValueFactory(new PropertyValueFactory<myD2Rleft, String>("myMFdate"));
            myMFmoddate.setCellValueFactory(new PropertyValueFactory<myD2Rleft, String>("myMFmoddate"));
            myMfBuilder();
        }
        catch (IOException e) { e.printStackTrace(); }
    }

    public void myMfBuilder() throws IOException
    {
        setMyModsPath();
        File myMfDir = new File(getMyModsPath());
        File[] myMfLists = myMfDir.listFiles();
        SimpleDateFormat myFormat = new SimpleDateFormat("MM/dd/yy");
        DateTimeFormatter artFormat = DateTimeFormatter.ofPattern("MM/dd/yy");
        FileTime creationTime;

        if (myMfDir.exists())
        {
            for(File myMfList : myMfLists)
            {
                if (myMfList.isDirectory())
                {
                    creationTime = (FileTime) Files.getAttribute(Paths.get(myMfList.getAbsolutePath()), "creationTime");
                    myD2Rleft myMFitem = new myD2Rleft(myMfList.getName(), artFormat.format(creationTime.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()), myFormat.format(myMfList.lastModified()));
                    myMFtable.getItems().add(myMFitem);
                }
            }
        }
    }

    @FXML public void rowOpenRClick() throws IOException
    {
        setMyModsPath();
        Desktop.getDesktop().open(new File(getMyModsPath() + "\\" + myMFtable.getSelectionModel().getSelectedItem().getMyMFname()));
    }

    @FXML public void myAddMod() throws IOException
    {
        setMyModsPath();
        DirectoryChooser myLeftDChooser = new DirectoryChooser();
        if (getMyModsPath() != null)
            myLeftDChooser.setInitialDirectory(new File(getMyModsPath()));
        myLeftDChooser.setTitle("Import Folder");
        File selectedLeftFolder = myLeftDChooser.showDialog(new Stage());
        if (selectedLeftFolder != null)
            Files.move(selectedLeftFolder.toPath(), new File(getMyModsPath() + "\\" + selectedLeftFolder.getName()).toPath(), REPLACE_EXISTING);
        myMainRefresh();
    }

    @FXML public void myOpenLink() throws IOException, URISyntaxException
    { Desktop.getDesktop().browse(new URL("https://www.nexusmods.com/diablo2resurrected/mods/139").toURI()); }
}

