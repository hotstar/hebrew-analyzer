package com.hotstar.hebrew.plugin;

import com.hotstar.hebrew.analysis.SefariaTokenizer;
import org.apache.lucene.analysis.Tokenizer;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenizerFactory;


public class HebrewTokenizerTokenizerFactory extends AbstractTokenizerFactory {
    public HebrewTokenizerTokenizerFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(indexSettings, settings, name);
    }

    @Override
    public Tokenizer create() {
        return new SefariaTokenizer();
    }
}
