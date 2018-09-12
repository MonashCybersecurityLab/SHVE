package edu.monash.shangqi.hve.param;

import edu.monash.shangqi.hve.param.impl.SHVEParameter;

/**
 * Key parameter of SHVE scheme. Depending on the type of the key (msk or sk),
 * it keeps the length of the index or predicate vector.
 * (msk--index; sk--predicate)
 *
 * @author Shangqi
 */
public class SHVEKeyParameter extends KeyParameter {

    // the parameter of SHVE instance
    private SHVEParameter parameter;

    public SHVEKeyParameter(boolean isMaster, SHVEParameter parameter) {
        super(isMaster);
        this.parameter = parameter;
    }

    public SHVEParameter getParameter() {
        return this.parameter;
    }
}
