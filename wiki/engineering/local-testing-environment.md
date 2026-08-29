---
title: How to set up an environment for local testing
last_reviewed: 2026-08-29
tags: [readiness-placeholder, local-testing-environment]
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

# How to set up an environment for local testing

> Readiness page: generated from repo evidence for `local-testing-environment` and still needs human review.

## Prerequisites

- Java JDK (compatible with OpenSearch 2.11.0 / Lucene 9.7.0)
- Gradle wrapper (bundled as `gradlew`)

## Test Configuration

The build configuration in `build.gradle` defines:

- Test framework: JUnit 4.13.2 with Apache Lucene test framework
- Security manager disabled for tests: `tests.security.manager = false`
- JVM arguments for faster test execution (from `gradle.properties`):
  ```
  -XX:TieredStopAtLevel=1 -XX:ReservedCodeCacheSize=64m
  ```

## Running Tests

```bash
cd opensearch-hebrew-analyser
./gradlew test
```

## Source References

- `code:opensearch-hebrew-analyser/build.gradle` — contributed test dependencies and configuration.
- `code:opensearch-hebrew-analyser/gradle.properties` — contributed JVM test arguments.

## Suggested Content

- Add required Java version details.
- Add test data or fixture setup instructions.
- Add mock service configuration if any external dependencies are needed.
- Add common test failure modes and debugging guidance.
- Add verification steps before tests run.
