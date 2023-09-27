package utils.testBase;

public class TestCaseFailed extends Exception{
    private static final long serialVersionUID = 1L;

    private String message = null;

    public TestCaseFailed() {
        super();
    }

    public TestCaseFailed(String message) {
        super(message);
        this.message = message;
    }
}
