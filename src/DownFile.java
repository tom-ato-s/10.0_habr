import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Stream;

class DownFile {
    private final String URL_CSV; // ссылка на файл csv
    private final String DATA_WORK; // дата, на которую смотрят количество работ
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

                //         System.out.println(inputstrim.nextLine());
                while ((inputstrim.hasNext())) {
                    String data = inputstrim.nextLine();  //берем строку из файла
                    //System.out.println(data);
                    String value[] = spliter(data);

                    counter10_11(value[10], value[11]);
                }

                inputstrim.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void counter10_11(String begin,String end) {
       LocalDate work = parsingToDate( DATA_WORK);

        if((isValue(begin) == true) &&(isValue(end) == true)) {
            LocalDate beginData = parsingToDate(begin);
            LocalDate endData = parsingToDate(end);
            if((work.isAfter(beginData))&&(work.isBefore(endData))){
                System.out.println(begin.toString() + " " + end.toString() + " " + counter);
                counter++;
            }
        } else if ((isValue(begin) == true) &&(isValue(end) == false)&&(!(end.length() >8))) {   //&&(end == "-")
            LocalDate beginData = parsingToDate(begin);
            if(work.isAfter(beginData)) {
                System.out.println(begin.toString() + " " + end.toString() + " " + counter);
                counter++;
            }
        }
    }

    private boolean isValue(String data) {
        if((data.charAt(0) >= '0') && (data.charAt(0) <= '9') && (data.length() == 8)) {
            return true;
        } return false;
    }

    private LocalDate parsingToDate(String s) {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
        LocalDate date = LocalDate.parse(s, format);
        return date;
    }

    private String[] spliter(String data) {
        int l = data.length();

        ArrayList<String> arrayList = new ArrayList<>();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < l; i++) {
            char ch = data.charAt(i);

            if (i == 0) {
                temp.append(ch);
            } else if (i == (l - 1)) {
                temp.append(ch);
                arrayList.add(temp.toString()); // добавляем временную строку в массив
                temp.delete(0, temp.length()); // очищаем временную строку
            } else {
                char chP = data.charAt(i + 1);
                char chM = data.charAt(i - 1);
                if (((ch == ',') && (chP == ' '))
                        || ((ch == ' ') && (chM == ' '))) {

                } else if (ch == ',') {
                    arrayList.add(temp.toString()); // добавляем временную строку в массив
                    temp.delete(0, temp.length()); // очищаем временную строку
                } else
                    temp.append(ch);
            }
        }
        return arrayList.toArray(new String[arrayList.size()]);
    }



    public int getCounterWorks() {
        return counter;
    }

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

