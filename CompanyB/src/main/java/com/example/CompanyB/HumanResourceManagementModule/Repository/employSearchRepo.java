package com.example.CompanyB.HumanResourceManagementModule.Repository;

import com.example.CompanyB.HumanResourceManagementModule.Model.Employ;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Qualifier
public class employSearchRepo implements searchRepository{

    @Autowired
    MongoConverter mongoConverter;

    @Autowired
    MongoClient client;

    @Override
    public List<Employ> findByText(String text) {
        List<Employ> employList = new ArrayList<>();

        MongoDatabase database = client.getDatabase("CompanyB");
        MongoCollection<Document> collection = database.getCollection("employ");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search", new Document("text",
                        new Document("query", text).append("path", Arrays.asList("firstName", "lastName"))))));
        result.forEach(doc -> employList.add(mongoConverter.read(Employ.class,doc)));
        return employList;
    }
}
