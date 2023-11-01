package PRO.Lektion8_Generics.Exercise4;

import java.util.ArrayList;

public class ArrayRing<E> implements Ring {

    private final ArrayList<Object> items = new ArrayList<>();
    private Object currentItem;

    @Override
    public void advance() {

        if (items.isEmpty()) { throw new EmptyRingException(); }

        // if currentItem is highest index, advance currentItem to lowest index
        if (items.indexOf(currentItem) == items.size() - 1) { currentItem = items.get(0); }
        else {
            // Otherwise, advance to the next link of the chain
            currentItem = items.get(items.indexOf(currentItem) + 1);
        }

    }

    @Override
    public Object getCurrentItem() { return currentItem; }

    @Override
    public void add(Object item) {

        if (items.indexOf(currentItem) == items.size()) {
            items.add(item);
        }

        // Shift links of the chain 1 up to make space for new add
        // .add(index, object) - inserts the specified element E at the specified position in this list.
        // It shifts the element currently at that position (if any) and any subsequent elements to the right
        // (will add one to their indices).
        items.add(items.indexOf(currentItem) + 1, item);

        currentItem = item;
    }

    @Override
    public boolean removeItem(Object item) {

        if (item == currentItem) {
            removeCurrentItem();
            return true;
        }
        else if (items.contains(item)) {

            int index = items.indexOf(currentItem);

            // if currentItem is last entry
            if (index == items.size() - 1) {
                // remove old currentItem
                items.remove(index);
                // set new currentItem at index start
                // (wrap around: endIndex+1 = startIndex)
                currentItem = items.get(0);
            }
            else {
                // set NEW currentItem to the item AFTER the old currentItem
                currentItem = items.get(items.indexOf(item) + 1);
                // remove old currentItem
                items.remove(item);

            }

            return true;
        }
        else {
            return false;
        }
    }

    /**
     * Remove the current item.
     * The new current item is the item after the removed item.
     * Throws EmptyRingException, if the ring is empty.
     */
    @Override
    public Object removeCurrentItem() {

        if (items.isEmpty()) { throw new EmptyRingException(); }

        int index = items.indexOf(currentItem);

        // if currentItem is last entry
        if (index == items.size() - 1) {
            // remove old currentItem
            items.remove(index);
            // set new currentItem at index start
            // (wrap around: endIndex+1 = startIndex)
            currentItem = items.get(0);
        }
        else {
            // set new currentItem to item -after- old currentItem
            currentItem = items.get(index + 1);
            // remove old currentItem
            items.remove(index);
        }

        return null;
    }

    @Override
    public int size() { return items.size(); }

    @Override
    public boolean isEmpty() { return items.isEmpty(); }

    public void clear() {

        currentItem = null;
        items.clear();
    }

}
