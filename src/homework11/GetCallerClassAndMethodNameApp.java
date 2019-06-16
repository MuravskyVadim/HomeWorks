package homework11;

public class GetCallerClassAndMethodNameApp {
    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        m1();
    }

    static void m1() {
        System.out.println(getCallerClassAndMethodName());
        m2();
    }

    static void m2() {
        System.out.println(getCallerClassAndMethodName());
        m3();
    }

    static void m3() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        StackTraceElement[] stackTraceElement = Thread.currentThread().getStackTrace();
        if (stackTraceElement.length < 4) {
            return null;
        }
        return stackTraceElement[3].getClassName() + "#" + stackTraceElement[3].getMethodName();
    }
}
