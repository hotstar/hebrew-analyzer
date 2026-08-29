---
title: Hebrew Analyzer - Repository Overview
last_reviewed: 2026-08-29
tags: [overview, hebrew, analysis, opensearch, plugin]
folder: overview
sources:
  - code:opensearch-hebrew-analyser/build.gradle
  - code:opensearch-hebrew-analyser/settings.gradle
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/HebrewAnalyzerOsPlugin.java
agent_routing:
  code_change_relevance: required
  task_intents: [repo-onboarding]
  applies_to_paths:
    - "**/*.java"
    - "**/*.gradle"
  applies_to_symbols: []
---

# Hebrew Analyzer - Repository Overview

This repository provides a **Hebrew language analysis plugin** for OpenSearch (and Elasticsearch compatible search engines). It is written in Java using Apache Lucene's analysis framework.

## Purpose

The plugin adds Hebrew-specific text analysis capabilities to OpenSearch, enabling proper indexing and searching of Hebrew text with support for:

- N-gram based analysis for fuzzy/substring matching
- Semi-exact analysis for word-boundary matching
- Hebrew plural reduction (`ים`, `ות` suffixes)
- Stop letter removal (`ו`, `י` prefixes)
- Niqqud (Hebrew vowel diacritics) stripping
- Sefaria format tokenization (plus-delimited tokens)

## Project Structure

```
opensearch-hebrew-analyser/     -- Main Gradle module
  build.gradle                  -- Build configuration (OpenSearch 2.11.0, Lucene 9.7.0)
  settings.gradle               -- Root project name: opensearch-analysis-hebrew
  gradle.properties             -- Version and JVM settings
  es-plugin.properties           -- Plugin entry point class
  src/main/java/com/hotstar/
    hebrew/analysis/            -- Core analysis components
    hebrew/plugin/              -- OpenSearch plugin integration
```

## Key Technologies

- **Java** — Primary language
- **Apache Lucene 9.7.0** — Text analysis framework (lucene-core, lucene-analysis-common)
- **OpenSearch 2.11.0** — Target search engine
- **Gradle** — Build system with OpenSearch gradle build-tools plugin
- **JUnit 4.13.2** — Test framework

## Analyzers

The plugin registers two custom analyzers:

1. **hebrew-ngram-3-analyzer** — Generates 3-character n-grams with plural reduction, stop letter filtering, and niqqud stripping
2. **hebrew_semi_exact_analyzer** — Produces exact word tokens with `$` suffix markers, niqqud stripping, and ASCII folding

Both analyzers are available as OpenSearch index analyzer settings.
