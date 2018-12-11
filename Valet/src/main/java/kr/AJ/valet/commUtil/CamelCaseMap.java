package kr.AJ.valet.commUtil;

import java.util.HashMap;

@SuppressWarnings({ "serial", "rawtypes" ,"unchecked"})
public class CamelCaseMap extends HashMap{

    @Override
    public Object put(Object key, Object value) {
        return super.put(DataUtils.convertCamelCase(String.valueOf(key)), value);
    }
}
