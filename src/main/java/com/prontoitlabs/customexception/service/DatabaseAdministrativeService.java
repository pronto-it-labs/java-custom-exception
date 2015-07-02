package com.prontoitlabs.customexception.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseAdministrativeService {
    /**
     * @author Giridhar
     **/
    @Autowired
    private MongoTemplate mongoTemplate;

    public void deleteAll() {
        mongoTemplate.getDb().dropDatabase();
    }
}
