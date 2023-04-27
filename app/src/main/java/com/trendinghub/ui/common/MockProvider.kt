package com.trendinghub.ui.common

import com.trendinghub.data.remote.source.model.Items
import com.trendinghub.data.remote.source.model.License
import com.trendinghub.data.remote.source.model.Owner
import com.trendinghub.data.remote.source.model.TrendingResponseData
import com.trendinghub.domain.model.TrendingData

object MockProvider {

    fun getTrendingData() = TrendingData(
        repoName = "TrendingHub",
        userAvatar = "https://avatars.githubusercontent.com/u/4314092?v=4",
        userName = "Maria",
        stargazersCount = 1000,
        language = "Kotlin"
    )

    fun getTrendingResponseData() = TrendingResponseData(
        items = arrayListOf(
            getMockItems()
        ),
        totalCount = 1,
        incompleteResults = false
    )

    fun getMockOwner() = Owner(
        login = "Maria",
        id = 1,
        nodeId = "nodeId test",
        avatarUrl = "https://avatars.githubusercontent.com/u/4314092?v=4",
        gravatarId = "gravatarId test",
        url = "url test",
        htmlUrl = "htmlUrl test",
        followersUrl = "followersUrl test",
        followingUrl = "followingUrl test",
        gistsUrl = "gistsUrl test",
        starredUrl = "starredUrl test",
        subscriptionsUrl = "subscriptionsUrl test",
        organizationsUrl = "organizationsUrl test",
        reposUrl = "reposUrl test",
        eventsUrl = "eventsUrl test",
        receivedEventsUrl = "receivedEventsUrl test",
        type = "type test",
        siteAdmin = true
    )

    fun getMockLicense() = License(
        key = "key test",
        name = "name test",
        spdxId = "spdxId test",
        url = "url test",
        nodeId = "nodeId test"
    )

    fun getMockItems() = Items(
        id = 1,
        nodeId = "",
        name = "TrendingHub",
        fullName = "Maria/TrendingHub",
        private = true,
        owner = getMockOwner(),
        htmlUrl = "htmlUrl test",
        description = "description test",
        fork = true,
        url = "url test",
        forksUrl = "forksUrl test",
        keysUrl = "keysUrl test",
        collaboratorsUrl = "collaboratorsUrl test",
        teamsUrl = "teamsUrl test",
        hooksUrl = "hooksUrl test",
        issueEventsUrl = "issueEventsUrl test",
        eventsUrl = "eventsUrl test",
        assigneesUrl = "assigneesUrl test",
        branchesUrl = "branchesUrl test",
        tagsUrl = "tagsUrl test",
        blobsUrl = "blobsUrl test",
        gitTagsUrl = "gitTagsUrl test",
        gitRefsUrl = "gitRefsUrl test",
        treesUrl = "treesUrl test",
        statusesUrl = "statusesUrl test",
        languagesUrl = "languagesUrl test",
        stargazersUrl = "stargazersUrl test",
        contributorsUrl = "contributorsUrl test",
        subscribersUrl = "subscribersUrl test",
        subscriptionUrl = "subscriptionUrl test",
        commitsUrl = "commitsUrl test",
        gitCommitsUrl = "gitCommitsUrl test",
        commentsUrl = "commentsUrl test",
        issueCommentUrl = "issueCommentUrl test",
        contentsUrl = "contentsUrl test",
        compareUrl = "compareUrl test",
        mergesUrl = "mergesUrl test",
        archiveUrl = "archiveUrl test",
        downloadsUrl = "downloadsUrl test",
        issuesUrl = "issuesUrl test",
        pullsUrl = "pullsUrl test",
        milestonesUrl = "milestonesUrl test",
        notificationsUrl = "notificationsUrl test",
        labelsUrl = "labelsUrl test",
        releasesUrl = "releasesUrl test",
        deploymentsUrl = "deploymentsUrl test",
        createdAt = "createdAt test",
        updatedAt = "updatedAt test",
        pushedAt = "pushedAt test",
        gitUrl = "gitUrl test",
        sshUrl = "sshUrl test",
        cloneUrl = "cloneUrl test",
        svnUrl = "svnUrl test",
        homepage = "homepage test",
        size = 1,
        stargazersCount = 1000,
        language = "Kotlin",
        watchersCount = 1,
        hasIssues = true,
        hasProjects = true,
        hasDownloads = true,
        hasWiki = true,
        hasPages = true,
        hasDiscussions = true,
        forksCount = 1,
        mirrorUrl = "mirrorUrl test",
        archived = true,
        disabled = true,
        openIssuesCount = 1,
        license = getMockLicense(),
        allowForking = true,
        isTemplate = true,
        webCommitSignOffRequired = true,
        topics = arrayListOf("test value"),
        visibility = "visibility test",
        forks = 1,
        openIssues = 1,
        watchers = 1,
        defaultBranch = "defaultBranch test",
        score = 1
    )

}