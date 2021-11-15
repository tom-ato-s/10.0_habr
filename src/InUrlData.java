import java.util.ArrayList;
import java.util.Scanner;

class InUrlData {
    private String inString;
    public ArrayList<String> arrL;

    public InUrlData() {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите адрес сайта и дату через пробел: ");
        inString = in.nextLine();
        doArrString(inString); // сделали массив значений из введенной строки
    }

    public String getUrl(){
        String stringUrl = arrL.get(0);
        return stringUrl;
    }

    public String getData(){
            String stringData = arrL.get(1);
        return stringData;
    }

    private void doArrString(String inString) { // делает массив строк из входящей строки
        StringBuilder sb = new StringBuilder();
        sb.append(inString);

        StringBuilder tempSb = new StringBuilder();
         arrL  = new ArrayList();  // создание массива строк
        int sizeArr = 0; //количество значений в водимой строке


        for(int i = 0; i<sb.length(); i++){

            if(arrL.size() == 0) { // первое значение в строке
                if(sb.charAt(i) != ' ') {
                    tempSb.append(sb.charAt(i));
                } else if (sb.charAt(i) == ' ') {
                    arrL.add(tempSb.toString());
                    tempSb.delete(0, tempSb.length());
                }
            } else if (arrL.size()>0) { //не первое значение в строке
                if(sb.charAt(i) != ' ') {
                    tempSb.append(sb.charAt(i));
                    if(i == sb.length()-1) {
                        arrL.add(tempSb.toString());
                    }
                } else if (sb.charAt(i) == ' ') {
                    arrL.add(tempSb.toString());
                    tempSb.delete(0, tempSb.length());
                }

            }

        }
    }



}
