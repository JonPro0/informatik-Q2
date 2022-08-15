package trees;

public class BinaryTree {
    Knoten<Integer> wurzel;

    public BinaryTree() {
        wurzel = new Knoten<Integer>(5);
        wurzel.setLinks(new Knoten<>(8));
        wurzel.getLinks().setLinks(new Knoten<>(18));
        wurzel.getLinks().setRechts(new Knoten<>(3));

        wurzel.setRechts(new Knoten<>(6));
        wurzel.getRechts().setLinks(new Knoten<>(36));
        wurzel.getRechts().setRechts(new Knoten<>(4));
        wurzel.getRechts().getRechts().setLinks(new Knoten<>(12));
    }

}

class Knoten<T> {
    private Knoten<T> links, rechts;

    public Knoten(T data) {
        this.data = data;
    }

    public Knoten(Knoten<T> links, Knoten<T> rechts, T data) {
        this.links = links;
        this.rechts = rechts;
        this.data = data;
    }

    public Knoten<T> getLinks() {
        return links;
    }

    public void setLinks(Knoten<T> links) {
        this.links = links;
    }

    public Knoten<T> getRechts() {
        return rechts;
    }

    public void setRechts(Knoten<T> rechts) {
        this.rechts = rechts;
    }

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void gibAus() {
        System.out.println(data);
        if (getLinks() != null) getLinks().gibAus();
        if (getRechts() != null) getRechts().gibAus();
    }
}
