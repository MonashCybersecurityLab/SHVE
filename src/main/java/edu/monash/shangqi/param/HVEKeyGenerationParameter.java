package edu.monash.shangqi.param;

import org.bouncycastle.crypto.KeyGenerationParameters;

import java.security.SecureRandom;

public class HVEKeyGenerationParameter extends KeyGenerationParameters {

    private HVEParameter params;

    public HVEKeyGenerationParameter(SecureRandom random, HVEParameter params) {
        super(random, params.getG().getField().getLengthInBytes());
        this.params = params;
    }

    public HVEParameter getParameters() {
        return this.params;
    }
}
