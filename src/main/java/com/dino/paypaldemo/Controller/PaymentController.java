package com.dino.paypaldemo.Controller;


import com.dino.paypaldemo.config.Environment;
import com.dino.paypaldemo.enums.RequestType;
import com.dino.paypaldemo.models.PaymentResponse;
import com.dino.paypaldemo.processor.CreateOrderMoMo;
import com.dino.paypaldemo.utils.LogUtils;

import com.mservice.shared.exception.MoMoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class PaymentController {
    @GetMapping("payment")
    public PaymentResponse payment() throws MoMoException {
        LogUtils.init();
        String requestId = String.valueOf(System.currentTimeMillis());
        String orderId = String.valueOf(System.currentTimeMillis());
        Long transId = 2L;
        long amount = 50000;

        String partnerClientId = "partnerClientId";
        String orderInfo = "Pay With MoMo";
        String returnURL = "https://google.com.vn";
        String notifyURL = "https://google.com.vn";


        Environment environment = Environment.selectEnv("dev");


//      Remember to change the IDs at enviroment.properties file

        /*
         * create payment with capture momo wallet
         */
        PaymentResponse captureWalletMoMoResponse = CreateOrderMoMo.process(environment, orderId, requestId, Long.toString(amount), orderInfo, returnURL, notifyURL, "", RequestType.CAPTURE_WALLET, Boolean.TRUE);
        return captureWalletMoMoResponse;

    }
}