package edu.monash.shangqi.param;

import org.bouncycastle.crypto.KeyGenerationParameters;

import java.security.SecureRandom;

public class HVEKeyGenerationParameters extends KeyGenerationParameters {

    private HVEParameters params;

    public HVEKeyGenerationParameters(SecureRandom random, HVEParameters params) {
        super(random, params.getG().getField().getLengthInBytes());
        this.params = params;
    }

    public HVEParameters getParameters() {
        return this.params;
    }
}
