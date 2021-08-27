package com.Api2.API2.KafkaConsumer;

import com.Api2.API2.Controller.saqueController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Service;

@Service
public class CustomerListener {

    @Autowired
    private saqueController qtd;

    @KafkaListener(topics = "Novo_Saque", groupId = "Novo_Saque")
    @SendTo
    public String listen(String nconta) {
        String uuid = qtd.alterarQtdSaquesBanco(nconta);
        System.out.println("---------------------------");
        System.out.println(uuid + " / " + nconta);
        System.out.println("Adicionando +1 saque no banco de dados");
        System.out.println("---------------------------");
        return "salvo" + uuid;
    }
}