---
title: Architecture Overview
last_reviewed: 2026-08-29
tags: [architecture, analysis, pipeline]
folder: architecture
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/HebrewNgramAnalyzer.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/HebrewSemiExactAnalyzer.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/HebrewAnalyzerOsPlugin.java
agent_routing:
  code_change_relevance: conditional
  task_intents: [architecture-change]
  applies_to_paths:
    - src/main/java/com/hotstar/hebrew/**/*
  applies_to_symbols: []
---

# Architecture Overview

## Analysis Pipelines

Each analyzer defines a chain of token processing components (Lucene `TokenStreamComponents`):

### N-gram Analyzer Pipeline

```
Input Text
  -> StandardTokenizer (splits on whitespace/punctuation)
  -> PatternReplaceFilter (strips Hebrew niqqud: U+0591-U+05BD, U+05BF, U+05C1-U+05C2, U+05C4-U+05C5, U+05C7)
  -> ASCIIFoldingFilter (normalizes Latin characters)
  -> LowerCaseFilter (converts to lowercase)
  -> PluralFilter (strips plural suffixes, adds singular form as alternate token)
  -> StopLetterFilter (removes leading stop letters: ו, י)
  -> SefariaNGramTokenFilter (generates 3-character n-grams, marks exact tokens with $)
```

### Semi-Exact Analyzer Pipeline

```
Input Text
  -> StandardTokenizer (splits on whitespace/punctuation)
  -> PatternReplaceFilter (strips Hebrew niqqud)
  -> ASCIIFoldingFilter (normalizes Latin characters)
  -> LowerCaseFilter (converts to lowercase)
  -> SefariaSemiExactFilter (outputs each word and a copy with $ suffix)
```

## Plugin Registration

The `HebrewAnalyzerOsPlugin` registers the following components with OpenSearch:

- **Analyzers**: `hebrew-ngram-3-analyzer`, `hebrew_semi_exact_analyzer`
- **Tokenizers**: `hebrew_tokenizer`, `hebrew_sentence`
- **Token Filters**: `hebrew_stop`, `hebrew_word`

The tokenizers and token filters are configured for API compatibility (the tokenizers use `SefariaTokenizer` and the token filters are no-ops).
