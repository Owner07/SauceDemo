package utils;

import org.testng.IRetryAnalyzer ;
import org.testng.ITestResult ;
public class Retry implements IRetryAnalyzer {
    private int count = 0 ;
    private static int maxTry = 3 ;
    @Override
    public boolean retry ( ITestResult iTestResult ) {
        if ( !iTestResult. isSuccess ()) { //Проверка, не завершился ли тест успешно
            if ( count < maxTry ) { //Проверяем, достигнуто ли максимальное количество попыток
                count++;                                      //Увеличьте значение maxTry на 1
                iTestResult. setStatus ( ITestResult. FAILURE ) ;   //Отметить тест как неудавшийся
                return true ;                                  // Сообщает TestNG о необходимости повторного запуска теста
            } else  {
                iTestResult.setStatus ( ITestResult.FAILURE ) ;   // Если достигнуто значение maxCount, тест помечается как неудачный
            }
        } else  {
            iTestResult.setStatus ( ITestResult.SUCCESS ) ; //       Если тест пройден успешно, TestNG помечает его как пройденный
        }
        return false;
    }
}