# Wiki Map

Task-oriented navigation. Find your intent, then follow the links. Pages may appear under more than one heading.

## Understand the system

- [Repo Overview](overview/repo-overview.md) — what the project is and its key components
- [Architecture Overview](architecture/architecture-overview.md) — how the analysis pipelines work
- [Module Structure](architecture/module-structure.md) — package and class organization
- [Data Flow](data/data-flow.md) — how text flows through the analysis chain
- [Domain Concepts](domains/domain-concepts.md) — Hebrew linguistic concepts handled by the plugin
- [Dependencies](architecture/dependencies.md) — external libraries and their roles

## Change behavior

- [Public API](api/public-api.md) — analyzer names and contracts to honor when configuring indices
- [Data Models](data/data-models.md) — token attributes and data structures
- [Domain Concepts](domains/domain-concepts.md) — Hebrew linguistic behavior before changing analysis logic
- [Entry Points](architecture/entry-points.md) — plugin components and registration points
- [Edge Cases](domains/external-edge-cases.md) — known edge cases in Hebrew analysis
- [Tradeoffs and Rejected Alternatives](decisions/tradeoffs-rejected-alternatives.md) — design decisions to know before changing

## Operate in production

- [Build, Test, Deploy](engineering/build-test-deploy.md) — build, test, and deploy instructions
- [Configuration](engineering/configuration.md) — gradle properties and plugin configuration
- [Production Context](operations/production-context.md) — production runtime facts
- [IaC Info](operations/iac-info.md) — infrastructure information

## Onboard a new engineer

- [Repo Overview](overview/repo-overview.md) — start here on day one
- [How to Set Up the Service](engineering/how-to-set-up-the-service.md) — get a working environment
- [How to Run Tests](engineering/how-to-run-tests.md) — run tests and understand test configuration
- [Code and Naming Conventions](engineering/code-and-naming-conventions.md) — coding style and patterns
- [Dependencies](architecture/dependencies.md) — external libraries used by the project
