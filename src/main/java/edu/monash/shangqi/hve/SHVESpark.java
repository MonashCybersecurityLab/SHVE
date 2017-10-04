package edu.monash.shangqi.hve;

import edu.monash.shangqi.hve.generator.impl.SHVEMasterSecretKeyGenerator;
import edu.monash.shangqi.hve.generator.impl.SHVEParameterGenerator;
import edu.monash.shangqi.hve.param.KeyParameter;
import edu.monash.shangqi.hve.param.impl.SHVEMasterSecretKeyGenerationParameter;
import edu.monash.shangqi.hve.param.impl.SHVEParameter;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import xerial.larray.LBitArray;
import xerial.larray.LByteArray;
import xerial.larray.LLongArray;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

    public static LByteArray enc(JavaSparkContext spark, KeyParameter masterSecretKey, LBitArray attributes) {

        // todo: encrypt some vector in parallel
        // 1. broadcast a large array
        Broadcast<LBitArray> broadcastBitArray = spark.broadcast(attributes);
        // 2. generate an index=>byte[] map as output
        JavaRDD index = spark.parallelize(new ArrayList<>());


        return null;
    }

    public static boolean evaluate(KeyParameter secretKey, LByteArray ct) {
        return false;
    }

    public static void main(String[] args) {
        long n = 3000000000L;
        long start, end;
        SparkConf sparkConf = new SparkConf().setAppName("HVE").setMaster("local[2]");
        sparkConf.set("spark.serializer", "org.apache.spark.serializer.KryoSerializer")
                .set("spark.kryoserializer.buffer.max", "512")
                .registerKryoClasses(new Class<?>[]{LBitArray.class});
        JavaSparkContext spark = new JavaSparkContext(sparkConf);

        KeyParameter MSK = setup(n);    // todo: save master key in local
        LBitArray attributes = new LBitArray(n);
        attributes.fill();
        attributes.update(2, false);
        attributes.update(3, false);
        enc(spark, MSK, attributes);

        spark.stop();
    }
}
