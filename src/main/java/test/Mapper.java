package test;

import cn.hutool.json.JSONObject;

import java.util.LinkedHashMap;
import java.util.List;

public interface Mapper {
  User getUser(Integer id);

  void insertUser(User user);


  List<LinkedHashMap<String, ?>> queryListByDynamicSql(JSONObject params);
}
