public class ElementList {
    private Element[] list = new Element[10];
    private int index;

    public String getData(String key) {
        String res = "";

        for (int i = 0; i < index; i++)
            if (list[i].getKey().equals(key))
                res = list[i].getData();

        return res;
    }

    public void addElement(Element el) {
        list[index++] = el;
    }
}
