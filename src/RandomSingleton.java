import java.util.Random;
/**
 * Created by Greymoon on 9/28/2016.
 */
public class RandomSingleton {
    private static Random random = new Random(System.currentTimeMillis());
    public static int RandomIntInRange(int lowerBoundInclusive, int upperBoundInclusive){
        return random.nextInt(upperBoundInclusive + 1) + lowerBoundInclusive;
    }
}
