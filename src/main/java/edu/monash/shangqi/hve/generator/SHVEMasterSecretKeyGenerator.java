package edu.monash.shangqi.hve.generator;

import com.sun.org.apache.xml.internal.serializer.utils.MsgKey;
import edu.monash.shangqi.hve.param.SHVEMasterSecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.SHVEMasterSecretKeyParameter;
import edu.monash.shangqi.hve.util.RandomUtil;

public class SHVEMasterSecretKeyGenerator {

    private SHVEMasterSecretKeyGenerationParameter param;

    public SHVEMasterSecretKeyGenerator() {
    }

    public void init(SHVEMasterSecretKeyGenerationParameter param) {
        this.param = param;
    }

    public SHVEMasterSecretKeyParameter generateMSK() {
        String MSK = RandomUtil.getRandom(16);

        return new SHVEMasterSecretKeyParameter(param, MSK);
    }
}
