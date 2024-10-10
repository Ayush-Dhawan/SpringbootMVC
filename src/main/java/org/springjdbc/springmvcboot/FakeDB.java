package org.springjdbc.springmvcboot;

import java.util.ArrayList;
import java.util.List;

public class FakeDB {
    public List<Student> fakeDatabase;
    public FakeDB() {
        Student s1 = new Student();
        s1.setId(1);
        s1.setName("ayush");

        Student s2 = new Student();
        s2.setId(2);
        s2.setName("ayush2");

        fakeDatabase = new ArrayList<Student>();
        fakeDatabase.add(s1);
        fakeDatabase.add(s2);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FakeDB [");
        for (Object entry : fakeDatabase) {
            sb.append(entry.toString()).append(", ");
        }
        if (fakeDatabase.size() > 0) {
            sb.setLength(sb.length() - 2); // Remove trailing comma and space
        }
        sb.append("]");
        return sb.toString();
    }

}
