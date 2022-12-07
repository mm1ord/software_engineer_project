package com.douyin.search.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import com.douyin.search.engine.model.SortBean;

public class SerachBase {
    private HashMap<String, Object> details = new HashMap<String, Object>();
    private final static int maxLength = Character.MAX_VALUE;
    @SuppressWarnings("unchecked")
    private HashSet<String>[] keySearch = new HashSet[maxLength];

    private static class lazyLoadSerachBase {
        private static final SerachBase serachBase = new SerachBase();
    }

    private  SerachBase() {

    }

    public static SerachBase getSerachBase() {
        return lazyLoadSerachBase.serachBase;
    }

    public Object getObject(String id) {
        return details.get(id);
    }

    public List<Object> getObjects(String ids) {
        if (ids == null || "".equals(ids)) {
            return null;
        }
        List<Object> objs = new ArrayList<Object>();
        String[] idArray = ids.split(",");
        for (String id : idArray) {
            objs.add(getObject(id));
        }
        return objs;
    }

    public String getIds(String key) {
        if (key == null || "".equals(key)) {
            return null;
        }
        HashMap<String, Integer> idTimes = new HashMap<String, Integer>();
        HashSet<String> ids = new HashSet<String>();

        for (int i = 0; i < key.length(); i++) {
            int at = key.charAt(i);
            if (keySearch[at] == null) {
                continue;
            }
            for (Object obj : keySearch[at].toArray()) {
                String id = (String) obj;
                int times = 1;
                if (ids.contains(id)) {
                    times += idTimes.get(id);
                    idTimes.put(id, times);
                } else {
                    ids.add(id);
                    idTimes.put(id, times);
                }
            }
        }

        List<SortBean> sortBeans = new ArrayList<SortBean>();
        for (String id : ids) {
            SortBean sortBean = new SortBean();
            sortBeans.add(sortBean);
            sortBean.setId(id);
            sortBean.setTimes(idTimes.get(id));
        }
        Collections.sort(sortBeans, new Comparator<SortBean>(){
            public int compare(SortBean o1, SortBean o2){
                return o2.getTimes() - o1.getTimes();
            }
        });

        StringBuffer sb = new StringBuffer();
        for (SortBean sortBean : sortBeans) {
            sb.append(sortBean.getId());
            sb.append(",");
        }

        idTimes.clear();
        idTimes = null;
        ids.clear();
        ids = null;
        sortBeans.clear();
        sortBeans = null;

        return sb.toString();
    }

    public void add(String id, String searchKey, Object obj) {
        if (id == null || searchKey == null || obj == null) {
            return;
        }
        details.put(id, obj);
        addSearchKey(id, searchKey);
    }

    private void addSearchKey(String id, String searchKey) {
        if (id == null || searchKey == null) {
            return;
        }
        for (int i = 0; i < searchKey.length(); i++) {
            int at = searchKey.charAt(i);
            if (keySearch[at] == null) {
                HashSet<String> value = new HashSet<String>();
                keySearch[at] = value;
            }
            keySearch[at].add(id);
        }
    }



}
