package com.example.api;

import com.zebrunner.carina.api.AbstractApiMethodV2;
import com.zebrunner.carina.utils.config.Configuration;

public class GetReposListMethod extends AbstractApiMethodV2 {
    public GetReposListMethod(String owner) {
        super(null, null);
        replaceUrlPlaceholder("base_url", Configuration.getRequired("api_url"));
        setMethodPath("/users/" + owner + "/repos");
    }
}