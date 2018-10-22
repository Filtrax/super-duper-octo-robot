package com.company.laby_po;

public enum Day {
    MON,TUE,WED,THU,FRI,SAT,SUN;

    public String toString() {
        switch (this) {
            case FRI:
                return "piątek";
            case MON:
                return "poniedziałek";
            case SAT:
                return "sobota";
            case SUN:
                return "niedziela";
            case THU:
                return "czwartek";
            case TUE:
                return "wtorek";
            case WED:
                return "środa";
            default:
                return "blaaddddddd";

        }
    }
    public Day earlierDay(){
        switch (this) {
            case FRI:
                return THU;
            case MON:
                return SUN;
            case SAT:
                return FRI;
            case SUN:
                return SAT;
            case THU:
                return WED;
            case TUE:
                return MON;
            case WED:
                return TUE;
            default:
                return MON;

        }
    }
    public Day nextDay(){
        switch (this) {
            case FRI:
                return SUN;
            case MON:
                return TUE;
            case SAT:
                return SUN;
            case SUN:
                return MON;
            case THU:
                return FRI;
            case TUE:
                return WED;
            case WED:
                return THU;
            default:
                return MON;

        }
    }
}
