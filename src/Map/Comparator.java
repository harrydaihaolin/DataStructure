package Map;

public class Comparator<E> implements java.util.Comparator<E>
{
    @Override
    public int compare(E a, E b) throws ClassCastException
    {
        return ((Comparable<E>) a).compareTo(b);
    }

}
