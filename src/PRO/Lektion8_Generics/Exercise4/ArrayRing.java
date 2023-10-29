package PRO.Lektion8_Generics.Exercise4;

import PRO.Lektion8_Generics.Exercise3.EmptyRingException;
import java.util.ArrayList;

public class ArrayRing<E> implements Ring {

    private ArrayList<Object> items = new ArrayList<>();
    private Object currentItem;

    @Override
    public void advance() {

        if(items.isEmpty()) { throw new EmptyRingException(); }
        currentItem = items.get(items.indexOf(currentItem) + 1);

    }

    @Override
    public Object getCurrentItem() {
        return currentItem;
    }

    @Override
    public void add(Object item) {

        items.add(item);
    }

    @Override
    public boolean removeItem(Object item) {

        if(item == currentItem){
            removeCurrentItem();
            return true;
        }
        else if(items.contains(item)){
            items.remove(item);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public Object removeCurrentItem() {
        currentItem = items.get(items.indexOf(currentItem) + 1);
        return null;
    }

    @Override
    public int size() {

        return items.size();
    }

    @Override
    public boolean isEmpty() {

        return items.isEmpty();
    }



}
