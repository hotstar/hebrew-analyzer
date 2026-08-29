---
title: Data Models
last_reviewed: 2026-08-29
tags: [data, models, attributes, token]
folder: data
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/HebrewTokenTypeAttribute.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/HebrewTokenTypeAttributeImpl.java
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/NGramizer.java
agent_routing:
  code_change_relevance: conditional
  task_intents: [api-contract-change]
  applies_to_paths:
    - src/main/java/com/hotstar/hebrew/analysis/*.java
  applies_to_symbols: [HebrewTokenTypeAttribute, NGramizer]
---

# Data Models

## HebrewTokenTypeAttribute

A Lucene `Attribute` interface that tracks per-token metadata during analysis:

```java
public interface HebrewTokenTypeAttribute extends Attribute {
    enum HebrewType { Unknown }
    void setType(HebrewType type);
    HebrewType getType();
    boolean isExact();
    void setExact(boolean isExact);
}
```

**Fields:**
- `type` — Token type (currently only `Unknown`)
- `isExact` — Whether the token is an exact (original) token or a derived/transformed token

The `isExact` flag is used by filters to differentiate between:
- **Exact tokens**: Original word forms (marked with `$` suffix, position increment 1)
- **Non-exact tokens**: Derived forms like n-grams, singularized plurals (position increment 0)

## NGramizer

A utility class that generates character n-grams:

```java
public class NGramizer {
    public NGramizer(int n);
    public List<String> ngramize(String s);
}
```

Produces all contiguous substrings of length `n` from a given string. Used by `SefariaNGramTokenFilter` to generate 3-character n-grams.

## Token Markers

- `$` (FINAL_CHAR) — Appended to exact/unaltered tokens as a boundary marker
  - Used in `SefariaNGramTokenFilter` (exact tokens get `$`)
  - Used in `SefariaSemiExactFilter` (every output token gets `$`)
  - Used in `PluralFilter` (original plural form gets `$` as exact marker)
