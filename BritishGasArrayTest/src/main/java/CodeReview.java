import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by paul on 16/09/15.
 *
 * See below for code review
 */
public class CodeReview {

//    public LinkedList getOfflineDevicesForUser(User user, boolean debug) {
//        ArrayList l = new ArrayList();
//        List allDevices = deviceRepository.getAll();
//
//        for (int x=0; x<allDevices.size();x++) {
//            boolean found = false;
//            List owners = ((Device) allDevices.get(x)).getOwners();
//            if (owners.size() > 0) {
//                for (int y = 0; y < owners.size(); y++) {
//                    User owner = (User) owners.get(x);
//                    found = (owner == user);
//                }
//                if (found && allDevices != null)
//                    l.add(allDevices.get(x));
//            }
//        }
//
//        return new LinkedList(l);
//    }

    /**
     * Note: I have commented out the above code so that the project will build - please see the readme.txt file for the rest of the answers
     *
     * I would do this in person in something like a pair programming exercise to promote a conversation
     *
     * use some common formatting scheme i.e. googles coding standards
     *
     * Before method: have some java doc
     * Line 12: return a List instead of a LinkedList, have the method parameters final if you are not intending on
     * changing them. Also remove debug as your not using it (why would you even need to debug on code lvl?)
     *
     * Start of method: place some pre conditions on the method. Checks for things like null etc
     * Line 13: program against an interface i.e. List instead of a concrete class (Arraylist), use generics! i.e. List<Device>
     *     also use a better variable name i.e. devices. If using guava use the Lists class to generate a new list
     *
     * Line 14: Generics yet again. use a getter for the deviceRepository i.e. getDeviceRepository()
     *
     * Line 15: enhanced for loop
     *
     * Line 18: List<User> - no casting needed if you used List<Device>
     * Line 19: Use !Collections.isEmpty which is null safe
     * Line 20: enhanced for loop
     * Line 21: wouldn't be required if using enhanced for loop
     * Line 22: replace this with something like line 25 wrap in if(owner.getId().equals(user.getId()))
     * Line 24 - 25: not required if in the second for loop - also please use curly braces
     * Line 29: return the list defined in line 13
     */

}
