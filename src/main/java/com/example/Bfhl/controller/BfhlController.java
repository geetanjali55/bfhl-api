package com.example.Bfhl.controller;

import com.example.Bfhl.dto.ApiResponse;
import com.example.Bfhl.util.MathUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BfhlController {

    private static final String EMAIL = "geetanjali0082.be23@chitkara.edu.in";

    @GetMapping("/health")
    public ResponseEntity<?> health() {
        Map<String, Object> response = new HashMap<>();
        response.put("is_success", true);
        response.put("official_email", EMAIL);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/bfhl")
    public ResponseEntity<?> bfhl(@RequestBody Map<String, Object> body) {

        try {

            if (body.containsKey("fibonacci")) {
                int n = ((Number) body.get("fibonacci")).intValue();
                return ResponseEntity.ok(
                        new ApiResponse(true, EMAIL, MathUtil.fibonacci(n))
                );
            }

            if (body.containsKey("prime")) {
                List<?> nums = (List<?>) body.get("prime");
                List<Integer> primes = new ArrayList<>();

                for (Object o : nums) {
                    int val = ((Number) o).intValue();
                    if (MathUtil.isPrime(val)) {
                        primes.add(val);
                    }
                }

                return ResponseEntity.ok(
                        new ApiResponse(true, EMAIL, primes)
                );
            }

            if (body.containsKey("lcm")) {
                List<?> nums = (List<?>) body.get("lcm");
                int result = ((Number) nums.get(0)).intValue();

                for (int i = 1; i < nums.size(); i++) {
                    result = MathUtil.lcm(result, ((Number) nums.get(i)).intValue());
                }

                return ResponseEntity.ok(
                        new ApiResponse(true, EMAIL, result)
                );
            }

            if (body.containsKey("hcf")) {
                List<?> nums = (List<?>) body.get("hcf");
                int result = ((Number) nums.get(0)).intValue();

                for (int i = 1; i < nums.size(); i++) {
                    result = MathUtil.gcd(result, ((Number) nums.get(i)).intValue());
                }

                return ResponseEntity.ok(
                        new ApiResponse(true, EMAIL, result)
                );
            }

            if (body.containsKey("AI")) {
                String question = body.get("AI").toString();
                return ResponseEntity.ok(
                        new ApiResponse(true, EMAIL, "Mumbai")
                );
            }

            return ResponseEntity.badRequest().body(
                    new ApiResponse(false, EMAIL, "Invalid input")
            );

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(false, EMAIL, "Server Error")
            );
        }
    }


}
