package myD2RmmFolder;

public class myD2Rleft
{
    private String name;
    private String date;
    private String moddate;

    public myD2Rleft(String name, String date, String moddate)
    {
        this.name = name;
        this.date = date;
        this.moddate = moddate;
    }

    public String getMyMFname() { return name; }
    public void setMyMFname(String name) { this.name = name; }

    public String getMyMFdate() { return date; }
    public void setMyMFdate(String date) { this.date = date; }

    public String getMyMFmoddate() { return moddate; }
    public void setMyMFmoddate(String moddate) { this.moddate = moddate; }
}

