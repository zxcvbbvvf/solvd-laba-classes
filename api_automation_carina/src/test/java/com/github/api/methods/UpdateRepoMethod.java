package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.ContentType;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/repos/${owner}/${repo}", methodType = HttpMethodType.PATCH)
@ContentType(type = "application/json")
@RequestTemplatePath(path = "api/update_repo.json")
@PropertiesPath(path = "api/properties/update_repo.properties")
public class UpdateRepoMethod extends AbstractApiMethodV2 {
    public UpdateRepoMethod(String owner, String repo) {
        super();
        replaceUrlPlaceholder("owner", owner);
        replaceUrlPlaceholder("repo", repo);
    }
}
