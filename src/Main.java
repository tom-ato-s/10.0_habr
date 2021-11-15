public class Main {

    public static void main(String[] args) {
        String URL_CSV_main = "https://data.gov.spb.ru/opendata/7803032323-block_traffic/data-20210322T091543-structure-20200120T130522.csv";
        String DATA_main = "20140318";
//        InUrlData inUrlData = new InUrlData();
//
//        System.out.println(inUrlData.getUrl());
//        System.out.println(inUrlData.getData());

       // DownFile downFile = new DownFile(inUrlData.getUrl(), inUrlData.getData());  // пока не используем
        DownFile downFile = new DownFile(URL_CSV_main, DATA_main);


      //  System.out.println(downFile.getCounterWorks());
    }
}
