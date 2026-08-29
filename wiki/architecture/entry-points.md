---
title: Entry Points
last_reviewed: 2026-08-29
tags: [architecture, entry-points, plugin, analyzers]
folder: architecture
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/HebrewAnalyzerOsPlugin.java
  - code:opensearch-hebrew-analyser/es-plugin.properties
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/
agent_routing:
  code_change_relevance: conditional
  task_intents: [architecture-change]
  applies_to_paths:
    - src/main/java/com/hotstar/hebrew/plugin/**/*
  applies_to_symbols: [HebrewAnalyzerOsPlugin]
---

# Entry Points

## Plugin Entry Point

The main entry point is `com.hotstar.hebrew.plugin.HebrewAnalyzerOsPlugin`, which extends `Plugin` and implements `AnalysisPlugin`. OpenDiscovey loads this class from `es-plugin.properties` on startup.

The plugin registers three types of analysis components:

### Analyzers (for use in index settings)

| Name | Provider Class | Underlying Analyzer |
| --- | --- | --- |
| `hebrew-ngram-3-analyzer` | `HebrewNgramAnalyzerProvider` | `HebrewNgramAnalyzer` |
| `hebrew_semi_exact_analyzer` | `HebrewSemiExactAnalyzerProvider` | `HebrewSemiExactAnalyzer` |

### Tokenizers (for custom analyzer chains)

| Name | Factory Class | Underlying Tokenizer |
| --- | --- | --- |
| `hebrew_tokenizer` | `HebrewTokenizerTokenizerFactory` | `SefariaTokenizer` |
| `hebrew_sentence` | `HebrewTokenizerTokenizerFactory` | `SefariaTokenizer` |

Both tokenizer names use the same `SefariaTokenizer` implementation.

### Token Filters (for custom analyzer chains)

| Name | Factory Class | Behavior |
| --- | --- | --- |
| `hebrew_stop` | `HebrewNoOpTokenFilterFactory` | No-op (pass-through) |
| `hebrew_word` | `HebrewNoOpTokenFilterFactory` | No-op (pass-through) |

Both token filters are registered as no-ops for API compatibility, allowing future implementation of custom Hebrew token filtering logic.

## Consumer Entry Points

Users interact with this plugin through:

1. **Index settings configuration** — Setting an analyzer type in index mapping
2. **OpenSearch Plugin API** — The plugin JAR is loaded by OpenSearch at node startup
3. **Build system** — `gradlew build` and `gradlew release` tasks produce the plugin artifact
