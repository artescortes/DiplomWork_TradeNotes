package com.example.tradenotediplomwork;

import javafx.scene.control.TableView;

public class CourseTable {
    private int course_id;
    private String course_name;
    private Double current_price;
    private Double current_course;
    public TableView<CourseTable> tableViewKurs;

    public CourseTable(int course_id, String course_name, Double current_price, Double current_course) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.current_price = current_price;
        this.current_course = current_course;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Double getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(Double current_price) {
        this.current_price = current_price;
    }

    public Double getCurrent_course() {
        return current_course;
    }

    public void setCurrent_course(Double current_course) {
        this.current_course = current_course;
    }
}
