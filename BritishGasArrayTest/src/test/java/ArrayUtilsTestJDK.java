import org.junit.Assert;
import org.junit.Test;

/**
 * Created by paul on 16/09/15.
 */

public class ArrayUtilsTestJDK {

    private Integer[] target = new Integer[] {2, 3, 4, 5};
    private Integer[] targetDoesntContain = new Integer[] {2, 3, 5, 5, 3, 1};
    private Integer[] targetEmpty = new Integer[] {};
    private Integer[] targetTooShort = new Integer[] {1};
    private Integer[] targetConfuse = new Integer[] {4, 4, 4, 4, 4, 4, 4};
    private Integer[] targetHasMany = new Integer[] {4, 5, 4, 5, 4, 5};
    private Integer[] toFind = new Integer[] {4, 5};
    private final static int CORRECT_INDEX_VALUE = 2;

    @Test
    public void testFindStartOfArrayJDK()
    {
        final int index = ArrayUtils.findStartOfArrayJDK(target, toFind);

        Assert.assertTrue("The index returned should be 2 but was " + index, index == CORRECT_INDEX_VALUE);

    }

    @Test(expected = NullPointerException.class)
    public void testFindStartOfArrayJDK_nullTargetParam()
    {
        ArrayUtils.findStartOfArrayJDK(null, toFind);
    }

    @Test(expected = NullPointerException.class)
    public void testFindStartOfArrayJDK_nullToFindParam()
    {
        ArrayUtils.findStartOfArrayJDK(target, null);
    }

    @Test
    public void testFindStartOfArrayJDK_targetDoesntContain()
    {
        final int index = ArrayUtils.findStartOfArrayJDK(targetDoesntContain, toFind);

        Assert.assertTrue("The index returned should be -1 but was " + index, index == ArrayUtils.ARRAY_NOT_FOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindStartOfArrayJDK_Empty()
    {
        final int index = ArrayUtils.findStartOfArrayJDK(targetEmpty, toFind);

        Assert.assertTrue("The index returned should be -1 but was " + index, index == ArrayUtils.ARRAY_NOT_FOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindStartOfArrayJDK_tooShortTarget()
    {
        ArrayUtils.findStartOfArrayJDK(targetTooShort, toFind);
    }

    @Test
    public void testFindStartOfArrayJDK_doesNotContain()
    {
        final int index = ArrayUtils.findStartOfArrayJDK(targetConfuse, toFind);

        Assert.assertTrue("The index returned should be -1 but was " + index, index == ArrayUtils.ARRAY_NOT_FOUND);
    }

    @Test
    public void testFindStartOfArrayJDK_hasMany()
    {
        final int index = ArrayUtils.findStartOfArrayJDK(targetHasMany, toFind);

        Assert.assertTrue("The index returned should be 0 but was " + index, index == 0);
    }
}
