package analizer;

public class Application {
    public static void main(String[] args) {
        String[] spamKeywords = {"dollar", "buy", "sell", "price"};
        int maxLengthComment = 30;

        TextAnalyzer[] textAnalyzers1 = {
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer(),
                new TooLongTextAnalyzer(maxLengthComment)
        };
        TextAnalyzer[] textAnalyzers2 = {
                new SpamAnalyzer(spamKeywords),
                new TooLongTextAnalyzer(maxLengthComment),
                new NegativeTextAnalyzer()
        };
        TextAnalyzer[] textAnalyzers3 = {
                new TooLongTextAnalyzer(maxLengthComment),
                new SpamAnalyzer(spamKeywords),
                new NegativeTextAnalyzer()
        };

        String[] tests = new String[8];
        tests[0] = "Hi, everyone!!!";
        tests[1] = "Very-very long text toooooooo tessssssssttttttttttsssssss";
        tests[2] = "This comment contains negative text :(";
        tests[3] = "Bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla-bla";
        tests[4] = "This comment contains negative text too :|";
        tests[5] = "... and this comment contains negative text too =(";
        tests[6] = "Bitcoin costs $9000. Would you like to buy him!!!";
        tests[7] = "You win 10000 dollars!!!";

        TextAnalyzer[][] textAnalyzers = {textAnalyzers1, textAnalyzers2, textAnalyzers3};
        Application application = new Application();

        for (int i = 0; i < tests.length; i++) {
            int itemAnalyzer = 1;
            System.out.print("Test #" + (i + 1) + ": ");
            System.out.println(tests[i]);

            for (TextAnalyzer[] analyzers : textAnalyzers) {
                System.out.print(itemAnalyzer + ": ");
                System.out.println(application.checkLabels(analyzers, tests[i]));
                ++itemAnalyzer;
            }
        }
    }

    public Label checkLabels(TextAnalyzer[] analyzers, String text) {
        for (TextAnalyzer textAnalyzer : analyzers) {
            if (textAnalyzer.processText(text) != Label.OK) {
                return textAnalyzer.processText(text);
            }
        }
        return Label.OK;
    }
}
