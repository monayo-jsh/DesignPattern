import java.util.HashMap;
import java.util.Map;

public class BigCharFactory {

    private final Map<String, BigChar> pool = new HashMap<>();
    private static final BigCharFactory singleton = new BigCharFactory();

    private BigCharFactory() {}

    public static BigCharFactory getInstance() {
        return singleton;
    }

    public synchronized BigChar getBigChar(char charName) {
        String bigCharKey = String.valueOf(charName);
        BigChar bigChar = pool.get(bigCharKey);
        if (bigChar != null) return bigChar;

        bigChar = new BigChar(charName);
        pool.put(bigCharKey, bigChar);
        return bigChar;
    }
}
