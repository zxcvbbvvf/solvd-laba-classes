package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.HideResponseHeadersInLogs;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/repos/${owner}/${repo}/issues", methodType = HttpMethodType.GET)
@PropertiesPath(path = "api/properties/list_issues.properties")
@HideResponseHeadersInLogs(headers = {"Authorization"})
public class ListIssuesMethod extends AbstractApiMethodV2 {
    public ListIssuesMethod(String owner, String repo) {
        super();
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }
}
