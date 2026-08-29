---
title: Build, Test, and Deploy
last_reviewed: 2026-08-29
tags: [engineering, build, test, deploy, gradle]
folder: engineering
sources:
  - code:opensearch-hebrew-analyser/build.gradle
  - code:opensearch-hebrew-analyser/gradle/wrapper/gradle-wrapper.properties
  - code:opensearch-hebrew-analyser/gradlew
agent_routing:
  code_change_relevance: conditional
  task_intents: [repo-onboarding]
  applies_to_paths:
    - "**/*.gradle"
    - "**/gradlew*"
  applies_to_symbols: []
---

# Build, Test, and Deploy

## Pre-requisites

- Java JDK (compatible with OpenSearch 2.11.0 / Lucene 9.7.0)
- OpenSearch cluster (for integration testing)

## Building

The project uses a Gradle wrapper:

```bash
cd opensearch-hebrew-analyser
./gradlew build
```

This produces a plugin distribution zip at `build/distributions/`.

## Testing

```bash
cd opensearch-hebrew-analyser
./gradlew test
```

Tests use JUnit 4.13.2 with the Apache Lucene test framework. The security manager is disabled for tests.

### Integration Tests

An `integTest` task is registered but currently empty. Integration tests would require an OpenSearch cluster.

## Building the Plugin Artifact

```bash
cd opensearch-hebrew-analyser
./gradlew release
```

This runs `assemble` and copies the plugin zip to `../build/plugins/opensearch-analysis-hebrew/`.

## Deploying to OpenSearch

1. Build the plugin: `./gradlew build`
2. Install on an OpenSearch node:
   ```bash
   ./bin/opensearch-plugin install file:///path/to/opensearch-analysis-hebrew-2.11.0.zip
   ```
3. Restart the OpenSearch node

## Disabled Build Validations

Several Gradle validations are disabled to avoid failures in this plugin's build environment:
- Forbidden patterns, license headers, dependency licenses, Nebula POM, third-party audit, logger usage, testing conventions, and javadoc
