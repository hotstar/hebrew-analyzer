# LLM-Wiki Readiness Report

Overall score: 30/100 - Not ready

## Summary

This repository is an OpenSearch Hebrew analysis plugin (Java/Gradle). It has limited documentation outside the wiki scaffold. The README provides basic project context and token examples, and the source code is well-structured. However, setup instructions, test documentation, IaC info, production context, and release conventions are mostly absent.

## Topic Scores

| Topic | Score | Evidence | Gap |
| --- | ---: | --- | --- |
| How to set up the service | 6/12 | wiki/engineering/how-to-set-up-the-service.md, README.md, build.gradle | Readiness page populated with build and install details; missing local service reset steps and prerequisites list. Command verification skipped: Java runtime not available. |
| How to set up an environment for local testing | 2.5/10 | wiki/engineering/local-testing-environment.md, build.gradle | Readiness page has basic test configuration from gradle; missing test data, mock services, and verification steps. Command verification skipped: Java runtime not available. |
| How to run tests | 3.5/14 | wiki/engineering/how-to-run-tests.md, build.gradle | Readiness page has test dependencies and configuration; missing test data, common failure modes, and integTest isn't configured. Command verification skipped: Java runtime not available. |
| IaC info | 0/8 | wiki/operations/iac-info.md | No IaC documentation found. This is a plugin (not a service), so IaC is likely managed elsewhere. |
| Production context | 3/12 | wiki/operations/production-context.md | Readiness page is a placeholder; no production service name, SLOs, or runbook information available. |
| Customer context | 5/10 | wiki/domains/customer-context.md, README.md | Readiness page populated with basic customer context from README and code; missing detailed customer journeys, segments, and business rules. |
| How to generate hermetic server/build | 5/10 | wiki/engineering/hermetic-build.md, build.gradle | Readiness page has build commands and configuration; missing Java version requirements and plugin verification steps. Command verification skipped: Java runtime not available. |
| Code and naming conventions | 4/8 | wiki/engineering/code-and-naming-conventions.md, source code | Readiness page has package structure and naming patterns from code; missing specific style rules and contribution guidelines. |
| Secrets and config management rules | 0/10 | wiki/engineering/secrets-config-management.md | No secrets management documentation found. As a plugin, secrets may be external. |
| Branching and release conventions | 0/8 | wiki/engineering/branching-release-conventions.md | No branching/release documentation found. |
| Edge cases decided outside code | 5/10 | wiki/domains/external-edge-cases.md, source code | Readiness page populated with Hebrew analysis edge cases from code; additional business rules may exist outside code. |
| Known tradeoffs and rejected alternatives | 2.5/10 | wiki/decisions/tradeoffs-rejected-alternatives.md | Readiness page notes implicit tradeoffs from code; no formal ADRs or decision records. |

## Top Gaps

1. Add setup prerequisites and local service reset steps.
2. Add branching and release conventions.
3. Add production context (service identity, owning team).
4. Add formal ADRs or decision records for design choices.
5. Add secrets management documentation.

## Suggested Wiki Changes

| Priority | Wiki path | Exact change |
| --- | --- | --- |
| High | `wiki/engineering/how-to-set-up-the-service.md` | Add required Java version, detailed OpenSearch cluster setup instructions, and local reset steps. |
| High | `wiki/engineering/branching-release-conventions.md` | Add branch naming, PR process, release process, versioning, and rollback procedures. |
| High | `wiki/operations/production-context.md` | Add production service name, owning team, oncall details. |
| Medium | `wiki/decisions/tradeoffs-rejected-alternatives.md` | Create ADRs for key design choices (n-gram vs semi-exact, why Sefaria format, disabled Gradle validations). |
| Medium | `wiki/engineering/how-to-run-tests.md` | Add common failure modes, test data setup, and debugging guidance. |

## Repo Docs Migration

| Repo doc | Wiki target | Recommendation | Drift or conflict |
| --- | --- | --- | --- |
| `README.md` | `wiki/engineering/how-to-set-up-the-service.md` | Wiki page populated from this doc; remove or deprecate the repo doc only after the wiki page is reviewed and accepted. | Partial coverage: README has basic description, wiki has more detailed build/install. |
| `README.md` | `wiki/domains/customer-context.md` | README tokenizer examples were used in customer context page. | No conflict found. |

## Evidence Notes

- Java runtime not available; all `execution_required: true` commands (service-setup, local-testing-environment, test-commands, hermetic-build) were skipped. Scores capped at 2 for these topics per rubric rules.
- Secret-bearing files were not detected in this repo.
- Plugin descriptor (`es-plugin.properties`) was used as weak evidence for plugin configuration.
