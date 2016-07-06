package example.domain;

import java.util.Queue;

/**
 * DTO for a series of items.
 * Created by ton on 30/05/16.
 */
public class ItemCommand {

    private Item first;

    private Queue<Item> tail;

    public Item getFirst() {
        return first;
    }

    public void setFirst(Item first) {
        this.first = first;
    }

    public Queue<Item> getTail() {
        return tail;
    }

    public void setTail(Queue<Item> tail) {
        this.tail = tail;
    }

    @Override
    public String toString() {
        return String.format("ItemCommand(%s,%s in tail)", first, tail.size());
    }
}
