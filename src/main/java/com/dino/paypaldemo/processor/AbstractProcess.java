package com.dino.paypaldemo.processor;

import com.dino.paypaldemo.config.Environment;
import com.dino.paypaldemo.exception.MoMoException;
import com.dino.paypaldemo.utils.Execute;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mservice.shared.sharedmodels.PartnerInfo;

public abstract class AbstractProcess<T, V> {

    protected PartnerInfo partnerInfo;
    protected Environment environment;
    protected Execute execute = new Execute();

    public AbstractProcess(Environment environment) {
        this.environment = environment;
        this.partnerInfo = environment.getPartnerInfo();
    }

    public static Gson getGson() {
        return new GsonBuilder()
                .disableHtmlEscaping()
                .create();
    }

    public abstract V execute(T request) throws MoMoException;
}
