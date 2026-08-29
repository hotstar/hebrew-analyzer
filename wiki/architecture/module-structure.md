---
title: Module Structure
last_reviewed: 2026-08-29
tags: [architecture, modules, packages]
folder: architecture
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/
  - code:opensearch-hebrew-analyser/build.gradle
agent_routing:
  code_change_relevance: conditional
  task_intents: [architecture-change, repo-onboarding]
  applies_to_paths:
    - "**/*.java"
  applies_to_symbols: []
---

# Module Structure

## Package Organization

The source code is organized under `com.hotstar.hebrew` with two main packages:

### `com.hotstar.hebrew.analysis` — Core Analysis Components

| Class | Type | Responsibility |
| --- | --- | --- |
| `HebrewNgramAnalyzer` | Analyzer | N-gram based Hebrew text analysis pipeline |
| `HebrewSemiExactAnalyzer` | Analyzer | Semi-exact Hebrew text analysis pipeline |
| `SefariaTokenizer` | Tokenizer | Splits input on `+` characters (Sefaria format) |
| `SefariaNGramTokenFilter` | TokenFilter | Generates 3-character n-grams from non-exact tokens |
| `SefariaSemiExactFilter` | TokenFilter | Outputs words with `$` boundary markers |
| `PluralFilter` | TokenFilter | Strips Hebrew plural suffixes (`ים`, `ות`) |
| `StopLetterFilter` | TokenFilter | Removes specified stop letters from tokens |
| `NGramizer` | Utility | Character n-gram generator |
| `HebrewTokenTypeAttribute` | Attribute | Interface for token type metadata |
| `HebrewTokenTypeAttributeImpl` | Attribute | Implementation of token type attribute |

### `com.hotstar.hebrew.plugin` — OpenSearch Integration

| Class | Type | Responsibility |
| --- | --- | --- |
| `HebrewAnalyzerOsPlugin` | Plugin | Main plugin entry point; registers analyzers, tokenizers, and token filters |
| `HebrewNgramAnalyzerProvider` | Provider | Wires `HebrewNgramAnalyzer` into OpenSearch |
| `HebrewSemiExactAnalyzerProvider` | Provider | Wires `HebrewSemiExactAnalyzer` into OpenSearch |
| `HebrewTokenizerTokenizerFactory` | Factory | Creates `SefariaTokenizer` instances |
| `HebrewNoOpTokenFilterFactory` | Factory | No-op token filter for API compatibility |
