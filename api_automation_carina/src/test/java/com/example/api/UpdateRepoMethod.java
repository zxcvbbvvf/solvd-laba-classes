package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.Header;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${base_url}/repos/${owner}/${repo}", methodType = HttpMethodType.PATCH)
@Header(key = "Authorization", value = "Bearer ${token}")
@PropertiesPath(path = "api/github.properties")
@RequestTemplatePath(path = "api/update_repo.json")
@ResponseTemplatePath(path = "api/update_repo_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.OK_200)
public class UpdateRepoMethod extends AbstractApiMethodV2 {
}
