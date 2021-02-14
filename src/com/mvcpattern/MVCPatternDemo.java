public class MVCPatternDemo {

    private static StudentModel retriveStudentFromDatabase() {
        StudentModel studentModel = new StudentModel();
        studentModel.setRollNo("10");
        studentModel.setName("Gurkay");
        return studentModel;
    }

    public static void main(String[] args) {
        StudentModel studentModel = retriveStudentFromDatabase();
        StudentView studentView = new StudentView();
        StudentController studentController = new StudentController(studentModel, studentView);
        studentController.updateView();

        studentController.setStudentName("Halim");
        studentController.updateView();
        
    }
}
