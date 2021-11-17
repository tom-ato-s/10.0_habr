import java.text.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        String URL_CSV_main = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210322T091543-structure-20200120T130522.csv";
        String DATA_main = "20140317";
//        InUrlData inUrlData = new InUrlData(); //пока не пользуемся
//
//        System.out.println(inUrlData.getUrl());
//        System.out.println(inUrlData.getData());

       // DownFile downFile = new DownFile(inUrlData.getUrl(), inUrlData.getData());  // пока не используем
        DownFile downFile = new DownFile(URL_CSV_main, DATA_main);
//
         boolean petiod = downFile.dataInPeriod("20140317", "20140319");
        System.out.println(petiod);

     //   throw new  ParseException("dataInPeriod: error vthrows ParseException");
      //  System.out.println(downFile.getCounterWorks());
    }
}





