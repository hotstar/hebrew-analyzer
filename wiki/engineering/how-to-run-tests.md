---
title: How to run tests
last_reviewed: 2026-08-29
tags: [readiness-placeholder, test-commands]
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

# How to run tests

> Readiness page: generated from repo evidence for `test-commands` and still needs human review.

## Test Types

### Unit Tests

Unit tests use JUnit 4.13.2 and the Apache Lucene test framework.

```bash
cd opensearch-hebrew-analyser
./gradlew test
```

### Integration Tests

An integration test task is registered but currently empty:

```gradle
tasks.register('integTest', Test) {
}
```

## Test Dependencies

- `org.apache.lucene:lucene-test-framework:9.7.0`
- `junit:junit:4.13.2`

## Configuration Notes

- Security manager is disabled for tests: `tests.security.manager = false`
- JVM test args: `-XX:TieredStopAtLevel=1 -XX:ReservedCodeCacheSize=64m`
- Various Gradle validations are disabled (forbidden patterns, license headers, dependency licenses, third-party audit, testing conventions)
- Only Lucene core and analysis-common are runtime dependencies

## Source References

- `code:opensearch-hebrew-analyser/build.gradle` — contributed test configuration and dependencies.
- `code:opensearch-hebrew-analyser/gradle.properties` — contributed JVM test arguments.

## Suggested Content

- Add required test data files or fixtures.
- Add common failure modes and debugging guidance.
- Add test coverage or reporting tools.
- Populate the integration test task or document how to run integration tests.
