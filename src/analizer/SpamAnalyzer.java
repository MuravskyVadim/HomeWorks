package analizer;

class SpamAnalyzer extends KeywordAnalyzer implements TextAnalyzer {
    private String[] keywords;
    private Label label = Label.SPAM;

    public SpamAnalyzer(String[] keywords) {
        this.keywords = keywords.clone();
    }

    @Override
    protected String[] getKeywords() {
        return keywords;
    }

    @Override
    protected Label getLabel() {
        return label;
    }
}
