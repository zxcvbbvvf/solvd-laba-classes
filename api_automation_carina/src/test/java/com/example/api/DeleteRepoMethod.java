package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class DeleteRepoMethod extends AbstractApiMethodV2 {
    public DeleteRepoMethod(String owner, String repo) {
        super("api/delete_repo.json", null);
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        setMethodPath("/repos/" + owner + "/" + repo);
    }
}
