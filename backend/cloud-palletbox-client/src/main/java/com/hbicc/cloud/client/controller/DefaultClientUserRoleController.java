package com.hbicc.cloud.client.controller;
import java.util.Map;
import com.hbicc.cloud.client.rpc.DefaultClientUserRoleRpc;
import com.hbicc.cloud.client.utils.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/default_client_user_role")
public class DefaultClientUserRoleController {
    @Autowired
    DefaultClientUserRoleRpc defaultClientUserRoleRpc;
    @PostMapping("getList")
    public String getList(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.getList(MyUtil.clientIdWhere(json, userInfo));
    }
    @PostMapping("getInfo")
    public String getInfo(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.getInfo(json);
    }
    @PostMapping("addInfo")
    public String addInfo(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.addInfo(MyUtil.clientIdAdd(json, userInfo));
    }
    @PostMapping("delInfo")
    public String delInfo(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.delInfo(json);
    }
    @PostMapping("saveInfo")
    public String saveInfo(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.saveInfo(json);
    }
    @PostMapping("getFieldParam")
    public String getFieldParam(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.getFieldParam(json);
    }
/*
    @PostMapping("getAllList")
    public String getAllList(@RequestBody  String json, @RequestAttribute("user_info") Map<String, Object> userInfo) {
        return defaultClientUserRoleRpc.getAllList(json);
    }
*/
}
