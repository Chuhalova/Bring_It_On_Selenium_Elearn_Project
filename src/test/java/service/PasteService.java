package service;

import model.Paste;

public class PasteService {
    public static final String CODE_TEXT = "testdata.paste.code";

    public static final String TITLE = "testdata.paste.title";

    public static final int EXP_TIME = 10;

    public Paste createPasteWithExpiration10Min() {
        return new Paste(TestDataReader.getTestData(CODE_TEXT),
                         TestDataReader.getTestData(TITLE),
                         EXP_TIME);
    }
}
