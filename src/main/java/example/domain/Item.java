package example.domain;

/**
 * DTO for a single item.
 * Created by ton on 30/05/16.
 */
public class Item {

    private int id;

    private String command;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    @Override
    public String toString() {
        return String.format("Item(%s,%s)", id, command);
    }
}
