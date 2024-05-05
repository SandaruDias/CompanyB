package com.example.CompanyB.QualityAssuranceModule.Model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ProductsDetails")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class QAProduct {
    @Id
    private String _id;
    private String productId;
    private String productName;
    private String description;
    private int price;
    private int stock;
    @Field("comments")
    private List<String> comments;
}

