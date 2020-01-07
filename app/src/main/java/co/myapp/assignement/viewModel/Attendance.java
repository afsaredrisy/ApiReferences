package co.myapp.assignement.viewModel;

public class Attendance {
    private String late;

    private String totalLectures;

    private String absent;

    private String className;

    private String sick;

    private String present;

    public String getLate ()
    {
        return late;
    }

    public void setLate (String late)
    {
        this.late = late;
    }

    public String getTotalLectures ()
    {
        return totalLectures;
    }

    public void setTotalLectures (String totalLectures)
    {
        this.totalLectures = totalLectures;
    }

    public String getAbsent ()
    {
        return absent;
    }

    public void setAbsent (String absent)
    {
        this.absent = absent;
    }

    public String getClassName ()
    {
        return className;
    }

    public void setClassName (String className)
    {
        this.className = className;
    }

    public String getSick ()
    {
        return sick;
    }

    public void setSick (String sick)
    {
        this.sick = sick;
    }

    public String getPresent ()
    {
        return present;
    }

    public void setPresent (String present)
    {
        this.present = present;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [late = "+late+", totalLectures = "+totalLectures+", absent = "+absent+", className = "+className+", sick = "+sick+", present = "+present+"]";
    }
}
