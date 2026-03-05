import java.util.Comparator;

class StudentCompareByBirthYear implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        return Integer.compare(student1.getBirthYear(), student2.getBirthYear());
    }
}
