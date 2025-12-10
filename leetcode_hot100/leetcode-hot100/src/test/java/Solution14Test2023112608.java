import codes.Solution14;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Arrays;


public class Solution14Test2023112608 {
    private Solution14 solution;
    
    @Before
    public void setUp() {
        // 每个测试方法执行前创建新的实例，确保测试隔离
        solution = new Solution14();
    }
    
    @Test
    public void testSolution14(){
        String s = "25525511135";
        List<String> ans = solution.restoreIpAddresses(s);
        List<String> expected = Arrays.asList("255.255.11.135", "255.255.111.35");
        // 验证结果不为空且包含期望的结果
        assertNotNull("结果不应为null", ans);
        assertEquals("结果数量应正确", expected.size(), ans.size());
        assertTrue("应包含期望的结果", ans.containsAll(expected));
    }
    
    @Test
    public void testSolution14WithZero() {
        String s = "0000";
        List<String> ans = solution.restoreIpAddresses(s);
        List<String> expected = Arrays.asList("0.0.0.0");
        assertNotNull("结果不应为null", ans);
        assertEquals("结果数量应正确", expected.size(), ans.size());
        assertTrue("应包含期望的结果", ans.containsAll(expected));
    }
    
    @Test
    public void testSolution14WithMultipleResults() {
        String s = "101023";
        List<String> ans = solution.restoreIpAddresses(s);
        List<String> expected = Arrays.asList("1.0.10.23", "1.0.102.3", "10.1.0.23", "10.10.2.3", "101.0.2.3");
        assertNotNull("结果不应为null", ans);
        assertEquals("结果数量应正确", expected.size(), ans.size());
        assertTrue("应包含期望的结果", ans.containsAll(expected));
    }
}
