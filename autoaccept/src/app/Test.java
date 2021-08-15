package app;

enum Der {
    LOW(1),MID(2),HIGH(2);

    int zahl;


    Der(int a){
        this.zahl = a;
    }


}
public class Test{
public static void main(String[] args) {
    
    
    for(Der i : Der.values()){
        System.out.println(i.zahl);

    }

    
}

@Override
public String toString() {
    return "Test []";
}
}

