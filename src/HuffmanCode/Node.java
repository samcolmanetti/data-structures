package HuffmanCode;


public class Node implements Comparable{
    public int value;
    public String letters;

    public Node (String letters, int value){
        this.letters = letters;
        this.value = value;
    }
    public boolean oneNode (){
        return this.letters.length() == 1;
    }
    @Override
    public int compareTo(Object o) {
        int result;
        Node node = (Node) o;
        if (this.value == node.value){
            if (this.letters.charAt(0) == ' ')
                result = 1;
            else {
                result = this.letters.charAt(0) - node.letters.charAt(0);
            }
        } else {
            result = this.value - node.value;
        }

        return result;
    }
}
