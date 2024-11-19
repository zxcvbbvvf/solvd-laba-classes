package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.HideResponseHeadersInLogs;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/repos/${owner}/${repo}/issues/${issue_number}", methodType = HttpMethodType.GET)
@PropertiesPath(path = "api/properties/get_issue.properties")
@HideResponseHeadersInLogs(headers = {"Authorization"})
public class GetIssueMethod extends AbstractApiMethodV2 {
    public GetIssueMethod(String owner, String repo, int issueNumber) {
        super();
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
        replaceUrlPlaceholder("issue_number", String.valueOf(issueNumber));
    }
}
