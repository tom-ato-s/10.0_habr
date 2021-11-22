
//Практические задачи по Java
//https://habr.com/ru/post/440436/
//10.0. Количество дорожных ограничений
//Требуется определить, сколько дорожных ограничений действовало в городе на определенную дату.
//Программа в качестве аргумент получает два параметра:
// Путь к файлу с данными
// Дата



import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
//        String URL_CSV_main = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210322T091543-structure-20200120T130522.csv";
//        String DATA_main = "20140317";

        // https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210322T091543-structure-20200120T130522.csv 20210317
        InUrlData inUrlData = new InUrlData(); //пока не пользуемся

        System.out.println(inUrlData.getUrl());
        System.out.println(inUrlData.getData());

        DownFile downFile = new DownFile(inUrlData.getUrl(), inUrlData.getData());
//
     //   throw new  ParseException("dataInPeriod: error vthrows ParseException");
        System.out.println(downFile.getCounterWorks());
    }
}





