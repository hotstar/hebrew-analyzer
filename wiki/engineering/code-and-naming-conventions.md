---
title: Code and naming conventions
last_reviewed: 2026-08-29
tags: [readiness-placeholder, code-and-naming-conventions]
folder: engineering
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/
agent_routing:
  code_change_relevance: conditional
  task_intents: [repo-onboarding]
  applies_to_paths:
    - "**/*.java"
  applies_to_symbols: []
---

# Code and naming conventions

> Readiness page: generated from repo evidence for `code-and-naming-conventions` and still needs human review.

## Package Structure

- `com.hotstar.hebrew.analysis/` — Core analysis components (tokenizers, filters, analyzers, attributes)
- `com.hotstar.hebrew.plugin/` — OpenSearch plugin integration and provider/factory classes

## Naming Patterns

- Analysis component classes follow `<Purpose><Type>` convention (e.g., `HebrewNgramAnalyzer`, `SefariaTokenizer`, `PluralFilter`, `StopLetterFilter`)
- Plugin provider classes follow OpenSearch conventions: `<Name>AnalyzerProvider`, `<Name>TokenFilterFactory`, `<Name>TokenizerFactory`
- Source files under `opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/`

## Source References

- `code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/` — contributed naming conventions evidence.
- `code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/plugin/` — contributed naming conventions evidence.

## Suggested Content

- Add specific code style rules (formatting, imports, documentation).
- Add review expectations.
- Add contribution guidelines.
