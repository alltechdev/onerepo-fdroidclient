package org.fdroid.repo

/**
 * A map from canonical repo URL to lower-case fingerprint of this repo.
 * Only your custom repo is included.
 */
internal val knownRepos = mapOf(
    "https://your.repo.url" to "abcdef1234567890abcdef1234567890abcdef12"
)
