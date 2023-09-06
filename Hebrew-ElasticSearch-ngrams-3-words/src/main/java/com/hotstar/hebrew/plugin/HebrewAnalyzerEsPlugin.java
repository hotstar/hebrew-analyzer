package com.hotstar.hebrew.plugin;
import org.elasticsearch.index.analysis.AnalyzerProvider;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.TokenizerFactory;
import org.elasticsearch.plugins.AnalysisPlugin;
import  org.elasticsearch.plugins.Plugin;
import org.elasticsearch.indices.analysis.AnalysisModule.AnalysisProvider;
import org.apache.lucene.analysis.Analyzer;

import java.util.HashMap;
import java.util.Map;

import static java.util.Collections.singletonMap;

public class HebrewAnalyzerEsPlugin extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisProvider<TokenFilterFactory>> tokenFilters = new HashMap<>();
        tokenFilters.put("hebrew_stop", HebrewNoOpTokenFilterFactory::new);
        tokenFilters.put("hebrew_word", HebrewNoOpTokenFilterFactory::new);
        return tokenFilters;
    }

    @Override
    public Map<String, AnalysisProvider<TokenizerFactory>> getTokenizers() {
        Map<String, AnalysisProvider<TokenizerFactory>> extra = new HashMap<>();
        extra.put("hebrew_tokenizer", HebrewTokenizerTokenizerFactory::new);
        extra.put("hebrew_sentence", HebrewTokenizerTokenizerFactory::new);
        return extra;
    }

    @Override
    public Map<String, AnalysisProvider<AnalyzerProvider<? extends Analyzer>>> getAnalyzers() {
        return singletonMap("hebrew-ngram-3-analyzer", HebrewAnalyzerProvider::new);
    }
}
