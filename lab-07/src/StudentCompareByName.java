import java.util.Comparator;

class StudentCompareByName implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        return student1.getName().compareTo(student2.getName());
    }
}
