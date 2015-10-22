package controller;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rafael
 */
public class Memoria {

    private static Map memoria;

    public Memoria() {
        if (memoria != null) {
            memoria = new HashMap();
        }
    }

    public void add(String id, Object object) {
        memoria.put(id, object);
    }

    public Object get(String id) {
        return memoria.get(id);
    }

    public Map getAll() {
        return memoria;
    }

}
