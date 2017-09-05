package edu.monash.shangqi.hve.core;

import edu.monash.shangqi.hve.param.CipherParameter;
import edu.monash.shangqi.hve.param.KeyParameter;

public interface CipherEngine {
    void init(boolean forEncryption, KeyParameter parameter);
}
