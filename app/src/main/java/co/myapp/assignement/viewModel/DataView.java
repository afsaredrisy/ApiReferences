package co.myapp.assignement.viewModel;

public class DataView {
    private String message;

    private Attendance[] attendance;

    public String getMessage ()
    {
        return message;
    }

    public void setMessage (String message)
    {
        this.message = message;
    }

    public Attendance[] getAttendance ()
    {
        return attendance;
    }

    public void setAttendance (Attendance[] attendance)
    {
        this.attendance = attendance;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [message = "+message+", attendance = "+attendance+"]";
    }
}
