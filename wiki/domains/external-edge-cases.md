---
title: Edge cases decided outside code
last_reviewed: 2026-08-29
tags: [readiness-placeholder, external-edge-cases]
folder: domains
sources:
  - code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/
agent_routing:
  code_change_relevance: conditional
  task_intents: [domain-behavior-change]
  applies_to_paths: []
  applies_to_symbols: []
---

# Edge cases decided outside code

> Readiness page: generated from repo evidence for `external-edge-cases` and still needs human review.

## Known Edge Cases from Code

### Hebrew N-gram Analysis Edge Cases

- The `PluralFilter` strips Hebrew plural suffixes (`ים` and `ות`) from words with 3 or more characters
- The `StopLetterFilter` removes specified stop letters from non-exact tokens (configured with letters `ו` and `י` by default)
- The `SefariaTokenizer` splits tokens on `+` characters (Sefaria format), and tokens are generated from the complete input text
- The `SefariaNGramTokenFilter` generates character n-grams of length 3 for non-exact tokens and appends `$` to exact (original) tokens
- The `SefariaSemiExactFilter` outputs both the original word and the word with a `$` suffix marker

### Unicode Considerations

- Hebrew niqqud (vowel) characters (`֑-ֽ`, `ֿ`, `ׁ`, `ׂ`, `ׄ`, `ׅ`, `ׇ`) are stripped by the `PatternReplaceFilter` in both analyzers
- ASCII folding is applied for Latin character normalization
- Lowercase transformation is applied for case-insensitive matching

## Source References

- `code:opensearch-hebrew-analyser/src/main/java/com/hotstar/hebrew/analysis/` — contributed edge case evidence from code logic.

## Suggested Content

- Confirm all edge case descriptions are correct.
- Add any additional business rules or product decisions about Hebrew search behavior.
- Document expected search behavior for edge cases like empty input, special characters, etc.
