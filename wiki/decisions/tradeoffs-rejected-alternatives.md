---
title: Known tradeoffs and rejected alternatives
last_reviewed: 2026-08-29
tags: [readiness-placeholder, tradeoffs-rejected-alternatives]
folder: decisions
sources: []
agent_routing:
  code_change_relevance: conditional
  task_intents: [architecture-change]
  applies_to_paths: []
  applies_to_symbols: []
---

# Known tradeoffs and rejected alternatives

> Readiness page: generated from repo evidence for `tradeoffs-rejected-alternatives` and still needs human review.

No ADRs, RFCs, or decision records found in this repository.

## Implicit Tradeoffs from Code

The codebase reveals some implicit design choices:

1. **Two analyzer types**: The plugin provides both n-gram (fuzzy/substring matching) and semi-exact (word boundary) analyzers, suggesting a tradeoff between recall (n-gram) and precision (semi-exact)
2. **No-op token filters**: `hebrew_stop` and `hebrew_word` token filters are registered as no-ops, suggesting future extensibility
3. **Disabled validations**: Several Gradle validations are disabled (forbidden patterns, license headers, testing conventions, etc.)

## Suggested Content

- Add any ADRs or design documents about why n-gram vs. semi-exact approach was chosen.
- Document why certain Gradle validations are disabled.
- Add any rejected analysis approaches (e.g., HebMorph, other Hebrew analyzers).
- Document known limitations of the current analysis approach.
