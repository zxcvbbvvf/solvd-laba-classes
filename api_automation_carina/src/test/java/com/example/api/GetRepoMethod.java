package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class GetRepoMethod extends AbstractApiMethodV2 {
    public GetRepoMethod(String owner, String repo) {
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        setMethodPath("/repos/" + owner + "/" + repo);
    }
}
