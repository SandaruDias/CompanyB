package com.example.CompanyB.QualityAssuranceModule.Controller;

import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.CompanyB.QualityAssuranceModule.Model.QAProduct;
import com.example.CompanyB.QualityAssuranceModule.Model.Reviews;
import com.example.CompanyB.QualityAssuranceModule.Repository.QAProductRepository;
import com.example.CompanyB.QualityAssuranceModule.Repository.ReviewRepository;

@RestController
@RequestMapping("/product")
public class ReviewController {
    @Autowired
    private QAProductRepository QAProductRepository;
    @Autowired
    private ReviewRepository  reviewRepository;

    @PostMapping("/{productId}")
    public QAProduct addReviewId(@PathVariable String productId, @RequestBody Map<String, String> payload) {
        // Save the email and productId in the ProductReview collection
        Reviews review = new Reviews();
        //review.setProductId(productId);
        review.setEmail(payload.get("email"));
        String reviewId = UUID.randomUUID().toString();
        review.setReviewId(reviewId);
        reviewRepository.save(review);

        QAProduct QAProduct = QAProductRepository.findByProductId(productId);
        //product.getComments().add(payload.get("reviewText"));
        return QAProductRepository.save(QAProduct);
    }

}
