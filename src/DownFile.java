import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.Scanner;

class DownFile {
    private String URL_CSV; // ссылка на файл csv
    private String DATA_WORK; // дата, на которую смотрят количество работ
    private int counter; // количество дорожних работ на заданную дату, счетчик

    DownFile(String URL_CSV, String DATA_WORK) { // конструктор
        this.URL_CSV = URL_CSV;
        this.DATA_WORK = DATA_WORK;
        counter = 0;

        try {
            try {
                URL commect = new URL(URL_CSV);
                InputStream stream = commect.openStream();
                Scanner inputstrim = new Scanner(stream);

                while (inputstrim.hasNext()){
                    String data = inputstrim.next();  //берем строку из файла
                    String value[] = data.split(","); // разбиваем строку из файла на массив строк

                    if(dataInPeriod(value[10], value[11])) { //проверяем входит ли дата в период работ
                        counter++;
                    }
                }
                inputstrim.close();
            }catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private boolean dataInPeriod(String dataBegin, String dataEnd) {
        LocalDate begin = LocalDate.parse(dataBegin);
        LocalDate end = LocalDate.parse(dataEnd);
        LocalDate work = LocalDate.parse(DATA_WORK);

        if(work.isBefore(work)||(work.isAfter(end))) {
            return false;
        } else return true;
    }

    public int getCounterWorks() {
        return counter;
    }











//        try {
//            BufferedInputStream in = new BufferedInputStream(new URL(URL_CSV).openStream());
//            FileOutputStream fileOutputStream = new FileOutputStream((FILE_NAME));
//                byte dataBuffer[] = new byte[1024];
//                int bytesRead;
//                while((bytesRead = in.read(dataBuffer, 0, 1024)) !=-1) {
//                    fileOutputStream.write(dataBuffer, 0, bytesRead);
//                }
//            } catch (IOException e) {
//            System.out.println(e);
//        }


//    //    InputStream in = new URL(URL_CSV).openStream();
//        Files.copy(in, Paths.get(FILE_NAME), StandardCopyOption.REPLACE_EXISTING);
//
//
//
//        URL connect = new URL(URL_CSV);
//        InputStream stream = connect.openStream();
//       // File file = new File(connect.getPath());
//        try {
//            Scanner inputStream = new Scanner(stream);
//            while (inputStream.hasNext()) {
//               String data = inputStream.next();
//
//                String values[] = data.split(",");
//                System.out.println(values);
//            }
//            inputStream.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//
//
//
//
//
//
//    }
}
