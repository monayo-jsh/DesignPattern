package second.framework;

import java.util.HashMap;
import java.util.Map;

public class CopyManager {

    private final Map<String, CopyProduct> showcase = new HashMap<>();

    public void register(String name, CopyProduct prototype) {
        showcase.put(name, prototype);
    }

    public CopyProduct create(String prototypeName) {
        CopyProduct product = showcase.get(prototypeName);
        return product.createCopy();
    }
}
