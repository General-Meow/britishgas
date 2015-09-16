import org.junit.Assert;
import org.junit.Test;

/**
 * Created by paul on 16/09/15.
 */
public class ArrayUtilsTestCustom {
    private Integer[] target = new Integer[] {2, 3, 4, 5};
    private Integer[] targetDoesntContain = new Integer[] {2, 3, 5, 5, 3, 1};
    private Integer[] targetEmpty = new Integer[] {};
    private Integer[] targetTooShort = new Integer[] {1};
    private Integer[] targetConfuse = new Integer[] {4, 4, 4, 4, 4, 4, 4};
    private Integer[] targetHasMany = new Integer[] {4, 5, 4, 5, 4, 5};
    private Integer[] toFind = new Integer[] {4, 5};
    private final static int CORRECT_INDEX_VALUE = 2;

    @Test
    public void testFindStartOfArray()
    {
        final int index = ArrayUtils.findStartOfArray(target, toFind);

        Assert.assertTrue("The index returned should be 2 but was " + index, index == CORRECT_INDEX_VALUE);
    }

    @Test(expected = NullPointerException.class)
    public void testFindStartOfArray_nullTargetParam()
    {
        ArrayUtils.findStartOfArray(null, toFind);
    }

    @Test(expected = NullPointerException.class)
    public void testFindStartOfArray_nullToFindParam()
    {
        ArrayUtils.findStartOfArray(target, null);
    }

    @Test
    public void testFindStartOfArray_targetDoesntContain()
    {
        final int index = ArrayUtils.findStartOfArray(targetDoesntContain, toFind);

        Assert.assertTrue("The index returned should be -1 but was " + index, index == ArrayUtils.ARRAY_NOT_FOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindStartOfArray_Empty()
    {
        final int index = ArrayUtils.findStartOfArray(targetEmpty, toFind);

        Assert.assertTrue("The index returned should be -1 but was " + index, index == ArrayUtils.ARRAY_NOT_FOUND);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindStartOfArray_tooShortTarget()
    {
        ArrayUtils.findStartOfArray(targetTooShort, toFind);
    }

    @Test
    public void testFindStartOfArray_doesNotContain()
    {
        final int index = ArrayUtils.findStartOfArray(targetConfuse, toFind);

        Assert.assertTrue("The index returned should be -1 but was " + index, index == ArrayUtils.ARRAY_NOT_FOUND);
    }

    @Test
    public void testFindStartOfArray_hasMany()
    {
        final int index = ArrayUtils.findStartOfArray(targetHasMany, toFind);

        Assert.assertTrue("The index returned should be 0 but was " + index, index == 0);
    }
}
