package com.devsuperior.dscatalog.utils;

import com.devsuperior.dscatalog.projections.IdProjection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utils {

    public static <ID> List<? extends IdProjection<ID>> replace(List<? extends IdProjection<ID>> orderedList, List<? extends IdProjection<ID>> unorderedList) {

        // Using the Map structure because it is way faster to reach an element than List
        Map<ID, IdProjection<ID>> map = new HashMap<>();
        for (IdProjection<ID> obj : unorderedList) {
            map.put(obj.getId(), obj);
        }

        List<IdProjection<ID>> result = new ArrayList<>();
        for (IdProjection<ID> obj : orderedList) {
            result.add(map.get(obj.getId()));
        }

        return result;
    }
}
