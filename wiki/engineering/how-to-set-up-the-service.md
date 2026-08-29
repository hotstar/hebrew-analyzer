---
title: How to set up the service
last_reviewed: 2026-08-29
tags: [readiness-placeholder, service-setup]
folder: engineering
sources:
  - repo-doc:README.md
  - code:opensearch-hebrew-analyser/build.gradle
  - code:opensearch-hebrew-analyser/settings.gradle
agent_routing:
  code_change_relevance: conditional
  task_intents: [repo-onboarding]
  applies_to_paths:
    - "**/*.gradle"
    - README.md
  applies_to_symbols: []
---

# How to set up the service

> Readiness page: generated from repo evidence for `service-setup` and still needs human review.

## Prerequisites

- Java Runtime (OpenSearch 2.11.0 compatible JDK)
- OpenSearch cluster (version 2.11.0)
- Gradle (wrapped via `gradlew`)

## Build and Install

The project uses a Gradle wrapper (`gradlew`). To build the plugin:

```bash
cd opensearch-hebrew-analyser
./gradlew build
```

This compiles the Java source and produces a plugin zip at `build/distributions/`.

## Plugin Installation

The plugin is an OpenSearch analysis plugin. Install it on an OpenSearch cluster using:

```bash
./bin/opensearch-plugin install file:///path/to/build/distributions/opensearch-analysis-hebrew-2.11.0.zip
```

## Project Structure

- `opensearch-hebrew-analyser/` — main module containing all source code
  - `build.gradle` — Gradle build configuration with OpenSearch plugin dependencies
  - `settings.gradle` — Gradle settings (root project name: `opensearch-analysis-hebrew`)
  - `src/main/java/com/hotstar/hebrew/` — Java source code
    - `analysis/` — core analysis components (tokenizers, filters, analyzers)
    - `plugin/` — OpenSearch plugin registration and provider classes
  - `gradle.properties` — version properties (OpenSearch 2.11.0, Lucene 9.7.0)
  - `es-plugin.properties` — plugin class entry point

## Configuration

The plugin registers two analyzers:
- `hebrew-ngram-3-analyzer` — N-gram based Hebrew analysis with plural reduction and stop letter filtering
- `hebrew_semi_exact_analyzer` — Semi-exact Hebrew analysis with word boundary markers

Additionally registers:
- Token filters: `hebrew_stop`, `hebrew_word` (no-op, for API compatibility)
- Tokenizers: `hebrew_tokenizer`, `hebrew_sentence` (Sefaria format tokenizer)

## Source References

- `repo-doc:README.md` — contributed basic project description.
- `code:opensearch-hebrew-analyser/build.gradle` — contributed build configuration and dependencies.
- `code:opensearch-hebrew-analyser/settings.gradle` — contributed project metadata.

## Suggested Content

- Add detailed step-by-step OpenSearch cluster setup instructions.
- Add troubleshooting for common build failures.
- Add required Java version and installation instructions.
- Add local service reset steps.
