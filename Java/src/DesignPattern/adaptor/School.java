package adaptor;

public class School {
    public static void main(String[] args) {
        Pen pen=new PenAdapter();
        AssignmentWork assignmentWork=new AssignmentWork();
        assignmentWork.setP(pen);
        assignmentWork.writeAssignment("i am bit tired to write an assignment");
    }
}
