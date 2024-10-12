package CollegeList;

public class Faculty extends Employee {
    private boolean status;

    public void setRegular(boolean status) {
        this.status = status;
    }

    public boolean isRegular() {
        return status;
    }
}
