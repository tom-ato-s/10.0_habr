import java.io.*;
import java.net.URL;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

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

                  //  System.out.println(value[10]);


                    if (((value[10].charAt(0) >= '0') && (value[10].charAt(0) <= '9'))
                            && ((value[12].charAt(0) >= '0') && (value[12].charAt(0) <= '9'))) {
                        System.out.println(value[10] +" " + value[12]);
//                    if (dataInPeriod(value[10], value[11])) { //проверяем входит ли дата в период работ
//                        counter++;
                    }
//                    } else System.out.println("массив значений не содержит даты " + value[10] + " " + value[11]);
                }
                inputstrim.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
        //arrayList.remove(0);
        return arrayList.toArray(new String[arrayList.size()]);
    }


    public boolean dataInPeriod(String dataBegin, String dataEnd) throws ParseException {

            DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyyMMdd");
            LocalDate begin = LocalDate.parse(dataBegin, format);
            LocalDate end = LocalDate.parse(dataEnd, format);
            LocalDate work = LocalDate.parse(DATA_WORK, format);

            if (work.isBefore(begin) || (work.isAfter(end))) {
                return true;
            }
        return false;

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

