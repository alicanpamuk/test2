import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;



public class TestLoggerClass implements TestWatcher {

    LogClass logClass = new LogClass();

    @Override
    public void testSuccessful(ExtensionContext context) {
        String testName = context.getDisplayName();
        logClass.info(testName + " testi başarılı");
    }


    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {
        String testName = context.getDisplayName();
        String testFailCause = cause.getMessage();
        logClass.error(testName + " testi hata verdi.Hata sebebi : " +testFailCause);
    }

}
