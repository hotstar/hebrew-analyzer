---
title: How to generate hermetic server/build
last_reviewed: 2026-08-29
tags: [readiness-placeholder, hermetic-build]
folder: engineering
sources:
  - code:opensearch-hebrew-analyser/build.gradle
  - code:opensearch-hebrew-analyser/gradle.properties
agent_routing:
  code_change_relevance: conditional
  task_intents: [repo-onboarding]
  applies_to_paths:
    - "**/*.gradle"
  applies_to_symbols: []
---

# How to generate hermetic server/build

> Readiness page: generated from repo evidence for `hermetic-build` and still needs human review.

## Build Artifact

The project produces an OpenSearch analysis plugin zip file.

## Build Command

```bash
cd opensearch-hebrew-analyser
./gradlew build
```

This compiles all Java sources and bundles the plugin.

## Release Build

A custom `release` task copies the built plugin zip to a `build/plugins/` directory:

```bash
./gradlew release
```

This task depends on `assemble` and copies the bundle plugin output to `../build/plugins/opensearch-analysis-hebrew/`.

## Build Configuration

- OpenSearch version: 2.11.0
- Lucene version: 9.7.0
- Gradle wrapper included (`gradlew`/`gradlew.bat`)
- Various validations disabled (forbidden patterns, license headers, dependency licenses, third-party audit, testing conventions)
- Parallel Gradle execution enabled
- JVM args: `-Xmx3g -XX:+HeapDumpOnOutOfMemoryError -Xss2m`

## Source References

- `code:opensearch-hebrew-analyser/build.gradle` — contributed build configuration and release task.
- `code:opensearch-hebrew-analyser/gradle.properties` — contributed version properties.

## Suggested Content

- Add Java version requirements.
- Document how to verify the built plugin zip.
- Add instructions for plugin signing or checksum verification.
- Document deployment to OpenSearch clusters.
