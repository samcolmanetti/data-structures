package HuffmanCode;


public class Node implements Comparable{
    public int value;
    public String letters;
    public char least;

    public Node (String letters, int value){
        this.letters = letters;
        this.value = value;
    }
    public void calcLeast (){
        char temp = letters.charAt(0);
        for (int i = 0; i < letters.length(); i++){
            if (letters.charAt(i) < temp && letters.charAt(i) != ' '){
                temp = letters.charAt(i);
            }
        }
        least = temp;
    }
    @Override
    public int compareTo(Object o) {
        int result;
        Node node = (Node) o;
        if (this.value == node.value){
            if (this.least == ' ')
                result = 1;
            else {
                result = this.least - node.least;
            }
        } else {
            result = this.value - node.value;
        }
        return result;
    }
}
