package memoria;

import java.util.ArrayList;

/**
 *
 * @author Rafael
 */
public class Memoria {

    private static ArrayList<Object> memoria;

    public Memoria() {
        if (memoria == null) {
            memoria = new ArrayList<>();
        }
    }

    public void add(Object object) {
        memoria.add(object);
    }

    public ArrayList<Object> getAll() {
        return memoria;
    }

    public ArrayList<Object> getAll(Class className) {
        ArrayList<Object> temp = new ArrayList<>();
        for (Object mem : memoria) {
            if (className.isInstance(mem)) {
                temp.add(mem);
            }
        }
        return temp;
    }

}
