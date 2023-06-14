package com.hyesulee.mygithub.model

import com.google.gson.annotations.SerializedName

data class UsersData(
    @SerializedName("total_count"        ) var totalCount        : Int?             = null,
    @SerializedName("incomplete_results" ) var incompleteResults : Boolean?         = null,
    @SerializedName("items"              ) var items             : ArrayList<Items> = arrayListOf()
)

data class Items (
    @SerializedName("login"               ) var login             : String?  = null,
    @SerializedName("id"                  ) var id                : Int?     = null,
    @SerializedName("node_id"             ) var nodeId            : String?  = null,
    @SerializedName("avatar_url"          ) var avatarUrl         : String?  = null,
    @SerializedName("gravatar_id"         ) var gravatarId        : String?  = null,
    @SerializedName("url"                 ) var url               : String?  = null,
    @SerializedName("html_url"            ) var htmlUrl           : String?  = null,
    @SerializedName("followers_url"       ) var followersUrl      : String?  = null,
    @SerializedName("subscriptions_url"   ) var subscriptionsUrl  : String?  = null,
    @SerializedName("organizations_url"   ) var organizationsUrl  : String?  = null,
    @SerializedName("repos_url"           ) var reposUrl          : String?  = null,
    @SerializedName("received_events_url" ) var receivedEventsUrl : String?  = null,
    @SerializedName("type"                ) var type              : String?  = null,
    @SerializedName("score"               ) var score             : Int?     = null,
    @SerializedName("following_url"       ) var followingUrl      : String?  = null,
    @SerializedName("gists_url"           ) var gistsUrl          : String?  = null,
    @SerializedName("starred_url"         ) var starredUrl        : String?  = null,
    @SerializedName("events_url"          ) var eventsUrl         : String?  = null,
    @SerializedName("site_admin"          ) var siteAdmin         : Boolean? = null
)

data class UserDetails (

    @SerializedName("login"               ) var login             : String?  = null,
    @SerializedName("id"                  ) var id                : Int?     = null,
    @SerializedName("node_id"             ) var nodeId            : String?  = null,
    @SerializedName("avatar_url"          ) var avatarUrl         : String?  = null,
    @SerializedName("gravatar_id"         ) var gravatarId        : String?  = null,
    @SerializedName("url"                 ) var url               : String?  = null,
    @SerializedName("html_url"            ) var htmlUrl           : String?  = null,
    @SerializedName("followers_url"       ) var followersUrl      : String?  = null,
    @SerializedName("following_url"       ) var followingUrl      : String?  = null,
    @SerializedName("gists_url"           ) var gistsUrl          : String?  = null,
    @SerializedName("starred_url"         ) var starredUrl        : String?  = null,
    @SerializedName("subscriptions_url"   ) var subscriptionsUrl  : String?  = null,
    @SerializedName("organizations_url"   ) var organizationsUrl  : String?  = null,
    @SerializedName("repos_url"           ) var reposUrl          : String?  = null,
    @SerializedName("events_url"          ) var eventsUrl         : String?  = null,
    @SerializedName("received_events_url" ) var receivedEventsUrl : String?  = null,
    @SerializedName("type"                ) var type              : String?  = null,
    @SerializedName("site_admin"          ) var siteAdmin         : Boolean? = null,
    @SerializedName("name"                ) var name              : String?  = null,
    @SerializedName("company"             ) var company           : String?  = null,
    @SerializedName("blog"                ) var blog              : String?  = null,
    @SerializedName("location"            ) var location          : String?  = null,
    @SerializedName("email"               ) var email             : String?  = null,
    @SerializedName("hireable"            ) var hireable          : String?  = null,
    @SerializedName("bio"                 ) var bio               : String?  = null,
    @SerializedName("twitter_username"    ) var twitterUsername   : String?  = null,
    @SerializedName("public_repos"        ) var publicRepos       : Int?     = null,
    @SerializedName("public_gists"        ) var publicGists       : Int?     = null,
    @SerializedName("followers"           ) var followers         : Int?     = null,
    @SerializedName("following"           ) var following         : Int?     = null,
    @SerializedName("created_at"          ) var createdAt         : String?  = null,
    @SerializedName("updated_at"          ) var updatedAt         : String?  = null

)