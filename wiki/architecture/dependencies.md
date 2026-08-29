---
title: Dependencies
last_reviewed: 2026-08-29
tags: [architecture, dependencies, libraries]
folder: architecture
sources:
  - code:opensearch-hebrew-analyser/build.gradle
agent_routing:
  code_change_relevance: conditional
  task_intents: [architecture-change]
  applies_to_paths:
    - "**/*.gradle"
  applies_to_symbols: []
---

# Dependencies

## Build Dependencies

| Dependency | Version | Role |
| --- | --- | --- |
| `org.opensearch.gradle:build-tools` | 2.11.0 | OpenSearch Gradle plugin for building OpenSearch plugins |
| `org.opensearch:opensearch-core` | 2.11.0 | OpenSearch core APIs (build script classpath) |
| `org.opensearch:opensearch-common` | 2.11.0 | OpenSearch common utilities (build script classpath) |

## Runtime Dependencies

| Dependency | Version | Role |
| --- | --- | --- |
| `org.apache.lucene:lucene-core` | 9.7.0 | Core Lucene library (tokenizers, analyzers, attributes) |
| `org.apache.lucene:lucene-analysis-common` | 9.7.0 | Common Lucene analysis components (StandardTokenizer, LowerCaseFilter, ASCIIFoldingFilter, PatternReplaceFilter) |

## Compile-Only Dependencies

| Dependency | Version | Role |
| --- | --- | --- |
| `org.opensearch:opensearch` | 2.11.0 | OpenSearch plugin API interfaces and base classes |

## Test Dependencies

| Dependency | Version | Role |
| --- | --- | --- |
| `org.apache.lucene:lucene-test-framework` | 9.7.0 | Lucene test utilities |
| `junit:junit` | 4.13.2 | Unit testing framework |

## Disabled Validations

The following Gradle validations are explicitly disabled in `build.gradle`:
- Forbidden patterns
- License headers
- Dependency licenses
- Nebula POM validation
- Third-party audit
- Logger usage check
- Testing conventions
- Javadoc generation
