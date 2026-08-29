---
title: Customer context
last_reviewed: 2026-08-29
tags: [readiness-placeholder, customer-context, agent-context]
folder: domains
sources:
  - repo-doc:README.md
agent_routing:
  code_change_relevance: conditional
  task_intents: [customer-context-change, domain-behavior-change]
  applies_to_paths: []
  applies_to_symbols: []
---

# Customer context

> Readiness page: generated as a human-owned customer-context placeholder and still needs human review.

## Agent-critical customer context

<!-- Add short customer-impact facts agents must know before making or reviewing changes. -->

## Customer journeys

This OpenSearch plugin provides Hebrew language analysis capabilities for search. Customers use it to index and search Hebrew text with proper linguistic handling (plurals, stop letters, n-gram generation, etc.).

## Callers and entry points

- OpenSearch clusters with Hebrew content indices
- Search applications that need Hebrew language support
- The plugin is loaded by OpenSearch at startup when installed

## Customer segments and variants

<!-- Add market, plan, tenant, cohort, device, platform, locale, entitlement, or experiment variants that change behavior. -->

## Customer-visible contracts

Two analyzers are exposed via OpenSearch index settings:
- `hebrew-ngram-3-analyzer` — generates 3-character n-grams with plural reduction and stop letter filtering
- `hebrew_semi_exact_analyzer` — produces exact word tokens with `$` suffix markers

## Business rules and edge cases

<!-- Add rules decided outside code, exception handling, special cases. -->

## Customer impact of change

<!-- Add how failures, latency, data changes, or behavior changes show up for customers. -->

## Source References

- `repo-doc:README.md` — contributed tokenizer examples and basic project description.

## Suggested Content

- Fill all TBD sections with product-owner or customer-owner reviewed facts.
- Document which teams or services depend on this plugin.
- Document expected search quality and behavior differences from standard analyzers.
