import java.nio.ByteOrder;

/**
 * Created by Imran on 8/28/2014.
 * Java uses fixed endian-ness to store data, regardless of underlying platform's endian-ness. So data exchanges between
 * two java applications will not be affected by endian-ness.
 * Java integer size is 4 bytes.
 *
 */
public class Endian {
    public static void main(String[] args) {
        int i = 256;
        // Always fill zero for trailing positions. Unsigned right shift.
        int mask = -1 >>> 24;
        int result = i & mask;
        if(result == 0) {
            System.out.println("Little Endian");
        } else {
            System.out.println("Big Endian");
        }
        System.out.println(endian());
    }

    public static String endian() {
        return ByteOrder.nativeOrder().toString();
    }
}
