package account.controller;

import account.dto.request.UploadPayrollRequest;
import account.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Validated
@RequestMapping("/api")
public class PaymentController {
    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/acct/payments")
    public ResponseEntity<Map<String, String>> createPayments(@RequestBody List<@Valid UploadPayrollRequest> request) {
        paymentService.uploadPayroll(request);
        return ResponseEntity.ok().body(Map.of("status", "Added successfully!"));
    }

    @PutMapping("/acct/payments")
    public ResponseEntity<Map<String, String>> updatePayment(@RequestBody @Valid UploadPayrollRequest request) {
        paymentService.updatePayment(request);
        return ResponseEntity.ok().body(Map.of("status", "Updated successfully!"));
    }


}