package edu.monash.shangqi.hve;

import edu.monash.shangqi.hve.generator.impl.SHVEMasterSecretKeyGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVEParameterGenerator;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVEParameter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import xerial.larray.LBitArray;
import xerial.larray.LByteArray;

public class SHVESpark {


    public static KeyParameter setup(long size) {
        SHVEMasterSecretKeyGenerator generator = new SHVEMasterSecretKeyGenerator();
        generator.init(new SHVEMasterSecretKeyGenerationParameter(genBinaryParam(size)));

        return generator.generateKey();
    }

    private static SHVEParameter genBinaryParam(long size) {
        SHVEParameterGenerator generator = new SHVEParameterGenerator();
        generator.init(size);

        return generator.generateParameters();
    }


    public static KeyParameter keyGen(KeyParameter masterSecretKey, LBitArray pattern) {
        return null;
    }

    public static LByteArray enc(KeyParameter masterSecretKey, LBitArray attributes) {
        return null;
    }

    public static void main(String[] args) {
        long n = 10000000;
        long start, end;
        SparkConf sparkConf = new SparkConf().setAppName("HVE").setMaster("local[2]");
        JavaSparkContext spark = new JavaSparkContext(sparkConf);

        KeyParameter MSK = setup(n);

        spark.stop();
    }
}
