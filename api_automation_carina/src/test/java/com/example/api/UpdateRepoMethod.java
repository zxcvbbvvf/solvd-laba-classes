package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class UpdateRepoMethod extends AbstractApiMethodV2 {
    public UpdateRepoMethod(String owner, String repo) {
        super("api/update_repo.json", null);
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        setMethodPath("/repos/" + owner + "/" + repo);
    }
}
