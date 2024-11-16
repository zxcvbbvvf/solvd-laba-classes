package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.api.annotation.ContentType;
import com.zebrunner.carina.api.annotation.Endpoint;
import com.zebrunner.carina.api.annotation.Header;
import com.zebrunner.carina.api.annotation.PropertiesPath;
import com.zebrunner.carina.api.annotation.RequestTemplatePath;
import com.zebrunner.carina.api.annotation.ResponseTemplatePath;
import com.zebrunner.carina.api.annotation.SuccessfulHttpStatus;
import com.zebrunner.carina.api.http.HttpMethodType;
import com.zebrunner.carina.api.http.HttpResponseStatusType;

@Endpoint(url = "${base_url}/user/repos", methodType = HttpMethodType.POST)
@ContentType(type = "application/json")
@Header(key = "Authorization", value = "Bearer ${token}")
@PropertiesPath(path = "api/github.properties")
@RequestTemplatePath(path = "api/create_repo.json")
@ResponseTemplatePath(path = "api/create_repo_response.json")
@SuccessfulHttpStatus(status = HttpResponseStatusType.CREATED_201)
public class CreateRepoMethod extends AbstractApiMethodV2 {
}
