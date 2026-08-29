---
title: Data Flow — Text Analysis Pipeline
last_reviewed: 2026-08-29
tags: [data, flow, analysis, pipeline, tokenization]
folder: data
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/HebrewNgramAnalyzer.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/HebrewSemiExactAnalyzer.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/SefariaTokenizer.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/NGramizer.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/SefariaNGramTokenFilter.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/SefariaSemiExactFilter.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/PluralFilter.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/StopLetterFilter.java
agent_routing:
  code_change_relevance: conditional
  task_intents: [architecture-change]
  applies_to_paths:
    - src/main/java/com/hotstar/hebrew/analysis/**/*
  applies_to_symbols: []
---

# Data Flow — Text Analysis Pipeline

## Overview

Text flows through a sequential pipeline of Lucene token stream components. The pipeline is configured per-analyzer in each `createComponents()` method.

## N-gram Analysis Flow

```
                    HebrewNgramAnalyzer
                    ===================

Input String
    |
    v
StandardTokenizer
  - Splits on whitespace/punctuation into tokens
    |
    v
PatternReplaceFilter (niqqud removal)
  - Strips Hebrew diacritics: [֑-ׇֽֿׁׂׅׄ]
  - Replaces with empty string
    |
    v
ASCIIFoldingFilter
  - Normalizes Latin characters (e.g., e -> e, c -> c)
    |
    v
LowerCaseFilter
  - Converts all characters to lowercase
    |
    v
PluralFilter
  - Detects plural suffixes (ים, ות) on words >= 3 chars
  - Outputs: original word with $ suffix (exact, position=1)
  - Emits: singular form (non-exact, position=0)
  - Marks original token as exact, singular as non-exact
    |
    v
StopLetterFilter
  - On non-exact tokens only (isExact == false)
  - Removes leading stop letters configured as [וי]
  - Leaves exact tokens unchanged
    |
    v
SefariaNGramTokenFilter (n=3)
  - For non-exact tokens: generates 3-char n-grams
  - For exact tokens: outputs the token with $ suffix
  - N-grams emitted with position increment 0
  - Uses HebrewTokenTypeAttribute.isExact() to decide
```

## Semi-Exact Analysis Flow

```
                    HebrewSemiExactAnalyzer
                    =======================

Input String
    |
    v
StandardTokenizer
  - Splits on whitespace/punctuation
    |
    v
PatternReplaceFilter (niqqud removal)
  - Same pattern as ngram analyzer
    |
    v
ASCIIFoldingFilter
  - Same as ngram analyzer
    |
    v
LowerCaseFilter
  - Same as ngram analyzer
    |
    v
SefariaSemiExactFilter
  - For each input token:
    - Outputs the original token (position=1)
    - Then outputs the token with $ suffix appended (position=0)
    - This allows matching with both exact terms and prefixed/suffixed variants
```

## Token State Tracking

The `HebrewTokenTypeAttribute` tracks whether a token is "exact" (original text) or transformed:

- **Exact (isExact=true)**: Original word from input or plural form, marked with `$`
- **Non-exact (isExact=false)**: Derived forms (n-grams, singular plurals, unfolded text)

This distinction allows downstream filters and search queries to differentiate between precise and fuzzy matches.
