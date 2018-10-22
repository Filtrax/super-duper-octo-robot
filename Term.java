package com.company.laby_po;

public class Term {
    public int hour;
    public int minute;
    public int duration;
    public Day day;

    public Term(int hour, int minute, Day day) {
        this.hour = hour;
        this.minute = minute;
        this.duration = 90;
        this.day = day;
    }
    public Term endTerm(){
        int a = this.hour;
        int b = this.minute + this.duration;
        while (b >=60){
            a += 1;
            b -= 60;
        }
        Term res = new Term(a,b,this.day);
        return res;
    }
}