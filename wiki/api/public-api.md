---
title: Public API — Analyzers and Plugin Components
last_reviewed: 2026-08-29
tags: [api, analyzers, opensearch, plugin]
folder: api
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/HebrewAnalyzerOsPlugin.java
  - code:opensearch-hebrew-analyser/es-plugin.properties
agent_routing:
  code_change_relevance: conditional
  task_intents: [api-contract-change]
  applies_to_paths:
    - src/main/java/com/hotstar/hebrew/plugin/**/*
  applies_to_symbols: [HebrewAnalyzerOsPlugin]
---

# Public API — Analyzers and Plugin Components

## OpenSearch Plugin Registration

The plugin is registered via `es-plugin.properties`:

```
plugin=com.hotstar.hebrew.plugin.HebrewAnalyzerOsPlugin
```

## Registered Analyzers

These analyzers are available in OpenSearch index settings under the `analysis` section:

### `hebrew-ngram-3-analyzer`

N-gram based Hebrew analysis. Produces tokens of 3 characters with plural reduction and stop letter filtering.

**Usage in index settings:**
```json
{
  "settings": {
    "index": {
      "analysis": {
        "analyzer": {
          "my_hebrew_analyzer": {
            "type": "hebrew-ngram-3-analyzer"
          }
        }
      }
    }
  }
}
```

### `hebrew_semi_exact_analyzer`

Semi-exact Hebrew analysis. Produces exact word tokens with `$` suffix markers.

**Usage in index settings:**
```json
{
  "settings": {
    "index": {
      "analysis": {
        "analyzer": {
          "my_hebrew_analyzer": {
            "type": "hebrew_semi_exact_analyzer"
          }
        }
      }
    }
  }
}
```

## Registered Tokenizers

### `hebrew_tokenizer` / `hebrew_sentence`

Tokenizes input by splitting on `+` characters (Sefaria format). Both tokenizer names use the same `SefariaTokenizer` implementation.

## Registered Token Filters

### `hebrew_stop` / `hebrew_word`

No-op token filters (pass tokens through unchanged). Registered for API compatibility with future custom filter implementations.

## Analyzer Token Output Examples

| Text | Analyzer | Tokens |
| --- | --- | --- |
| `הכוח האמונה יכול להזזים הרים` | ngram-3-words | `הכח$,הכח,האמונה$,האמ,אמנ,מנה,יכול$,כל,להזזים$,להז,הזז,הרים$,הרם` |
| `הכוח האמונה יכול להזזים הרים` | semi-exact | `הכח$,הכח,האמונה$,האמונה,יכול$,יכול,להזזים$,להזזים,הרים$,הרים` |
