import com.cy.jrs.base.Galois;
import org.junit.Test;
import java.util.Arrays;

public class GaloisTest {

    @Test
    public void test0() {
        byte[] bytes = Galois.generateExpTable();
        System.out.println(Arrays.toString(bytes));
        Integer[] integers = Galois.allPossiblePolynomials();
        System.out.println(Arrays.toString(integers));
        short[] shorts = Galois.generateLogTable(29);

        System.out.println(Arrays.toString(shorts));
    }

}
