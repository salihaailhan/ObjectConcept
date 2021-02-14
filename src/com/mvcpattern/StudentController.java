import com.mvcpattern;

public class StudentController {
    private StudentModel studentModel;
    private StudentView studentView;

    public StudentController(StudentModel model, StudentView view){
        this.studentModel = model;
        this.studentView = view;
    }

    public String getStudentRollNo() {
        return studentModel.getRollNo();
    }
    public void setStudentRollNo(String rollNo) {
        studentModel.setRollNo(rollNo);
    }

    public String getStudentName() {
        return studentModel.getName();
    }
    public void setStudentName(String name) {
        studentModel.setName(name);
    }

    public void updateView() {
        studentView.printStudentDetails(studentModel.getRollNo(), studentModel.getName());
    }
}
