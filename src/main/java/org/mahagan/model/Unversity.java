package org.mahagan.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "unversity1")
public class Unversity {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int unversityId;
    private String unversityName;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "unversityId")
    @OrderColumn(name = "list")
    private List<Student>students;

    public int getUnversityId() {
        return unversityId;
    }

    public void setUnversityId(int unversityId) {
        this.unversityId = unversityId;
    }

    public String getUnversityName() {
        return unversityName;
    }

    public void setUnversityName(String unversityName) {
        this.unversityName = unversityName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
