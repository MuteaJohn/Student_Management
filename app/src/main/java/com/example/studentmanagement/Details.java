package com.example.studentmanagement;

public class Details {
    private String name, subject, cat, exam, marks;

    public Details(){
    }

    public Details( String name, String subject, String cat, String exam, String marks){
        this.name = name;
        this.subject = subject;
        this.cat = cat;
        this.exam = exam;
        this.marks = marks;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getExam() {
        return exam;
    }

    public void setExam(String exam) {
        this.exam = exam;
    }

    public String getMarks() {
        return marks;
    }

    public void setMarks(String marks) {
        this.marks = marks;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSubject() {

        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void add(Details details) {
    }
}
