package analizer;

class TooLongTextAnalyzer implements TextAnalyzer {
    private int maxLength;

    public TooLongTextAnalyzer(int maxLength) {
        if (maxLength > 0) {
            this.maxLength = maxLength;
        }else {
            System.out.println("The length of the text must be > 0");
        }
    }

    @Override
    public Label processText(String text) {
        if (text.length() > maxLength) {
            return Label.TOO_LONG;
        }
        return Label.OK;
    }
}
