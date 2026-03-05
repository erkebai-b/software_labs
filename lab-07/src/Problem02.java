import java.util.*;

//class Student {
//    private final String name;
//    private final double GPA;
//    private final int birthYear;
//
//    public String toString() {
//        return "Student{" +
//                "name='" + name + '\'' +
//                ", GPA=" + GPA +
//                ", birthYear=" + birthYear +
//                '}';
//    }
//
//    public Student(String name, double GPA, int birthYear) {
//        this.name = name;
//        this.GPA = GPA;
//        this.birthYear = birthYear;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public double getGPA() {
//        return GPA;
//    }
//
//    public int getBirthYear() {
//        return birthYear;
//    }
//}
public class Problem02 {
    public static void main(String[] args) {
        Student[] students = {
                new Student("StudentD", 2.5, 1998),
                new Student("StudentA", 4.0, 2001),
                new Student("StudentB", 3.0, 2001),
                new Student("StudentC", 3.5, 2000)
        };
        System.out.println("Sorting students by name");
        System.out.println("Before:");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new StudentCompareByName());
        System.out.println("After:");
        System.out.println(Arrays.toString(students) + "\n");

        System.out.println("Sorting students by GPA");
        System.out.println("Before:");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new StudentComparatorByGPA());
        System.out.println("After:");
        System.out.println(Arrays.toString(students) + "\n");

        System.out.println("Sorting students by birth year");
        System.out.println("Before:");
        System.out.println(Arrays.toString(students));
        Arrays.sort(students, new StudentCompareByBirthYear());
        System.out.println("After:");
        System.out.println(Arrays.toString(students) + "\n");
    }
}

