---
title: Domain Concepts — Hebrew Linguistic Analysis
last_reviewed: 2026-08-29
tags: [domains, hebrew, linguistics, analysis]
folder: domains
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/
  - repo-doc:README.md
agent_routing:
  code_change_relevance: conditional
  task_intents: [domain-behavior-change]
  applies_to_paths:
    - src/main/java/com/hotstar/hebrew/analysis/**/*
  applies_to_symbols: []
---

# Domain Concepts — Hebrew Linguistic Analysis

## Key Concepts

### Niqqud (Vowel Diacritics)

Hebrew text often includes niqqud (dotting/vowel marks) around consonants. These are Unicode characters in the range U+0591-U+05C7 that must be removed before analysis because:
- Search queries rarely include niqqud
- Different niqqud on the same consonant root do not change the semantic meaning for search purposes
- The `PatternReplaceFilter` removes all niqqud characters early in both analysis pipelines

### Hebrew Plural Suffixes

Hebrew has two primary plural suffixes:
- `ים` (-im) — masculine plural
- `ות` (-ot) — feminine plural

The `PluralFilter` strips these suffixes from words 3+ characters long, adding the singular form as an additional token. The original plural form is preserved as an exact match.

### Stop Letters (Vetitive Prefixes)

Hebrew uses prefix letters that can attach to words (like the definite article `ה` (ha-), conjunction `ו` (ve-), and other prepositions). The `StopLetterFilter` removes configured leading stop letters (`ו` and `י` by default) from non-exact tokens to improve search recall.

### N-gram Analysis

Character n-grams of length 3 are generated from all non-exact tokens. This enables:
- Substring matching (e.g., searching for part of a word)
- Spelling tolerance
- Root-based matching across related word forms

### Semi-Exact Analysis

Each word appears as both the original form and with a `$` suffix marker. This enables:
- Exact matches against indexed `$`-suffixed tokens
- Prefix/suffix-tolerant matches against the base word
- Compatibility with indexing analyzers like HebMorph

### Sefaria Format

A format where tokens are delimited by `+` characters (from the Sefaria Jewish text library). The `SefariaTokenizer` splits input on `+` to extract individual tokens.
