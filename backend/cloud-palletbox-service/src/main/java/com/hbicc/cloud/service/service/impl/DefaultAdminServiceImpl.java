package com.hbicc.cloud.service.service.impl;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.date.DateUtil;
//import cn.hutool.core.util.IdUtil;
//import cn.hutool.core.lang.Snowflake;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hbicc.cloud.service.entity.DefaultAdmin;
import com.hbicc.cloud.service.mapper.DefaultAdminMapper;
import com.hbicc.cloud.service.service.IDefaultAdminService;
import com.hbicc.cloud.service.utils.MyUtil;
import com.hbicc.cloud.common.utils.SearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class DefaultAdminServiceImpl extends ServiceImpl<DefaultAdminMapper, DefaultAdmin> implements IDefaultAdminService {


    @Override
    public Map<String, Object> page(JSONObject where, JSONArray orderBy, Integer page, Integer limit) {
        Map<String, Object> result = new LinkedHashMap<>();
        IPage<DefaultAdmin> wherePage = new Page<>(page, limit);
        QueryWrapper<DefaultAdmin> queryDefaultAdmin = null;
        queryDefaultAdmin = SearchUtil.parseWhereSql(where);
        if(orderBy.size() < 1){
            queryDefaultAdmin.orderByDesc("user_id");
        }else if(orderBy.size() == 2){
            if("DESC".equals(orderBy.getStr(1))){
                queryDefaultAdmin.orderByDesc(orderBy.getStr(0));
            }else{
                queryDefaultAdmin.orderByAsc(orderBy.getStr(0));
            }
        }
        IPage<DefaultAdmin> re = baseMapper.selectPage(wherePage, queryDefaultAdmin);
        List<DefaultAdmin> records = re.getRecords();
        result.put("records", records);
        Long total = re.getTotal();
        result.put("total", total);
        return result;
    }


    @Override
    public Map<String, Object> all(JSONObject where, JSONArray orderBy) {
        Map<String, Object> result = new LinkedHashMap<>();
        // ????????????
        QueryWrapper<DefaultAdmin> queryDefaultAdmin = null;
        queryDefaultAdmin = SearchUtil.parseWhereSql(where);
        if(orderBy.size() < 1){
            queryDefaultAdmin.orderByDesc("user_id");
        }else if(orderBy.size() == 2){
            if("DESC".equals(orderBy.getStr(1))){
                queryDefaultAdmin.orderByDesc(orderBy.getStr(0));
            }else{
                queryDefaultAdmin.orderByAsc(orderBy.getStr(0));
            }
        }
        List<DefaultAdmin> records = baseMapper.selectList(queryDefaultAdmin);
        result.put("records", records);
        return result;
    }

    /**
     * ??????id??????
     * @param  id id
     * @return
     */
    @Override
    public DefaultAdmin info(String id) {
        return baseMapper.selectById(id);
    }

    /**
     * ?????????Admin
     * @param  defaultAdmin ?????????.
     * @return
     */
    @Override
    public int add(DefaultAdmin defaultAdmin) {
        // ??????
        defaultAdmin.setCtime(DateUtil.now());
        return baseMapper.insert(defaultAdmin);
    }

    /**
     * ??????Admin??????
     * @param  defaultAdmin ?????????.
     * @return
     */
    @Override
    public int update(DefaultAdmin defaultAdmin) {
        defaultAdmin.setMtime(DateUtil.now());
        return baseMapper.updateById(defaultAdmin);
    }



    @Override
    public int delete(String id) {
        return baseMapper.deleteById(id);
    }



    @Override
    public Map<String, Object> param(String field, JSONObject where) {
        if ("is_valid".equals(field)) {
            Map<String, Object> result = new LinkedHashMap<String, Object>();
            result.put("0", "??????");
            result.put("1", "??????");
            return result;
        }
        return null;
    }


}