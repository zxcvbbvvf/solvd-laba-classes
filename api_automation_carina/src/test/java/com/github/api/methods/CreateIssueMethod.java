package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.ContentType;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.HideResponseHeadersInLogs;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/repos/${owner}/${repo}/issues", methodType = HttpMethodType.POST)
@ContentType(type = "application/json")
@PropertiesPath(path = "api/properties/create_issue.properties")
@RequestTemplatePath(path = "api/create_issue.json")
@HideResponseHeadersInLogs(headers = {"Authorization"})
public class CreateIssueMethod extends AbstractApiMethodV2 {
    public CreateIssueMethod(String owner, String repo) {
        super();
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }
}
