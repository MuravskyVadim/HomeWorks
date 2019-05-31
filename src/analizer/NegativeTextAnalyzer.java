package analizer;

class NegativeTextAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords = {":(", "=(", ":|"};
    private Label label = Label.NEGATIVE_TEXT;

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }
}
