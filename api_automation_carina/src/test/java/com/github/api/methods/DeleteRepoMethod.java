package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.HideResponseHeadersInLogs;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/repos/${owner}/${repo}", methodType = HttpMethodType.DELETE)
@PropertiesPath(path = "api/properties/delete_repo.properties")
@HideResponseHeadersInLogs(headers = {"Authorization"})
public class DeleteRepoMethod extends AbstractApiMethodV2 {
    public DeleteRepoMethod(String owner, String repo) {
        super();
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }
}
