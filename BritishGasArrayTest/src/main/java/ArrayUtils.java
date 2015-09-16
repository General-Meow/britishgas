import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by paul on 16/09/15.
 *
 * Admittedly I spent more than 20 minutes on this but I wanted to get it right.
 *
 * I'm not sure what your looking for here but i've provided 2 implementations as you may think
 * one of them is not actually doing much as its using the utilities provided in the JDK
 *
 * findStartOfArrayJDK are not the codes your looking for (waves hand across)
 */
public class ArrayUtils {

    public static final int ARRAY_NOT_FOUND = -1;

    /**
     * Find the first index of an array in a target array using the provided JDK utils
     * @param target to array to search through
     * @param toFind the array to look for in the target
     * @return index of the first instance or -1 if not found
     */
    public static int findStartOfArrayJDK(final Integer[] target, final Integer[] toFind)
    {
        Preconditions.checkNotNull(target);
        Preconditions.checkNotNull(toFind);
        Preconditions.checkArgument(target.length > 0, "target array should not be empty");
        Preconditions.checkArgument(toFind.length > 0, "toFind array should not be empty");
        Preconditions.checkArgument(toFind.length < target.length, "target array cannot be smaller than toFind");

        return Collections.indexOfSubList(Lists.newArrayList(target), Lists.newArrayList(toFind));
    }


    /**
     * Custom find algorithm that finds the first index of an array in a target array
     * @param target to array to search through
     * @param toFind the array to look for in the target
     * @return index of the first instance or -1 (ARRAY_NOT_FOUND) if not found
     */
    public static int findStartOfArray(final Integer[] target, final Integer[] toFind)
    {
        Preconditions.checkNotNull(toFind);
        Preconditions.checkNotNull(target);
        Preconditions.checkArgument(toFind.length > 0, "toFind array should not be empty");
        Preconditions.checkArgument(target.length > 0, "target array should not be empty");
        Preconditions.checkArgument(toFind.length <= target.length, "target array cannot be smaller than toFind");

        int index = ARRAY_NOT_FOUND;
        for(int i = 0; i < target.length; i++)
        {
            //is there a point in continuing the search?
            if((target.length - i) < toFind.length)
            {
                break;
            }

            //find first index
            if(target[i] == toFind[0])
            {
                if(containsArray(Arrays.copyOfRange(target, i, target.length), toFind))
                {
                    index = i;
                    break;
                }
            }
        }

        return index;
    }


    /**
     * Companion method to findStartOfArray that returns true if the target array contains
     * the toFind array from the beginning.
     * @param target to array to search through
     * @param toFind the array to look for in the target
     * @return true if the target contains the toFind array
     */
    private static boolean containsArray(final Integer[] target, final Integer[] toFind)
    {
        Preconditions.checkNotNull(toFind);
        Preconditions.checkNotNull(target);
        Preconditions.checkArgument(toFind.length > 0, "toFind array should not be empty");
        Preconditions.checkArgument(target.length > 0, "target array should not be empty");
        Preconditions.checkArgument(toFind.length <= target.length, "target array cannot be smaller than toFind");

        boolean found = true;
        for(int i = 0; i < toFind.length; i++)
        {
            if(toFind[i] != target[i])
            {
                found = false;
                break;
            }
        }

        return found;
    }
}
