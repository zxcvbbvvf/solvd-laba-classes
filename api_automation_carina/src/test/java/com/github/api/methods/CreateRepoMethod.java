package com.github.api.methods;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.ContentType;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.HideRequestBodyPartsInLogs;
import com.zebrunner.carina.api.annotation.HideResponseHeadersInLogs;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.http.HttpMethodType;

@Endpoint(url = "${api_url}/user/repos", methodType = HttpMethodType.POST)
@ContentType(type = "application/json")
@PropertiesPath(path = "api/properties/create_repo.properties")
@RequestTemplatePath(path = "api/create_repo.json")
@HideRequestBodyPartsInLogs(paths = {"token"})
@HideResponseHeadersInLogs(headers = {"Authorization"})
public class CreateRepoMethod extends AbstractApiMethodV2 {
    public CreateRepoMethod() {
        super();
    }
}
