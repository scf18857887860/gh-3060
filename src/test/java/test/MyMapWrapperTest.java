package test;

import static org.junit.Assert.*;

import java.util.LinkedHashMap;

import org.apache.ibatis.reflection.DefaultReflectorFactory;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.junit.Test;

public class MyMapWrapperTest {

  @Test
  public void demoCustomMapWrapper() {
    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    MetaObject metaObj = MetaObject.forObject(map,
        new DefaultObjectFactory(),
        new MyObjectWrapperFactory(),
        new DefaultReflectorFactory());
    metaObj.setValue("100[a]", "x");

    assertEquals("x", map.get("100[a]"));
  }

  @Test
  public void demoDefaultMapWrapper() {
    LinkedHashMap<String, Object> map = new LinkedHashMap<>();
    MetaObject metaObj = MetaObject.forObject(map,
        new DefaultObjectFactory(),
        new DefaultObjectWrapperFactory(),
        new DefaultReflectorFactory());
    // The following line throws the NumberFormatException
    metaObj.setValue("100[a]", "x");
  }

}
