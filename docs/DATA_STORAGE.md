# Data Storage

## Storage classes

### DataStore

Use for:

- app preferences;
- active instance ID;
- non-secret instance display metadata;
- theme and accessibility preferences;
- lock policy preferences.

### Keystore-backed encrypted files/preferences

Use for:

- OAuth `AuthState`;
- API tokens;
- sensitive custom headers;
- mTLS client identity passwords/references if unavoidable.

### Room

Add when a feature needs durable structured read cache/history, for example:

- event history;
- cached resource summaries;
- cross-instance comparison snapshots;
- drift baseline metadata.

Credentials and secret values never enter Room.

## Cache rules

Each cached resource includes:

- instance ID;
- resource ID;
- fetched timestamp;
- source server version where relevant.

UI must indicate staleness when the data could materially affect an administrative decision.

## Deletion

Removing an instance deletes:

- encrypted credentials;
- custom secret headers;
- imported trust/client identity references owned by that instance;
- Room cache rows for that instance;
- DataStore instance metadata.

Deletion should be transactional where possible and verified by tests.
