---
title: Configuration
last_reviewed: 2026-08-29
tags: [engineering, configuration, gradle, settings]
folder: engineering
sources:
  - code:opensearch-hebrew-analyser/gradle.properties
  - code:opensearch-hebrew-analyser/es-plugin.properties
  - code:opensearch-hebrew-analyser/build.gradle
agent_routing:
  code_change_relevance: conditional
  task_intents: [repo-onboarding]
  applies_to_paths:
    - "**/*.properties"
    - "**/*.gradle"
  applies_to_symbols: []
---

# Configuration

## Gradle Properties (`gradle.properties`)

| Property | Value | Description |
| --- | --- | --- |
| `opensearchVersion` | 2.11.0 | Target OpenSearch version |
| `luceneVersion` | 9.7.0 | Target Apache Lucene version |
| `pluginName` | opensearch-analysis-hebrew | Plugin artifact name |
| `org.gradle.warning.mode` | none | Gradle warning mode suppressed |
| `org.gradle.parallel` | true | Enable parallel Gradle execution |
| `org.gradle.jvmargs` | -Xmx3g -XX:+HeapDumpOnOutOfMemoryError -Xss2m | JVM arguments for Gradle |
| `options.forkOptions.memoryMaximumSize` | 2g | Max memory for forked processes |

### System Properties

| Property | Value | Description |
| --- | --- | --- |
| `org.gradle.dependency.duplicate.project.detection` | false | Disable duplicate project name detection |
| `org.gradle.warning.mode` | fail | Fail build on deprecated Gradle API usage |
| `jdk.tls.client.protocols` | TLSv1.2 | Force TLS 1.2 (for Vault compatibility) |
| `tests.jvm.argline` | -XX:TieredStopAtLevel=1 -XX:ReservedCodeCacheSize=64m | Faster test execution JVM args |

## Plugin Properties (`es-plugin.properties`)

| Property | Value |
| --- | --- |
| `plugin` | `com.hotstar.hebrew.plugin.HebrewAnalyzerOsPlugin` |

## Build Configuration (`build.gradle`)

- Plugin name: `opensearch-analysis-hebrew`
- Plugin class: `com.hotstar.hebrew.plugin.HebrewAnalyzerEsPlugin`
- The `test` block disables the security manager: `tests.security.manager = false`
- A `release` task copies the built plugin zip to `../build/plugins/opensearch-analysis-hebrew/`
- An empty `integTest` task is registered for future use
