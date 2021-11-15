//import java.util.ArrayList;
//import java.util.List;
//
//public class v {
//
//    public List<WebElement> getSomeElements(String path) {
//        if (path == null)
//        {
//            throw new IllegalArgumentException("getElements: illegal path (NULL)");  // исключение должно создаваться с помощью операции throw new
//            //  path = "//*[@id='Hello']";			//при передаче NULL - данная строка не выполняется, как и весь код ниже
//        }
//
//        WebDriverHelper wd = new WebDriverHelper();// скорее всего в строке создается объект класса наследника от интерфейс WebDriver, для поиска элементов на странице
//        wd.get(path); // передача драйверу адреса страницы
//
//       // if (!wd.isElementsPresent(path))           //проверяем, существуют ли элементы по пути path, но данного метода в интерфейсе WebDriver нет.
//
//        List<WebElement> result = wd.findElements(path); // массив result создан для элементов типа String. Надо что бы result был массив из WebElement.
//        // Не работала с WebDriver, пока до конца не поняла как именно создать список - что писать в скобках findElements()
//        // сразу в лист сохраняем
//        // метод add добавления элемента не сработает.
//        //getElements- нет такого метода, использовано findElements(), он возвращает List<WebElement>
//
//        if (result.isEmpty()) {                         //если ничего не получили по path
//            System.out.println("There aren't any elements by this path");//если элементов нет - выводим информацию, что их нет и выбрасываем ошибку
//            throw new IllegalArgumentException("getElements: no elements "); // выбрасывается ошибка, что не передано ничего в ArrayList
//        }
//
//        for (WebElement element : result) { //чтение списка строк
//            String s = element.getText();
//            if (s.equals("remove")) {//проверяем равен ли по значению элемент массива "remove". Не понимаю зачем это условие if: зачем искать, удалать и возвращать первый элемент!
//                // реализация == не работает, заменяем на equals()
//                result.remove(element);               //удаление искомого элемента списка.
//                // result.get(0) - возвращено не будет, это WebElement, мы должны вернуть List<WebElement>
//            }
//        }
//        return result;                        //возвращаем список элементов, полученных по getElements(path).
//
//    }
//
//
//
//
//}
