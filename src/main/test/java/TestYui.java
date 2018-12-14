import com.bilibili.yl.entity.ResultEntity;
import com.bilibili.yl.enums.ResultCode;
import com.bilibili.yl.util.EntityUtils;
import com.bilibili.yl.util.SortUtils;
import org.junit.Test;

import java.util.Arrays;

import static com.bilibili.yl.util.MacUtils.getMac;
import static com.bilibili.yl.util.MacUtils.getOSName;

public class TestYui {
    @Test
    public void mail() {
        SortUtils sortUtil = new SortUtils();
        Integer[] integers = new Integer[]{1, 2, 89, 6, 7, 6, 86, 26, 878, 132, 789, 487};
        System.out.println(Arrays.toString(sortUtil.insertSort(integers)));
        System.out.println(Arrays.toString(sortUtil.sheelSort(integers)));
        System.out.println(Arrays.toString(sortUtil.selectSort(integers)));
        System.out.println(Arrays.toString(sortUtil.heapSort(integers)));
        System.out.println(Arrays.toString(sortUtil.bubbleSort(integers)));
        System.out.println(Arrays.toString(sortUtil.quickSort(integers, 0, integers.length - 1)));
    }

    @Test
    public void macTest() {
        String os = getOSName();
        String mac = getMac();
        System.out.println("os: " + os);
        System.out.println("mac: " + mac);
    }

    @Test
    public void Enums() {
        ResultEntity<String> result = new ResultEntity<>();
        result.setCodeAndMsg(ResultCode.SUCCESS);
        System.out.println(result);
    }
}
