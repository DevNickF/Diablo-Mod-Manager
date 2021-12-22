package myD2RmmFolder;

import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class myD2Rright
{
    private String argue;
    private RadioButton select;

    public myD2Rright(String argue, ToggleGroup mySelectGroup)
    {
        setSelect(new RadioButton());
        getSelect().setToggleGroup(mySelectGroup);
        this.argue = argue;
    }

    public RadioButton getSelect() { return select; }
    public void setSelect(RadioButton select) { this.select = select; }

    public String getMyRargue() { return argue; }
    public void setMyRargue(String argue) { this.argue = argue; }
}
