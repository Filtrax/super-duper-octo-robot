package com.company.laby_po;

public class Lesson {

    public static void main( String[] args){
        Term termin = new Term(8,00,Day.MON);
        Lesson lekcja = new Lesson(termin, "Programowanie obiektowe",
                "Stanisław Polak", 2);
        System.out.println(lekcja.toString());
    }
    public Term term;
    public String name;
    public String teacherName;
    public int year;
    public boolean full_time;

    public Lesson(Term term, String name, String teacherName, int year) {
        this.term = term;
        this.name = name;
        this.teacherName = teacherName;
        this.year = year;
        this.full_time = !(term.day == Day.SUN || term.day == Day.SAT ||
                (term.day == Day.FRI && term.hour >= 17));
    }

    public String toString(){
        String rodzaj;
        if (this.full_time) rodzaj = "stacjonarnych";
        else rodzaj = "niestacjonarnych";
        return this.name + '(' + this.term.day.toString() + ' ' + this.term.hour + ":"
                + this.term.minute + '-' +this.term.endTerm().hour + ':' +
                this.term.endTerm().minute + ')' + '\n' + this.year + " rok studiów " +
                rodzaj + '\n' + "Prowadzący:" + this.teacherName;
    }
    public boolean earlierDay(){
        if (this.term.day == Day.MON || (this.term.day == Day.SAT && this.term.hour <17) ||
                (this.term.day == Day.FRI && this.term.hour >= 17))
        { System.out.println("złe przesunięcie");
            return false;
        }
        this.term.day = this.term.day.earlierDay();
        return true;
    }
    public boolean laterDay(){
        if (this.term.day == Day.SUN || (this.term.day == Day.FRI && this.term.hour < 17) ||
                (this.term.day == Day.THU && this.term.hour >= 17))
        { System.out.println("złe przesunięcie");
            return false;
        }
        this.term.day = this.term.day.nextDay();
        return true;
    }
    public boolean earlierTime(){
        int a = this.term.minute - this.term.duration;
        int b = this.term.hour;
        while ( a < 0 ){
            a += 60;
            b -=1;
        }
        if ( b < 8 )
        { System.out.println("złe przesunięcie");
            return false;
        }
        this.term.minute -= this.term.duration;
        return true;
    }
    public boolean laterTime(){
        Term temp = this.term.endTerm();


        if ( )
        { System.out.println("złe przesunięcie");
            return false;
        }
        this.term.minute -= this.term.duration;
        return true;
    }
}