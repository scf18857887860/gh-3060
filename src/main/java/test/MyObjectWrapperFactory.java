package test;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.wrapper.ObjectWrapper;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;

public class MyObjectWrapperFactory implements ObjectWrapperFactory {

  @Override
  public boolean hasWrapperFor(Object object) {
    return object instanceof LinkedHashMap;
  }

  @SuppressWarnings("unchecked")
  @Override
  public ObjectWrapper getWrapperFor(MetaObject metaObject, Object object) {
    return new MyMapWrapper(metaObject, (Map<String, Object>) object);
  }

}
