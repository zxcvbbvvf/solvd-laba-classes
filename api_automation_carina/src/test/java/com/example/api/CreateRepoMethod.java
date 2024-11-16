package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class CreateRepoMethod extends AbstractApiMethodV2 {
    public CreateRepoMethod() {
        super("api/create_repo.json", null);
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
    }
}
