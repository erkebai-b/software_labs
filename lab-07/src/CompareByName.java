class CompareByName implements MyComparator {
    @Override
    public int compare(Object student1, Object student2) {
        return ((Student) student1).getName().compareTo(((Student) student2).getName());
    }
}
