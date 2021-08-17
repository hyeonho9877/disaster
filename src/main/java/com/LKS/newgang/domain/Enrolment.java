package com.LKS.newgang.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Enrolment {
    @Id
    private int no;
    @JoinColumn(name = "std_no")
    @ManyToOne
    private Student std_no;
    @JoinColumn(name = "lec_no")
    @ManyToOne
    private Lecture lec_no;

    public int getNo() {
        return no;
    }

    public Student getStd_no() {
        return std_no;
    }

    public Lecture getLec_no() {
        return lec_no;
    }
}
