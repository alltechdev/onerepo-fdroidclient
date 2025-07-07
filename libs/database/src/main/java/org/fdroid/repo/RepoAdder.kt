package org.fdroid.repo

import android.content.Context
import kotlinx.coroutines.flow.MutableStateFlow
import mu.KotlinLogging
import org.fdroid.database.FDroidDatabase
import org.fdroid.download.DownloaderFactory
import org.fdroid.download.HttpManager
import org.fdroid.index.TempFileProvider
import java.net.Proxy

internal const val REPO_ID = 0L

public sealed class AddRepoState
public object None : AddRepoState()
public class AddRepoError : AddRepoState()

internal class RepoAdder(
    private val context: Context,
    private val db: FDroidDatabase,
    private val tempFileProvider: TempFileProvider,
    private val downloaderFactory: DownloaderFactory,
    private val httpManager: HttpManager
) {
    private val log = KotlinLogging.logger {}
    internal val addRepoState: MutableStateFlow<AddRepoState> = MutableStateFlow(None)

    internal fun fetchRepository(url: String, proxy: Proxy?) {
        log.info("Blocked fetchRepository call for $url")
        addRepoState.value = AddRepoError()
    }

    internal suspend fun fetchRepositoryInt(url: String, proxy: Proxy? = null) {
        log.info("Blocked fetchRepositoryInt call for $url")
        addRepoState.value = AddRepoError()
    }

    internal fun addFetchedRepository(): Nothing? {
        log.info("Blocked addFetchedRepository()")
        return null
    }

    internal suspend fun addArchiveRepo(repo: org.fdroid.database.Repository, proxy: Proxy? = null): Long? {
        log.info("Blocked addArchiveRepo()")
        return null
    }

    internal fun abortAddingRepo() {
        log.info("abortAddingRepo() called — nothing to abort")
        addRepoState.value = None
    }
}
