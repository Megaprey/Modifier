import java.util.ArrayList;

public class Modifier {

    private volatile static Modifier instance;
    private ArrayList<String>  mass = new ArrayList<String>(100);
    private volatile int counterPopulateCalls;

    public ArrayList<String> getMass() {
        return mass;
    }

    private Modifier() {}

    public static Modifier getInstance() {
        if (instance == null) {
            synchronized (Modifier.class) {
                if (instance == null) {
                    instance = new Modifier();
                }
            }
        }
        return instance;
    }

    public synchronized void populate(){
        String value;
        if(counterPopulateCalls == 0){
            for(int i = 0; i < 100; i++) {
                int random = (int) (Math.random() * 2);
                value = (random == 0) ? "Pass" : "Fail";
                mass.add(value);
            }
        }
        counterPopulateCalls = 1;
    }

    public String get(){
        int random = (int)(Math.random() * 100);
        return mass.get(random);
    }

    public synchronized void change(int index, String valueChange){
        mass.set(index, valueChange);
    }

}
