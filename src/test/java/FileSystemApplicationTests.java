import com.cy.jrs.utils.ReedSolomon;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;

public class FileSystemApplicationTests {

    @Test
    public void qqqq(){
        ReedSolomon reedSolomon = ReedSolomon.create(6, 3);
    }


    @Test
    public void xxxy() {
        int []arr =new int []{1,2,3,4};
        int []brr = new int[4];

        System.arraycopy(arr, 0, brr, 0, 4);

        brr[2]=8;

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(brr));

        int [][] crr =new int[3][3];

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                crr[i][j]=i*10+j;
            }
        }
        int [][] drr =new int[3][];

        System.arraycopy(crr, 0, drr, 0, 3);
        drr[1][2]=0;
        System.out.println(Arrays.deepToString(crr));
        System.out.println(Arrays.deepToString(drr));

    }

}
