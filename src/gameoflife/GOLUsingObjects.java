package gameoflife;

public class GOLUsingObjects {
        private int SIZE = 20;
        public int fitness;



        public String initToString (){
            String result = "";
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (true) // TODO
                        result += "X";
                    else
                        result += "-";
                }
                result += "\n";
            }

            return result;
        }
        public String toString (){
            String result = "";
            for (int i = 0; i < SIZE; i++){
                for (int j = 0; j < SIZE; j++){
                    if (true) // TODO
                        result += "X";
                    else
                        result += "-";
                }
                result += "\n";
            }

            return result;
        }

}