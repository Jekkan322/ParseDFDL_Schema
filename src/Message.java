public class Message {
    private int length;
    private String name;

    public Message(int length, String name) {
        this.length = length;
        this.name = name;
    }

    public Message() {
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Message{" +
                "length=" + length +
                ", name='" + name + '\'' +
                '}';
    }
}
