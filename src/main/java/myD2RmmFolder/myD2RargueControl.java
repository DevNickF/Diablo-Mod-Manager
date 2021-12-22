package myD2RmmFolder;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.FileWriter;
import java.io.IOException;

public class myD2RargueControl extends a1D2Rmm
{
    @FXML TextField myArgueField;
    @FXML Button myCancelBtn;

    @FXML public void myAddArgue() throws IOException
    {
        setMyArgsFile();
        myD2writer = new FileWriter(getMyArgsFile(), true);
        myD2writer.append("\n" + myArgueField.getText());
        myD2writer.close();
        myD2stage = (Stage) myCancelBtn.getScene().getWindow();
        myD2stage.close();
        myMainRefresh();
    }

    @FXML public void myCancel()
    {
        myD2stage = (Stage) myCancelBtn.getScene().getWindow();
        myD2stage.close();
    }
}

