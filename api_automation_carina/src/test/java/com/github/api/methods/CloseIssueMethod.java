package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.ContentType;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.HideRequestBodyPartsInLogs;
import com.zebrunner.carina.api.annotation.HideResponseHeadersInLogs;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/repos/${owner}/${repo}/issues/${issue_number}", methodType = HttpMethodType.PATCH)
@ContentType(type = "application/json")
@PropertiesPath(path = "api/properties/close_issue.properties")
@RequestTemplatePath(path = "api/close_issue.json")
@HideRequestBodyPartsInLogs(paths = {"token"})
@HideResponseHeadersInLogs(headers = {"Authorization"})
public class CloseIssueMethod extends AbstractApiMethodV2 {
    public CloseIssueMethod(String owner, String repo, int issueNumber) {
        super();
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("issue_number", String.valueOf(issueNumber));
    }
}