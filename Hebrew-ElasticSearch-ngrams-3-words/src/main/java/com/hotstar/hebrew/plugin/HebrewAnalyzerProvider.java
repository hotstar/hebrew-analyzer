package com.hotstar.hebrew.plugin;


import org.elasticsearch.common.settings.Settings;
import  org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import  org.elasticsearch.index.analysis.AbstractIndexAnalyzerProvider;
import com.hotstar.hebrew.analysis.HebrewAnalyzer;


public class HebrewAnalyzerProvider extends AbstractIndexAnalyzerProvider<HebrewAnalyzer> {

    /* Constructor. Nothing special here. */
    public HebrewAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
        super(name, settings);
        analyzer = new HebrewAnalyzer();
    }

    /* This function needs to be overridden to return an instance of PlusSignAnalyzer. */
    public HebrewAnalyzer get() {
        return this.analyzer;
    }

    /* Instance of PlusSignAnalyzer class that is returned by this class. */
    protected HebrewAnalyzer analyzer;

    /* Name to associate with this class. We will use this in PlusSignBinderProcessor. */
    public static final String NAME = "hebrew-ngram-3-analyzer";
}
