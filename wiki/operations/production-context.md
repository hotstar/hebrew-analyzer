---
title: Production context
last_reviewed: 2026-08-29
tags: [readiness-placeholder, production-context, agent-context]
folder: operations
sources: []
agent_routing:
  code_change_relevance: conditional
  task_intents: [production-impact-change, operations-change]
  applies_to_paths: []
  applies_to_symbols: []
---

# Production context

> Readiness page: generated as a human-owned production-context placeholder and still needs human review.

## Agent-critical constraints

<!-- Add short constraints agents must honor before making or reviewing changes. -->

## Production service identity

<!-- Add deployable service name, prod aliases, owning team, pager/oncall. -->

## Hot paths and performance budgets

<!-- Add latency targets, p50/p95/p99, QPS, timeout budgets, payload limits. -->

## Runtime change guardrails

<!-- Add production constraints that directly change implementation, rollout, validation, or review choices. -->

## Production validation pointers

<!-- Add dashboard, metric, alert, trace, or log pointers. -->

## Known risky change patterns

<!-- Add concise patterns that commonly cause production regressions. -->

## Source References

<!-- Add source docs, runbooks, dashboards, incident reviews. -->

## Suggested Content

- Fill all TBD sections with production-owner reviewed facts.
- Document owning team and oncall procedures.
- Document how this plugin is deployed to production OpenSearch clusters.
