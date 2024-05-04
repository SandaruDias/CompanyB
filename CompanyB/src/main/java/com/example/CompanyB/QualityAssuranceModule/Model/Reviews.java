package com.example.CompanyB.QualityAssuranceModule.Model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "ProductReviews")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Reviews {
    @Id
    private String id;
    @Field("reviewId")
    private String reviewId;
    private String productId;
    private boolean checkedReview;
    private String email;
    private boolean sentMail;

    public void setEmail(String email){
        this.email = email;
    }
    public void setReviewId(String reviewId){
        //this.reviewId = reviewId;
        UUID.fromString(reviewId);
        this.reviewId = reviewId;
    }
}

