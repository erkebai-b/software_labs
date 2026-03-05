import java.util.Comparator;

class StudentComparatorByGPA implements Comparator<Student> {

    public int compare(Student student1, Student student2) {
        return Double.compare(student1.getGPA(), student2.getGPA());
    }
}
